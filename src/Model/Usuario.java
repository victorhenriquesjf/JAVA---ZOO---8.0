/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;


/**
 *
 * @author aluno
 */
public class Usuario {
    private int idusuario;
    private String nome;
    private String login;
    private String senha;
    private int tipousuario;

    public Usuario() {
    }

    public Usuario(int idusuario, String nome, String login, String senha, int tipousuario) {
        this.idusuario = idusuario;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.tipousuario = tipousuario;
    }

    public Usuario(int idusuario) {
        this.idusuario = idusuario;
    }

    

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getTipousuario() {
        return tipousuario;
    }

    public void setTipousuario(int tipousuario) {
        this.tipousuario = tipousuario;
    }
   
    
    
 

}