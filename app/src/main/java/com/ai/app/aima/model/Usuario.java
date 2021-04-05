package com.ai.app.aima.model;

import com.ai.app.aima.firebase.ConfiguracaoFirebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;

public class Usuario {
    private String id;
    private String nome;
    private String email;
    private String genero;
    private String senha;
    private String srcFoto;

    public Usuario(){}

    public void salvar(){
        DatabaseReference firebaseRef = ConfiguracaoFirebase.getRefFirebase();
        DatabaseReference usuariosRef = firebaseRef.child("usuario").child(getId());
        usuariosRef.setValue(this);
    }

    public String getId() {return id;}

    public void setId(String id) {this.id = id;}

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getGenero() {return genero;}

    public void setGenero(String genero) {this.genero = genero;}

    @Exclude
    public String getSenha() {return senha;}

    public void setSenha(String senha) {this.senha = senha;}

    public String getSrcFoto() {return srcFoto;}

    public void setSrcFoto(String srcFoto) {this.srcFoto = srcFoto;}
}
