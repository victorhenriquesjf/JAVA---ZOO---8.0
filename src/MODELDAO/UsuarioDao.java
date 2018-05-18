/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELDAO;

import IGenerics.IGenerics;
import Model.Tratador;
import Model.Usuario;
import CONECTION.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author aluno
 */
public class UsuarioDao implements IGenerics<Usuario, Integer> {

    public Usuario buscarPeloLoginESenha(String login, String senha) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();

        String sql = "SELECT * FROM usuario u "
                + "where u.login = ? and u.senha = ?;";

        PreparedStatement pst = c.prepareStatement(sql);

        pst.setString(1, login);
        pst.setString(2, senha);

        ResultSet rs = pst.executeQuery();
        Usuario usu = null;

        if (rs.next()) {
            usu = new Usuario(rs.getInt("idusuario"), rs.getString("nome"),
                    rs.getString("login"),
                    rs.getString("senha"),
                    rs.getInt("tipousuario"));

        }
        return usu;
    }

    @Override
    public void inserir(Usuario u) throws ClassNotFoundException, SQLException {

        Connection c = ConnectionFactory.getConnection();

        String sql = "INSERT INTO usuario (idusuario,nome,login,senha,tipousuario)"
                + " VALUES(?,?,?,?,?);";

        PreparedStatement psm = c.prepareStatement(sql);

        psm.setInt(1, u.getIdusuario());
        psm.setString(2, u.getNome());
        psm.setString(3, u.getLogin());
        psm.setString(4, u.getSenha());
        psm.setInt(5, u.getTipousuario());

        psm.executeUpdate();

    }

    @Override
    public void apagar(Usuario u) throws ClassNotFoundException, SQLException {

        Connection c = ConnectionFactory.getConnection();

        String sql = "DELETE FROM "
                + "usuario WHERE idusuario = ?;";

        PreparedStatement pst = c.prepareStatement(sql);

        pst.setInt(1, u.getIdusuario());

        pst.executeUpdate();

    }

    @Override
    public void alterar(Usuario obj) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario buscarUm(Integer id) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> buscarTodos() throws ClassNotFoundException, SQLException {

        Connection c = ConnectionFactory.getConnection();

        String sql = "SELECT * FROM usuario;";

        PreparedStatement pst = c.prepareStatement(sql);

        ResultSet rs = pst.executeQuery();
        List<Usuario> u = new ArrayList<>();

        while (rs.next()) {
            Usuario usu = new Usuario();

            usu.setIdusuario(rs.getInt("idusuario"));
            usu.setNome(rs.getString("nome"));
            usu.setLogin(rs.getString("login"));
            usu.setSenha(rs.getString("senha"));
            usu.setTipousuario(rs.getInt("tipousuario"));

            u.add(usu);
        }

        return u;

    }

    public List<Usuario> buscarPeloNome(String nome) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();

        String sql = "SELECT * FROM usuario WHERE nome LIKE ?;";

        PreparedStatement pst = c.prepareStatement(sql);

        pst.setString(1, "%" + nome + "%");

        ResultSet rs = pst.executeQuery();

        List<Usuario> usuarios = new ArrayList<>();

        while (rs.next()) {
            Usuario u = new Usuario(
                    rs.getInt("idusuario"),
                    rs.getString("nome"),
                    rs.getString("login"),
                    rs.getString("senha"),
                    rs.getInt("tipousuario"));

            usuarios.add(u);
        }

        return usuarios;

    }

}
