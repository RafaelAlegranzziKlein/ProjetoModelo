/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.model;

/**
 *
 * @author rafae
 */
public class Produto {
    
    private Long id;
    private String nome;
    private String codigoBarra;
    private int quantidade;
    private double preco;
    private String categoria;
    private boolean ativo;

    public Produto() {
    }

    public Produto(Long id, String nome, String codigoBarra, int quantidade, double preco, String categoria, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.codigoBarra = codigoBarra;
        this.quantidade = quantidade;
        this.preco = preco;
        this.categoria = categoria;
        this.ativo = ativo;
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

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", nome=" + nome + ", codigoBarra=" + codigoBarra + ", quantidade=" + quantidade + ", preco=" + preco + ", categoria=" + categoria + ", ativo=" + ativo + '}';
    }

    
    
    
}
