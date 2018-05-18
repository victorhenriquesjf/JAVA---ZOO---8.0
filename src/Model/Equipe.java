package Model;

public class Equipe {

    private int id_equipe;
    private Tratador tratador_principal;
    private Tratador tratador_1;
    private Tratador tratador_2;
    private Tratador tratador_3;

    public Equipe() {
    }

    public Equipe(int id_equipe, Tratador tratador_principal, Tratador tratador_1, Tratador tratador_2, Tratador tratador_3) {
        this.id_equipe = id_equipe;
        this.tratador_principal = tratador_principal;
        this.tratador_1 = tratador_1;
        this.tratador_2 = tratador_2;
        this.tratador_3 = tratador_3;
    }

    public Equipe(int id_equipe) {
        this.id_equipe = id_equipe;
    }

    
    public int getId_equipe() {
        return id_equipe;
    }

    public void setId_equipe(int id_equipe) {
        this.id_equipe = id_equipe;
    }

    public Tratador getTratador_principal() {
        return tratador_principal;
    }

    public void setTratador_principal(Tratador tratador_principal) {
        this.tratador_principal = tratador_principal;
    }

    public Tratador getTratador_1() {
        return tratador_1;
    }

    public void setTratador_1(Tratador tratador_1) {
        this.tratador_1 = tratador_1;
    }

    public Tratador getTratador_2() {
        return tratador_2;
    }

    public void setTratador_2(Tratador tratador_2) {
        this.tratador_2 = tratador_2;
    }

    public Tratador getTratador_3() {
        return tratador_3;
    }

    public void setTratador_3(Tratador tratador_3) {
        this.tratador_3 = tratador_3;
    }

}
