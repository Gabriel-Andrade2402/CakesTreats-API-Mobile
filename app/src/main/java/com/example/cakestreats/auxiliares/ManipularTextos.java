package com.example.cakestreats.auxiliares;

public class ManipularTextos {
    public static boolean cfEmail(String email){
        return email.matches("^(?i)[a-z0-9.]+@[a-z0-9]+\\.[a-z]+(\\.[a-z]+)?$");
    }
    public static boolean cfSenha(String senha){
        return senha.matches("^[a-zA-Z0-9]{8,}$");
    }
    public static boolean cfIgualdade(String tx1,String tx2){
        return tx1.equals(tx2);
    }
}
