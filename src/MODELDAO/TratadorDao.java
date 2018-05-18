package MODELDAO;

import IGenerics.IGenerics;
import Model.Tratador;
import CONECTION.ConnectionFactory;
import Model.BoletimDiario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TratadorDao implements IGenerics<Tratador, Integer> {

    @Override
    public void inserir(Tratador t) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();

        String sql = "INSERT INTO tratador (nome_tratador, telefone_tratador, endereco_tratador)"
                + " VALUES(?,?,?);";
        PreparedStatement psm = c.prepareStatement(sql);
        psm.setString(1, t.getNome_tratador());
        psm.setString(2, t.getTelefone_tratador());
        psm.setString(3, t.getEndereco_tratador());
        psm.executeUpdate();
    }

    @Override
    public void apagar(Tratador t) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();

        String sql = "DELETE FROM "
                + "tratador WHERE id_tratador = ?;";

        PreparedStatement pst = c.prepareStatement(sql);

        pst.setInt(1, t.getId_tratador());

        pst.executeUpdate();
    }

    @Override
    public void alterar(Tratador obj) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    @Override
    public List<Tratador> buscarTodos() throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();

        String sql = "SELECT * FROM tratador;";

        PreparedStatement pst = c.prepareStatement(sql);

        ResultSet rs = pst.executeQuery();
        List<Tratador> trt = new ArrayList<>();

        while (rs.next()) {
            Tratador t = new Tratador();
            t.setId_tratador(rs.getInt("id_tratador"));
            t.setNome_tratador(rs.getString("nome_tratador"));
            t.setTelefone_tratador(rs.getString("telefone_tratador"));
            t.setEndereco_tratador(rs.getString("endereco_tratador"));

            trt.add(t);
        }
        return trt;
    }

    public Tratador buscarUm(Integer id) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();

        String sql = "SELECT * from tratador where id_tratador = ?;";

        PreparedStatement pst = c.prepareStatement(sql);

        pst.setInt(1, id);

        Tratador t = new Tratador();
        
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            t.setId_tratador(rs.getInt("id_tratador"));
            t.setNome_tratador(rs.getString("nome_tratador"));
            t.setTelefone_tratador(rs.getString("telefone_tratador"));
            t.setEndereco_tratador(rs.getString("endereco_tratador"));
        }

        return t;
    }
    
    public Tratador buscarPeloNome(String nome_tratador) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();
        
        String sql = "SELECT * FROM tratador WHERE nome_tratador LIKE ?;";
        
        PreparedStatement pst = c.prepareStatement(sql);
        
        pst.setString(1, "%"+nome_tratador+"%");
        
        ResultSet rs = pst.executeQuery(); 
        
        
        Tratador tratadores = new Tratador();
        
        while(rs.next()){
            Tratador trat = new Tratador(rs.getInt("id_tratador"), rs.getString("nome_tratador"),
            rs.getString("telefone_tratador"),
            rs.getString("endereco_tratador"));
                    
                     return trat;       
        }   
        return tratadores;
    }
    
    
    public List<Tratador> buscarPeloNome2(String nome_tratador) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();
        
        String sql = "SELECT * FROM tratador WHERE nome_tratador LIKE ?;";
        
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setString(1, "%"+nome_tratador+"%");
        ResultSet rs = pst.executeQuery(); 
        
        List<Tratador> tratadores = new ArrayList<>();
                
        while(rs.next()){
            Tratador trat = new Tratador(rs.getInt("id_tratador"), rs.getString("nome_tratador"),
            rs.getString("telefone_tratador"),
            rs.getString("endereco_tratador"));
                            
            tratadores.add(trat);
        }   
        
        return tratadores;
    }
}
