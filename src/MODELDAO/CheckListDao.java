package MODELDAO;

import CONECTION.ConnectionFactory;
import IGenerics.IGenerics;
import Model.Animal;
import Model.ChechList;
import Model.Rotina_Tratamento;
import Model.Tarefa;
import Model.Tratador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CheckListDao implements IGenerics<ChechList, Integer>{

    @Override
    public void inserir(ChechList ch) throws ClassNotFoundException, SQLException {
       Connection c = ConnectionFactory.getConnection();

        String sql = "INSERT INTO chechlist(id_rotinaCK, data_realizada, Tarefa_rotina, Tratador_rotinaCK,Animal_rotinaCK)"
                + " VALUES(?,?,?,?,?);";
        PreparedStatement psm = c.prepareStatement(sql);
       
        psm.setInt(1, ch.getId_rotinaCK());
        psm.setString(2, ch.getData_validadeCK());
        psm.setInt(3, ch.getTarefa_rotinaCK().getIdtarefa());
        psm.setInt(4, ch.getTratador_rotinaCK().getId_tratador());
        psm.setInt(5, ch.getAnimal_rotinaCK().getId_animal());
       
        
        psm.executeUpdate();
    }

  
    @Override
    public void apagar(ChechList obj) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(ChechList obj) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ChechList buscarUm(Integer id) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ChechList> buscarTodos() throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();

        String sql = "SELECT * FROM chechlist;";

        PreparedStatement pst = c.prepareStatement(sql);

        ResultSet rs = pst.executeQuery();

        List<ChechList> chech = new ArrayList<>();

        while (rs.next()) {
            ChechList che = new ChechList();

            che.setId_rotinaCK(rs.getInt("id_rotinaCK"));
            che.setData_validadeCK(rs.getString("data_realizada"));

            Tarefa ta = new TarefaDao().buscarUm(rs.getInt("Tarefa_rotina"));
            che.setTarefa_rotinaCK(ta);

            Tratador tr = new TratadorDao().buscarUm(rs.getInt("Tratador_rotinaCK"));
            che.setTratador_rotinaCK(tr);

            Animal a = new AnimalDao().buscarUm(rs.getInt("Animal_rotinaCK"));
            che.setAnimal_rotinaCK(a);

           

            chech.add(che);
        }
        return chech;
        
        
        
        
        
    }
    
}


