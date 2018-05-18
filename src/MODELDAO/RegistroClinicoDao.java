/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELDAO;

import IGenerics.IGenerics;
import Model.Receita;
import Model.RegistroClinico;
import Model.Veterinario;
import CONECTION.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aluno
 */
public class RegistroClinicoDao implements IGenerics<RegistroClinico, Integer>{

    @Override
    public void inserir(RegistroClinico reg) throws ClassNotFoundException, SQLException {
    
        Connection c = ConnectionFactory.getConnection();

        String sql = "INSERT INTO registroclinico (diagnostico, tipoatendimento,observacoes)"
                + " VALUES(?,?,?);";
        
        PreparedStatement psm = c.prepareStatement(sql);
        
        psm.setString(1, reg.getDiagnostico());
        psm.setString(2, reg.getTipoatendimento());
        psm.setString(3, reg.getObservacoes());
        
        
        psm.executeUpdate();
        
   
    
    }
    @Override
    public void apagar(RegistroClinico r) throws ClassNotFoundException, SQLException {
        
        
        Connection c = ConnectionFactory.getConnection();
        
        
        String sql = "DELETE FROM "
                + "registroclinico WHERE idregistroclinico = ?;";

        PreparedStatement pst = c.prepareStatement(sql);

        pst.setInt(1, r.getIdregistroclinico());

        pst.executeUpdate();
        
        
        
        
    }

    @Override
    public void alterar(RegistroClinico obj) throws ClassNotFoundException, SQLException {
        
        
        
        
        
    }

    @Override
    public RegistroClinico buscarUm(Integer id) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<RegistroClinico> buscarTodos() throws ClassNotFoundException, SQLException {
        
        Connection c = ConnectionFactory.getConnection();

        String sql = "SELECT * FROM registroclinico;";

        PreparedStatement pst = c.prepareStatement(sql);

        ResultSet rs = pst.executeQuery();
        
        List<RegistroClinico> reg = new ArrayList<>();

        while (rs.next()) {
            
            RegistroClinico r = new RegistroClinico();
            
            r.setIdregistroclinico(rs.getInt("idregistroclinico"));
            r.setDiagnostico(rs.getString("diagnostico"));
            r.setTipoatendimento(rs.getString("tipoatendimento"));
            r.setObservacoes(rs.getString("observacoes"));
            
            
            reg.add(r);
        }
        return reg;
    }
  
    
    public List<RegistroClinico> buscarPeloNome(String tipoatendimento) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();

        String sql = "SELECT * FROM registroclinico WHERE tipoatendimento LIKE ?;";

        PreparedStatement pst = c.prepareStatement(sql);

        pst.setString(1, "%" + tipoatendimento + "%");

        ResultSet rs = pst.executeQuery();

        List<RegistroClinico> registros = new ArrayList<>();

        while (rs.next()) {

            RegistroClinico rec = new RegistroClinico(rs.getInt("idregistroclinico"), rs.getString("diagnostico"),
                    rs.getString("tipoatendimento"),
                    rs.getString("observacoes"));

            registros.add(rec);
        }

        return registros; 

    }
    
    
    
}
