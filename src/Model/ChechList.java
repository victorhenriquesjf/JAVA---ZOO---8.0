package Model;
public class ChechList {
     private int id_rotinaCK;
    private String data_validadeCK;
    private Tarefa Tarefa_rotinaCK;
    private Tratador Tratador_rotinaCK;
    private Animal Animal_rotinaCK;

    public ChechList() {
    }

    public ChechList(int id_rotina, String data_validade, Tarefa Tarefa_rotina, Tratador Tratador_rotina, Animal Animal_rotina) {
        this.id_rotinaCK = id_rotina;
        this.data_validadeCK = data_validade;
        this.Tarefa_rotinaCK = Tarefa_rotina;
        this.Tratador_rotinaCK = Tratador_rotina;
        this.Animal_rotinaCK = Animal_rotina;
    }

    public int getId_rotinaCK() {
        return id_rotinaCK;
    }

    public void setId_rotinaCK(int id_rotinaCK) {
        this.id_rotinaCK = id_rotinaCK;
    }

    public String getData_validadeCK() {
        return data_validadeCK;
    }

    public void setData_validadeCK(String data_validadeCK) {
        this.data_validadeCK = data_validadeCK;
    }

    public Tarefa getTarefa_rotinaCK() {
        return Tarefa_rotinaCK;
    }

    public void setTarefa_rotinaCK(Tarefa Tarefa_rotinaCK) {
        this.Tarefa_rotinaCK = Tarefa_rotinaCK;
    }

    public Tratador getTratador_rotinaCK() {
        return Tratador_rotinaCK;
    }

    public void setTratador_rotinaCK(Tratador Tratador_rotinaCK) {
        this.Tratador_rotinaCK = Tratador_rotinaCK;
    }

    public Animal getAnimal_rotinaCK() {
        return Animal_rotinaCK;
    }

    public void setAnimal_rotinaCK(Animal Animal_rotinaCK) {
        this.Animal_rotinaCK = Animal_rotinaCK;
    }
   
    

}
