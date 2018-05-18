package Model;

public class Veterinario {

    private int id_veterinario;
    private String nome_veterinario;
    private String telefone_veterinario;
    private String endereco_veterinario;
    private String data_emissao;
    private int num_conselho;

    public Veterinario() {
    }

    public Veterinario(int id_veterinario, String nome_veterinario, String telefone_veterinario, String endereco_veterinario, String data_emissao, int num_conselho) {
        this.id_veterinario = id_veterinario;
        this.nome_veterinario = nome_veterinario;
        this.telefone_veterinario = telefone_veterinario;
        this.endereco_veterinario = endereco_veterinario;
        this.data_emissao = data_emissao;
        this.num_conselho = num_conselho;
    }

    public Veterinario(int id_veterinario) {
        this.id_veterinario = id_veterinario;
    }

    public int getId_veterinario() {
        return id_veterinario;
    }

    public void setId_veterinario(int id_veterinario) {
        this.id_veterinario = id_veterinario;
    }

    public String getNome_veterinario() {
        return nome_veterinario;
    }

    public void setNome_veterinario(String nome_veterinario) {
        this.nome_veterinario = nome_veterinario;
    }

    public String getTelefone_veterinario() {
        return telefone_veterinario;
    }

    public void setTelefone_veterinario(String telefone_veterinario) {
        this.telefone_veterinario = telefone_veterinario;
    }

    public String getEndereco_veterinario() {
        return endereco_veterinario;
    }

    public void setEndereco_veterinario(String endereco_veterinario) {
        this.endereco_veterinario = endereco_veterinario;
    }

    public String getData_emissao() {
        return data_emissao;
    }

    public void setData_emissao(String data_emissao) {
        this.data_emissao = data_emissao;
    }

    public int getNum_conselho() {
        return num_conselho;
    }

    public void setNum_conselho(int num_conselho) {
        this.num_conselho = num_conselho;
    }

}
