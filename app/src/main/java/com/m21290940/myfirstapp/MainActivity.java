package com.m21290940.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.m21290940.myfirstapp.usuarios.UserDashboardActivity;
import com.m21290940.myfirstapp.usuarios.repository.UsersRepository;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private HashMap<String, String> registeredusers;
    private UsersRepository ur;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        registeredusers = new HashMap<String, String>();
        ur = UsersRepository.getInstance();

        //registeredusers.put("perro", "Mama huevo");
        //registeredusers.put("El brayan", "filero123");
        //registeredusers.put("La britanis", "Amo a brayan");

        //Nuevo comentario

    }

    public void onBtnIngresarTap(View view) {
        AlertDialog.Builder builder = new AlertDialog
                .Builder(this);

        // Enlazando los elementos del layout
        EditText etUsuario = findViewById(R.id.etUsuario);
        EditText etPass    = findViewById(R.id.etPass);
        //Extrayendo los valores ingresados por usuario
        String user, pass;
        user = etUsuario.getText().toString();
        pass = etPass.getText().toString();

        if ( !ur.getRegisteredUsers().containsKey(user)) {
            builder.setTitle("Atención")
                    .setMessage("Usuario no registrado");
            AlertDialog dialog = builder.create();
            dialog.show();
            return;
        }

        // Preguntando si la contraseña no es la correcta
        if ( !ur.getRegisteredUsers().get(user).containsKey(pass) ){
            builder.setTitle("Atención")
                    .setMessage("Contraseña incorrecta");
            AlertDialog dialog = builder.create();
            dialog.show();
            return;
        }

        Toast.makeText(this, "Felicidades, has iniciado sesión exitosamente", Toast.LENGTH_LONG).show();

        Intent intent = new
                Intent(this, UserDashboardActivity.class);
        intent.putExtra("usuario", user);
        intent.putExtra("pass", pass);
        startActivity(intent);
    }
}