package Model;
public class Tratador {
          private int id_tratador;
          private String nome_tratador;
          private String telefone_tratador;
          private String endereco_tratador;

    public Tratador() {
    }

    public Tratador(int id_tratador, String nome_tratador, String telefone_tratador, String endereco_tratador) {
        this.id_tratador = id_tratador;
        this.nome_tratador = nome_tratador;
        this.telefone_tratador = telefone_tratador;
        this.endereco_tratador = endereco_tratador;
    }

    public Tratador(int id_tratador) {
        this.id_tratador = id_tratador;
    }
    
    
    
    
    public int getId_tratador() {
        return id_tratador;
    }

    public void setId_tratador(int id_tratador) {
        this.id_tratador = id_tratador;
    }

    public String getNome_tratador() {
        return nome_tratador;
    }

    public void setNome_tratador(String nome_tratador) {
        this.nome_tratador = nome_tratador;
    }

    public String getTelefone_tratador() {
        return telefone_tratador;
    }

    public void setTelefone_tratador(String telefone_tratador) {
        this.telefone_tratador = telefone_tratador;
    }

    public String getEndereco_tratador() {
        return endereco_tratador;
    }

    public void setEndereco_tratador(String endereco_tratador) {
        this.endereco_tratador = endereco_tratador;
    }
        
}
