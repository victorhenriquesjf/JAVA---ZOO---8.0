/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author aluno
 */
public class Vacina {

   
    private int idvacina;
    private String nome;

    public Vacina() {
    }

    public Vacina(int idvacina, String nome) {
        this.idvacina = idvacina;
        this.nome = nome;
    }

    public int getIdvacina() {
        return idvacina;
    }

    public void setIdvacina(int idvacina) {
        this.idvacina = idvacina;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Vacina(int idvacina) {
        this.idvacina = idvacina;
    }

    
    
    
    
}