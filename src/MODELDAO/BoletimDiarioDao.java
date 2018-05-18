/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELDAO;

import IGenerics.IGenerics;
import Model.BoletimDiario;
import Model.Receita;
import Model.Usuario;
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
 * @author v
 */
public class BoletimDiarioDao implements IGenerics<BoletimDiario, Integer>{

    @Override
    public void inserir(BoletimDiario bo) throws ClassNotFoundException, SQLException {
       
        Connection c = ConnectionFactory.getConnection();

        String sql = "INSERT INTO boletimdiario (idboletimdiario, dataatual, diagnostico,estadoanimal,observacoes,nomeanimal)"
                + " VALUES(?,?,?,?,?,?);";
        
        
        PreparedStatement psm = c.prepareStatement(sql);
        
        psm.setInt(1, bo.getIdboletimdiario());
        psm.setString(2, bo.getDataatual());
        psm.setString(3, bo.getDiagnostico());
        psm.setString(4, bo.getEstadoanimal());
        psm.setString(5, bo.getObservacoes());
        psm.setString(6, bo.getNomeanimal());
        
        psm.executeUpdate();
        
     
        
        
    }

    @Override
    public void apagar(BoletimDiario bo) throws ClassNotFoundException, SQLException {
        
        Connection c = ConnectionFactory.getConnection();

        String sql = "DELETE FROM "
                + "boletimdiario WHERE idboletimdiario = ?;";

        PreparedStatement pst = c.prepareStatement(sql);

        pst.setInt(1, bo.getIdboletimdiario());

        pst.executeUpdate();
        
        
        
    }

    @Override
    public void alterar(BoletimDiario obj) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BoletimDiario buscarUm(Integer id) throws ClassNotFoundException, SQLException {
        
        Connection c = ConnectionFactory.getConnection();

        String sql = "SELECT * FROM boletimdiario b "
                + "WHERE b.idboletimdiario = ?;";

        PreparedStatement pst = c.prepareStatement(sql);

        pst.setInt(1, id);

        ResultSet rs = pst.executeQuery();
        BoletimDiario bo = null;
        if (rs.next()) {
                    
            bo = new BoletimDiario();
            bo.setIdboletimdiario(rs.getInt("idboletimdiario"));
            bo.setDataatual(rs.getString("dataatual"));
            bo.setDiagnostico(rs.getString("diagnostico"));
            bo.setEstadoanimal(rs.getString("estadoanimal"));
            bo.setObservacoes(rs.getString("observacoes"));
            bo.setNomeanimal(rs.getString("nomeanimal"));
            
            
        }
        return bo;

                
    }

    @Override
    public List<BoletimDiario> buscarTodos() throws ClassNotFoundException, SQLException {
        
        Connection c = ConnectionFactory.getConnection();

        String sql = "SELECT * FROM boletimdiario;";

        PreparedStatement pst = c.prepareStatement(sql);

        ResultSet rs = pst.executeQuery();
        List<BoletimDiario> bo = new ArrayList<>();

        while (rs.next()) {
            BoletimDiario b = new BoletimDiario();
            
            b.setIdboletimdiario(rs.getInt("idboletimdiario"));
            b.setDataatual(rs.getString("dataatual"));
            b.setDiagnostico(rs.getString("diagnostico"));
            b.setEstadoanimal(rs.getString("estadoanimal"));
            b.setObservacoes(rs.getString("observacoes"));
            b.setNomeanimal(rs.getString("nomeanimal"));
            

            bo.add(b);
        }
        
        return bo;
    }
      
    public List<BoletimDiario> buscarPeloNome(String nomeanimal) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();
        
        String sql = "SELECT * FROM boletimdiario WHERE nomeanimal LIKE ?;";
        
        PreparedStatement pst = c.prepareStatement(sql);
        
        pst.setString(1, "%"+nomeanimal+"%");
        
        ResultSet rs = pst.executeQuery(); 
        
        
        List<BoletimDiario> boletins = new ArrayList<>();
        
        while(rs.next()){
            BoletimDiario bo = new BoletimDiario(rs.getInt("idboletimdiario"), rs.getString("dataatual"),
            rs.getString("diagnostico"),
            rs.getString("estadoanimal"),
            rs.getString("observacoes"),
            rs.getString("nomeanimal"));
                    
                            
            boletins.add(bo);
        }   
        
        return boletins;
        
      
    }
}
