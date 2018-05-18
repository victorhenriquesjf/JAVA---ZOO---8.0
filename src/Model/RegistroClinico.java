/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/*idregistroclinico int(11) AI PK 
diagnostico varchar(50) 
tipoatendimento varchar(45) 
observacoes varchar(@author aluno
 */
public class RegistroClinico {
    
    private int idregistroclinico;
    private String diagnostico;
    private String tipoatendimento;
    private String observacoes;

    public RegistroClinico() {
    }

    public RegistroClinico(int idregistroclinico) {
        this.idregistroclinico = idregistroclinico;
    }

    public RegistroClinico(int idregistroclinico, String diagnostico, String tipoatendimento, String observacoes) {
        this.idregistroclinico = idregistroclinico;
        this.diagnostico = diagnostico;
        this.tipoatendimento = tipoatendimento;
        this.observacoes = observacoes;
    }

    public int getIdregistroclinico() {
        return idregistroclinico;
    }

    public void setIdregistroclinico(int idregistroclinico) {
        this.idregistroclinico = idregistroclinico;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTipoatendimento() {
        return tipoatendimento;
    }

    public void setTipoatendimento(String tipoatendimento) {
        this.tipoatendimento = tipoatendimento;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
    
    
    
    
}
