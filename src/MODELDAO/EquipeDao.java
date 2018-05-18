package MODELDAO;

import CONECTION.ConnectionFactory;
import IGenerics.IGenerics;
import Model.Equipe;
import Model.Tratador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EquipeDao implements IGenerics<Equipe, Integer>{

    @Override
    public void inserir(Equipe eq) throws ClassNotFoundException, SQLException {
       Connection c = ConnectionFactory.getConnection();
        
       String sql="INSERT INTO equipe (tratador_principal, tratador_1, tratador_2, tratador_3)VALUES(?,?,?,?);";
       PreparedStatement psm = c.prepareStatement(sql);
       
       psm.setInt(1, eq.getTratador_principal().getId_tratador());
       psm.setInt(2, eq.getTratador_1().getId_tratador());
       psm.setInt(3, eq.getTratador_2().getId_tratador());
       psm.setInt(4, eq.getTratador_3().getId_tratador());
       psm.executeUpdate();
        
    }
    
    @Override
    public void apagar(Equipe eq) throws ClassNotFoundException, SQLException {
         Connection c = ConnectionFactory.getConnection();
        
        
        String sql = "DELETE FROM "
                + "equipe WHERE id_equipe = ?;";

        PreparedStatement pst = c.prepareStatement(sql);

        pst.setInt(1, eq.getId_equipe());

        pst.executeUpdate();
    }

    @Override
    public void alterar(Equipe obj) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Equipe buscarUm(Integer id) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Equipe> buscarTodos() throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();

        String sql = "SELECT * FROM equipe;";

        PreparedStatement pst = c.prepareStatement(sql);

        ResultSet rs = pst.executeQuery();

        List<Equipe> rotina = new ArrayList<>();

        while (rs.next()) {
            Equipe eq = new Equipe();
            
            eq.setId_equipe(rs.getInt("id_equipe"));
            
            Tratador tr = new TratadorDao().buscarUm(rs.getInt("tratador_principal"));
            eq.setTratador_principal(tr);
            
            Tratador t1 = new TratadorDao().buscarUm(rs.getInt("tratador_1"));
            eq.setTratador_1(t1);
            
            Tratador t2 = new TratadorDao().buscarUm(rs.getInt("tratador_2"));
            eq.setTratador_2(t2);
            
             Tratador t3 = new TratadorDao().buscarUm(rs.getInt("tratador_3"));
            eq.setTratador_3(t3);
            
           
            rotina.add(eq);
        }
        return rotina;
    }
    
}
