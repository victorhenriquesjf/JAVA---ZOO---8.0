package Model;

public class Receita {

    private int idreceita;
    private String dataaviada;
    private String observacoes;
    private String nomemedicamento;
    private String dose;
    private String frequencia;
    private String nomeanimal;
    private Veterinario veterinario;

    public Receita() {
    }

    public Receita(int idreceita, String dataaviada, String observacoes, String nomemedicamento, String dose, String frequencia, String nomeanimal, Veterinario veterinario) {
        this.idreceita = idreceita;
        this.dataaviada = dataaviada;
        this.observacoes = observacoes;
        this.nomemedicamento = nomemedicamento;
        this.dose = dose;
        this.frequencia = frequencia;
        this.nomeanimal = nomeanimal;
        this.veterinario = veterinario;
    }

    public Receita(int idreceita) {
        this.idreceita = idreceita;
    }

    public String getNomeanimal() {
        return nomeanimal;
    }

    public void setNomeanimal(String nomeanimal) {
        this.nomeanimal = nomeanimal;
    }

    public int getIdreceita() {
        return idreceita;
    }

    public void setIdreceita(int idreceita) {
        this.idreceita = idreceita;
    }

    public String getDataaviada() {
        return dataaviada;
    }

    public void setDataaviada(String dataaviada) {
        this.dataaviada = dataaviada;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getNomemedicamento() {
        return nomemedicamento;
    }

    public void setNomemedicamento(String nomemedicamento) {
        this.nomemedicamento = nomemedicamento;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(String frequencia) {
        this.frequencia = frequencia;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }
    

}
