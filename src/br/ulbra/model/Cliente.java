/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.model;
// @Rafael

public class Cliente {

    private long id;
    private String nomeclien;
    private String cpf;
    private String datanasc;

    public Cliente() {
    }

    public Cliente(long id, String nomeclien, String cpf, String datanasc) {
        this.id = id;
        this.nomeclien = nomeclien;
        this.cpf = cpf;
        this.datanasc = datanasc;
    }

    public long getId() {
        return id;
    }

    public String getNomeclien() {
        return nomeclien;
    }

    public String getCpf() {
        return cpf;
    }

    public String getDatanasc() {
        return datanasc;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNomeclien(String nomeclien) {
        this.nomeclien = nomeclien;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setDatanasc(String datanasc) {
        this.datanasc = datanasc;
    }

}
