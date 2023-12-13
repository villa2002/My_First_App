package com.m21290940.myfirstapp.usuarios.repository;

import com.m21290940.myfirstapp.usuarios.model.Usuario;

import java.util.HashMap;

public class UsersRepository {
    private static UsersRepository _instance = null;
    private HashMap< String, HashMap< String, Usuario> > registeredUsers;

    private UsersRepository() {
        registeredUsers = new HashMap< String, HashMap< String, Usuario> >();
        Usuario user1 = new Usuario("perro", "Mama huevo", "Yael Alejandro", 28, 'h', "yael@gmil.com");
        Usuario user2 = new Usuario("brayan", "filero123", "Brayan Kevin", 22, 'h', "brayan@gmil.com");
        Usuario user3 = new Usuario("britanis", "1234", "Britany Carmela", 18, 'm', "britnanis@gmil.com");

        registeredUsers.put(user1.getUsuario(), new HashMap< String, Usuario>());
        registeredUsers.get(user1.getUsuario()).put(user1.getPass(), user1);

        registeredUsers.put(user2.getUsuario(), new HashMap< String, Usuario>());
        registeredUsers.get(user2.getUsuario()).put(user2.getPass(), user2);

        registeredUsers.put(user3.getUsuario(), new HashMap< String, Usuario>());
        registeredUsers.get(user3.getUsuario()).put(user3.getPass(), user3);
    }

    public static UsersRepository getInstance() {
        if ( _instance == null)
            _instance = new UsersRepository();

        return _instance;
    }

    public HashMap<String, HashMap<String, Usuario>> getRegisteredUsers() {
        return registeredUsers;
    }
}
