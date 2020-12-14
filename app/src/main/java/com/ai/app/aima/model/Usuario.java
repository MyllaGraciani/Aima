package com.ai.app.aima.model;

public class Usuario {
    private String id;
    private String nome;
    private String email;
    private String genero;
    private String senha;
    private String srcFoto;

    public Usuario(){}

    public String getId() {return id;}

    public void setId(String id) {this.id = id;}

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getGenero() {return genero;}

    public void setGenero(String genero) {this.genero = genero;}

    public String getSenha() {return senha;}

    public void setSenha(String senha) {this.senha = senha;}

    public String getSrcFoto() {return srcFoto;}

    public void setSrcFoto(String srcFoto) {this.srcFoto = srcFoto;}
}
