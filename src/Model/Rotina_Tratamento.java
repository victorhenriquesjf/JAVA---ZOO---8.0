package Model;

import Model.Animal;
import Model.Tarefa;
import Model.Tratador;

public class Rotina_Tratamento {

    private int id_rotina;
    private String data_validade;
    private Tarefa Tarefa_rotina;
    private Tratador Tratador_rotina;
    private Animal Animal_rotina;
   

    public Rotina_Tratamento() {
    }

    public Rotina_Tratamento(int id_rotina, String data_validade, Tarefa Tarefa_rotina, Tratador Tratador_rotina, Animal Animal_rotina) {
        this.id_rotina = id_rotina;
        this.data_validade = data_validade;
        this.Tarefa_rotina = Tarefa_rotina;
        this.Tratador_rotina = Tratador_rotina;
        this.Animal_rotina = Animal_rotina;
       
    }

    public Rotina_Tratamento(int id_rotina) {
        this.id_rotina = id_rotina;
    }

    public int getId_rotina() {
        return id_rotina;
    }

    public void setId_rotina(int id_rotina) {
        this.id_rotina = id_rotina;
    }

    public Tarefa getTarefa_rotina() {
        return Tarefa_rotina;
    }

    public String getData_validade() {
        return data_validade;
    }

    public void setData_validade(String data_validade) {
        this.data_validade = data_validade;
    }

    public void setTarefa_rotina(Tarefa Tarefa_rotina) {
        this.Tarefa_rotina = Tarefa_rotina;
    }

    public Tratador getTratador_rotina() {
        return Tratador_rotina;
    }

    public void setTratador_rotina(Tratador Tratador_rotina) {
        this.Tratador_rotina = Tratador_rotina;
    }

    public Animal getAnimal_rotina() {
        return Animal_rotina;
    }

    public void setAnimal_rotina(Animal Animal_rotina) {
        this.Animal_rotina = Animal_rotina;
    }

}
