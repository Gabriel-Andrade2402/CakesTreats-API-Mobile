package com.example.cakestreats.Modelos;

import com.example.cakestreats.Enums.CascaOVO;
import com.example.cakestreats.Enums.STATUS;
import com.example.cakestreats.Enums.TIPO;
import com.example.cakestreats.Enums.TipoOVO;
import com.example.cakestreats.Enums.UM;

public class Produtos {
    private Long id;
    private String nome;
    private Double preco;
    private TIPO tipo;
    private TipoOVO tipoOvo;
    private CascaOVO cascaOvo;
    private STATUS status;
    private UM unidadeMedida;

    public Produtos() {
    }

    public Produtos(Long id, String nome, Double preco, TIPO tipo, TipoOVO tipoOvo, CascaOVO cascaOvo, STATUS status, UM unidadeMedida) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.tipo = tipo;
        this.tipoOvo = tipoOvo;
        this.cascaOvo = cascaOvo;
        this.status = status;
        this.unidadeMedida = unidadeMedida;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public TIPO getTipo() {
        return tipo;
    }

    public void setTipo(TIPO tipo) {
        this.tipo = tipo;
    }

    public TipoOVO getTipoOvo() {
        return tipoOvo;
    }

    public void setTipoOvo(TipoOVO tipoOvo) {
        this.tipoOvo = tipoOvo;
    }

    public CascaOVO getCascaOvo() {
        return cascaOvo;
    }

    public void setCascaOvo(CascaOVO cascaOvo) {
        this.cascaOvo = cascaOvo;
    }

    public STATUS getStatus() {
        return status;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }

    public UM getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(UM unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }
}
