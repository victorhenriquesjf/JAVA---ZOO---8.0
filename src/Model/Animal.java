package Model;

public class Animal {

    private int id_animal;
    private String nome_animal;
    private String nascimento_animal;
    private double peso_animal;
    private String origem_animal;
    private String especie_animal;
    private Tratador tratador_animal;
    private String teste;
    public Animal() {
    }

    public Animal(int id_animal, String nome_animal, String nascimento_animal, double peso_animal, String origem_animal, String especie_animal, Tratador tratador_animal) {
        this.id_animal = id_animal;
        this.nome_animal = nome_animal;
        this.nascimento_animal = nascimento_animal;
        this.peso_animal = peso_animal;
        this.origem_animal = origem_animal;
        this.especie_animal = especie_animal;
        this.tratador_animal = tratador_animal;
    }

    public Animal(int id_animal) {
        this.id_animal = id_animal;
    }


    public int getId_animal() {
        return id_animal;
    }

    public void setId_animal(int id_animal) {
        this.id_animal = id_animal;
    }

    public String getNome_animal() {
        return nome_animal;
    }

    public void setNome_animal(String nome_animal) {
        this.nome_animal = nome_animal;
    }

    public String getNascimento_animal() {
        return nascimento_animal;
    }

    public void setNascimento_animal(String nascimento_animal) {
        this.nascimento_animal = nascimento_animal;
    }

    public double getPeso_animal() {
        return peso_animal;
    }

    public void setPeso_animal(double peso_animal) {
        this.peso_animal = peso_animal;
    }

    public String getEspecie_animal() {
        return especie_animal;
    }

    public void setEspecie_animal(String especie_animal) {
        this.especie_animal = especie_animal;
    }

    public Tratador getTratador_animal() {
        return tratador_animal;
    }

    public void setTratador_animal(Tratador tratador_animal) {
        this.tratador_animal = tratador_animal;
    }

    public String getOrigem_animal() {
        return origem_animal;
    }

    public void setOrigem_animal(String origem_animal) {
        this.origem_animal = origem_animal;
    }

    

    
    
}
