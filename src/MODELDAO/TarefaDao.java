/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELDAO;

import IGenerics.IGenerics;
import Model.RegistroClinico;
import Model.Tarefa;
import Model.Vacina;
import CONECTION.ConnectionFactory;
import Model.Animal;
import Model.Rotina_Tratamento;
import Model.Tratador;
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
public class TarefaDao implements IGenerics<Tarefa, Integer> {

    @Override
    public void inserir(Tarefa t) throws ClassNotFoundException, SQLException {

        Connection c = ConnectionFactory.getConnection();

        String sql = "INSERT INTO tarefa (descricao)"
                + " VALUES(?);";

        PreparedStatement psm = c.prepareStatement(sql);

        psm.setString(1, t.getDescricao());

        psm.executeUpdate();

    }

    @Override
    public void apagar(Tarefa t) throws ClassNotFoundException, SQLException {

        Connection c = ConnectionFactory.getConnection();

        String sql = "DELETE FROM "
                + "tarefa WHERE idtarefa = ?;";

        PreparedStatement pst = c.prepareStatement(sql);

        pst.setInt(1, t.getIdtarefa());

        pst.executeUpdate();

    }

    @Override
    public void alterar(Tarefa t) throws ClassNotFoundException, SQLException {

        Connection c = ConnectionFactory.getConnection();

        String sql = "UPDATE tarefa SET "
                + "descricao = ?, ";

        PreparedStatement pst = c.prepareStatement(sql);

        pst.setString(1, t.getDescricao());

        pst.executeUpdate();
    }

    @Override
    public Tarefa buscarUm(Integer id) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();

        String sql = "SELECT * from tarefa where idtarefa = ?;";

        PreparedStatement pst = c.prepareStatement(sql);

        pst.setInt(1, id);

        Tarefa t = new Tarefa();

        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            t.setIdtarefa(rs.getInt("idtarefa"));
            t.setDescricao(rs.getString("descricao"));

        }

        return t;
    }

    @Override
    public List<Tarefa> buscarTodos() throws ClassNotFoundException, SQLException {

        Connection c = ConnectionFactory.getConnection();

        String sql = "SELECT * FROM tarefa;";

        PreparedStatement pst = c.prepareStatement(sql);

        ResultSet rs = pst.executeQuery();

        List<Tarefa> tar = new ArrayList<>();

        while (rs.next()) {

            Tarefa t = new Tarefa();
            t.setIdtarefa(rs.getInt("idtarefa"));
            t.setDescricao(rs.getString("descricao"));

            tar.add(t);
        }
        return tar;

    }
    
    public List<Tarefa> buscarPeloNome(String descricao) throws ClassNotFoundException, SQLException {
        
        Connection c = ConnectionFactory.getConnection();

        String sql = "SELECT * FROM tarefa WHERE descricao LIKE ?;";

        PreparedStatement pst = c.prepareStatement(sql);

        pst.setString(1, "%" + descricao + "%");

        ResultSet rs = pst.executeQuery();

        List<Tarefa> tarefas = new ArrayList<>();

        while (rs.next()) {
                             
            Tarefa taf = new Tarefa(rs.getInt("idtarefa"),rs.getString("descricao"));

            tarefas.add(taf);
        }

        return tarefas; 

    }

}
