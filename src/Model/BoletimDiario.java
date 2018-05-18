/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author v
 */
public class BoletimDiario {
       
    private int idboletimdiario;
    private String dataatual;
    private String diagnostico;
    private String estadoanimal;
    private String observacoes;
    private String nomeanimal;
    

    public BoletimDiario() {
    }

    public BoletimDiario(int idboletimdiario) {
        this.idboletimdiario = idboletimdiario;
    }

    public BoletimDiario(int idboletimdiario, String dataatual, String diagnostico, String estadoanimal, String observacoes, String nomeanimal) {
        this.idboletimdiario = idboletimdiario;
        this.dataatual = dataatual;
        this.diagnostico = diagnostico;
        this.estadoanimal = estadoanimal;
        this.observacoes = observacoes;
        this.nomeanimal = nomeanimal;
    }

    public int getIdboletimdiario() {
        return idboletimdiario;
    }

    public void setIdboletimdiario(int idboletimdiario) {
        this.idboletimdiario = idboletimdiario;
    }

    public String getDataatual() {
        return dataatual;
    }

    public void setDataatual(String dataatual) {
        this.dataatual = dataatual;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getEstadoanimal() {
        return estadoanimal;
    }

    public void setEstadoanimal(String estadoanimal) {
        this.estadoanimal = estadoanimal;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getNomeanimal() {
        return nomeanimal;
    }

    public void setNomeanimal(String nomeanimal) {
        this.nomeanimal = nomeanimal;
    }






    
}