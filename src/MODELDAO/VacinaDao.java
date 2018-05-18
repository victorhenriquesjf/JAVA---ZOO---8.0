/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELDAO;

import IGenerics.IGenerics;
import Model.Vacina;
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
public class VacinaDao implements IGenerics<Vacina, Integer> {

    @Override
    public void inserir(Vacina v) throws ClassNotFoundException, SQLException {

        Connection c = ConnectionFactory.getConnection();

        String sql = "INSERT INTO vacina (idvacina,nome)"
                + " VALUES(?,?);";

        PreparedStatement psm = c.prepareStatement(sql);

        psm.setInt(1, v.getIdvacina());
        psm.setString(2, v.getNome());

        psm.executeUpdate();

    }

    @Override
    public void apagar(Vacina v) throws ClassNotFoundException, SQLException {

        Connection c = ConnectionFactory.getConnection();

        String sql = "DELETE FROM "
                + "vacina WHERE idvacina = ?;";

        PreparedStatement pst = c.prepareStatement(sql);

        pst.setInt(1, v.getIdvacina());

        pst.executeUpdate();

    }

    @Override
    public void alterar(Vacina obj) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vacina buscarUm(Integer id) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Vacina> buscarTodos() throws ClassNotFoundException, SQLException {

        Connection c = ConnectionFactory.getConnection();

        String sql = "SELECT * FROM vacina;";

        PreparedStatement pst = c.prepareStatement(sql);

        ResultSet rs = pst.executeQuery();

        List<Vacina> vac = new ArrayList<>();

        while (rs.next()) {

            Vacina v = new Vacina();
            v.setIdvacina(rs.getInt("idvacina"));
            v.setNome(rs.getString("nome"));

            vac.add(v);
        }
        return vac;

    }

    public List<Vacina> buscarPeloNome(String nome) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();

        String sql = "SELECT * FROM vacina WHERE nome LIKE ?;";

        PreparedStatement pst = c.prepareStatement(sql);

        pst.setString(1, "%" + nome + "%");

        ResultSet rs = pst.executeQuery();

        List<Vacina> boletins = new ArrayList<>();

        while (rs.next()) {
            Vacina v = new Vacina(rs.getInt("idvacina"), rs.getString("nome"));

            boletins.add(v);
        }

        return boletins;

    }

}
