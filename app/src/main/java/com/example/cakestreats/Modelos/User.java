package com.example.cakestreats.Modelos;

import java.util.List;

public class User {
    private String nome;
    private String email;
    private String telefone;
    private List<Pedido> listPedidos;
    private String senha;
    public User(String nome, String email, String telefone, List<Pedido> listPedidos,String senha) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.listPedidos = listPedidos;
        this.senha=senha;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Pedido> getListPedidos() {
        return listPedidos;
    }

    public void setListPedidos(List<Pedido> listPedidos) {
        this.listPedidos = listPedidos;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
