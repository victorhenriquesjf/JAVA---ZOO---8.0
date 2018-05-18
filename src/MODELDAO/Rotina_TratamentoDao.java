package MODELDAO;

import IGenerics.IGenerics;
import Model.Rotina_Tratamento;
import Model.Tarefa;
import CONECTION.ConnectionFactory;
import Model.Animal;
import Model.RegistroClinico;
import Model.Tratador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Rotina_TratamentoDao implements IGenerics<Rotina_Tratamento, Integer> {

    @Override
    public void inserir(Rotina_Tratamento rt) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();

        String sql = "INSERT INTO rotina_tratamento(data_validade, Tarefa_rotina, Tratador_rotina, Animal_rotina)"
                + " VALUES(?,?,?,?);";
        PreparedStatement psm = c.prepareStatement(sql);

        psm.setString(1, rt.getData_validade());
        psm.setInt(2, rt.getTarefa_rotina().getIdtarefa());
        psm.setInt(3, rt.getTratador_rotina().getId_tratador());
        psm.setInt(4, rt.getAnimal_rotina().getId_animal());
        
        psm.executeUpdate();

    }

    @Override
    public void apagar(Rotina_Tratamento rt) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();

        String sql = "DELETE FROM "
                + "rotina_tratamento WHERE id_rotina = ?;";

        PreparedStatement pst = c.prepareStatement(sql);

        pst.setInt(1, rt.getId_rotina());

        pst.executeUpdate();
    }

    @Override
    public void alterar(Rotina_Tratamento obj) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Rotina_Tratamento buscarUm(Integer id) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Rotina_Tratamento> buscarTodos() throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();

        String sql = "SELECT * FROM rotina_tratamento;";

        PreparedStatement pst = c.prepareStatement(sql);

        ResultSet rs = pst.executeQuery();

        List<Rotina_Tratamento> rotina = new ArrayList<>();

        while (rs.next()) {
            Rotina_Tratamento rt = new Rotina_Tratamento();

            rt.setId_rotina(rs.getInt("id_rotina"));
            rt.setData_validade(rs.getString("data_validade"));

            Tarefa ta = new TarefaDao().buscarUm(rs.getInt("Tarefa_rotina"));
            rt.setTarefa_rotina(ta);

            Tratador tr = new TratadorDao().buscarUm(rs.getInt("Tratador_rotina"));
            rt.setTratador_rotina(tr);

            Animal a = new AnimalDao().buscarUm(rs.getInt("Animal_rotina"));
            rt.setAnimal_rotina(a);

           

            rotina.add(rt);
        }
        return rotina;
    }

    public List<Rotina_Tratamento> buscarPelaData(String data_validade) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();

        String sql = "SELECT * FROM rotina_tratamento WHERE data_validade LIKE ?;";

        PreparedStatement pst = c.prepareStatement(sql);

        pst.setString(1, "%" + data_validade + "%");

        ResultSet rs = pst.executeQuery();

        List<Rotina_Tratamento> rotinas = new ArrayList<>();

        while (rs.next()) {
            Tarefa taf = new TarefaDao().buscarUm(rs.getInt("Tarefa_rotina"));
            Tratador trat = new TratadorDao().buscarUm(rs.getInt("Tratador_rotina"));
            Animal ani = new AnimalDao().buscarUm(rs.getInt("Animal_rotina"));

            Rotina_Tratamento reg = new Rotina_Tratamento(rs.getInt("id_rotina"),
                    rs.getString("data_validade"), taf, trat, ani);

            rotinas.add(reg);
        }

        return rotinas;
    }
    
    public List<Rotina_Tratamento> buscarPeloIdAnimal(Integer id) throws ClassNotFoundException, SQLException {
          Connection c = ConnectionFactory.getConnection();

        String sql = "SELECT * from rotina_tratamento where Animal_rotina = ?;";

        PreparedStatement pst = c.prepareStatement(sql);
        
         pst.setInt(1, id);
         
       ResultSet rs = pst.executeQuery();

        List<Rotina_Tratamento> rotinas = new ArrayList<>();

        while (rs.next()) {
            Tarefa taf = new TarefaDao().buscarUm(rs.getInt("Tarefa_rotina"));
            Tratador trat = new TratadorDao().buscarUm(rs.getInt("Tratador_rotina"));
            Animal ani = new AnimalDao().buscarUm(rs.getInt("Animal_rotina"));

            Rotina_Tratamento reg = new Rotina_Tratamento(rs.getInt("id_rotina"),
                    rs.getString("data_validade"), taf, trat, ani);

            rotinas.add(reg);
        }

        return rotinas;
      
    }
    
    
}
