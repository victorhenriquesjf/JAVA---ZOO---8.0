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
public class Tarefa {
    
    private int idtarefa;
    private String descricao;

    public Tarefa() {
    }

    public Tarefa(int idtarefa) {
        this.idtarefa = idtarefa;
    }

    public Tarefa(int idtarefa, String descricao) {
        this.idtarefa = idtarefa;
        this.descricao = descricao;
    }

    public int getIdtarefa() {
        return idtarefa;
    }

    public void setIdtarefa(int idtarefa) {
        this.idtarefa = idtarefa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
    
}
