package com.example.cakestreats.Modelos;

import com.example.cakestreats.Enums.STATUS;

public class Pedido {
    private STATUS status;
    private User usuario;
    private String dataPedida;
    private String dataEntregue;
    private Produtos produto;

    public Pedido() {
    }

    public Pedido(STATUS status, User usuario, String dataPedida, String dataEntregue, Produtos produto) {
        this.status = status;
        this.usuario = usuario;
        this.dataPedida = dataPedida;
        this.dataEntregue = dataEntregue;
        this.produto = produto;
    }

    public STATUS getStatus() {
        return status;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public String getDataPedida() {
        return dataPedida;
    }

    public void setDataPedida(String dataPedida) {
        this.dataPedida = dataPedida;
    }

    public String getDataEntregue() {
        return dataEntregue;
    }

    public void setDataEntregue(String dataEntregue) {
        this.dataEntregue = dataEntregue;
    }

    public Produtos getProduto() {
        return produto;
    }

    public void setProduto(Produtos produto) {
        this.produto = produto;
    }
}
