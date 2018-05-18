package MODELDAO;

import IGenerics.IGenerics;
import Model.Veterinario;
import CONECTION.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VeterinarioDao implements IGenerics<Veterinario, Integer> {

    @Override
    public void inserir(Veterinario v) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();

        String sql = "INSERT INTO veterinario (nome_veterinario, telefone_veterinario, endereco_veterinario,data_emissao,num_conselho)"
                + " VALUES(?,?,?,?,?);";
        PreparedStatement psm = c.prepareStatement(sql);
        psm.setString(1, v.getNome_veterinario());
        psm.setString(2, v.getTelefone_veterinario());
        psm.setString(3, v.getEndereco_veterinario());
        psm.setString(4, v.getData_emissao());
        psm.setInt(5, v.getNum_conselho());
        psm.executeUpdate();
    }

    @Override
    public void apagar(Veterinario vet) throws ClassNotFoundException, SQLException {

        Connection c = ConnectionFactory.getConnection();

        String sql = "DELETE FROM "
                + "veterinario WHERE id_veterinario = ?;";

        PreparedStatement pst = c.prepareStatement(sql);

        pst.setInt(1, vet.getId_veterinario());

        pst.executeUpdate();

    }

    @Override
    public void alterar(Veterinario vet) throws ClassNotFoundException, SQLException {

        Connection c = ConnectionFactory.getConnection();

        String sql = "UPDATE veterinario SET "
                + "nome_veterinario = ?, "
                + "telefone_veterinario = ? "
                + "endereco_veterinario = ? "
                + "WHERE id_veterinario = ?;";

        PreparedStatement pst = c.prepareStatement(sql);

        pst.setString(1, vet.getNome_veterinario());
        pst.setString(2, vet.getTelefone_veterinario());
        pst.setString(3, vet.getEndereco_veterinario());
        pst.setInt(4, vet.getId_veterinario());

        pst.executeUpdate();

    }

    @Override
    public Veterinario buscarUm(Integer id) throws ClassNotFoundException, SQLException {
       Connection c = ConnectionFactory.getConnection();

        String sql = "SELECT * from veterinario where id_veterinario = ?;";

        PreparedStatement pst = c.prepareStatement(sql);

        pst.setInt(1, id);

        Veterinario vet = new Veterinario();

        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            vet.setId_veterinario(rs.getInt("id_veterinario"));
            vet.setNome_veterinario(rs.getString("nome_veterinario"));
            vet.setTelefone_veterinario(rs.getString("telefone_veterinario"));
            vet.setNum_conselho(rs.getInt("num_conselho"));
            vet.setData_emissao(rs.getString("data_emissao"));
            vet.setEndereco_veterinario(rs.getString("endereco_veterinario"));

        }

        return vet;
    }

    @Override
    public List<Veterinario> buscarTodos() throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();

        String sql = "SELECT * FROM veterinario;";

        PreparedStatement pst = c.prepareStatement(sql);

        ResultSet rs = pst.executeQuery();
        List<Veterinario> vet = new ArrayList<>();

        while (rs.next()) {
            Veterinario v = new Veterinario();
            v.setId_veterinario(rs.getInt("id_veterinario"));
            v.setNome_veterinario(rs.getString("nome_veterinario"));
            v.setTelefone_veterinario(rs.getString("telefone_veterinario"));
            v.setNum_conselho(rs.getInt("num_conselho"));
            v.setData_emissao(rs.getString("data_emissao"));
            v.setEndereco_veterinario(rs.getString("endereco_veterinario"));
            vet.add(v);
        }
        return vet;
    }

    public List<Veterinario> buscarPeloNome(String nome_veterinario) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();

        String sql = "SELECT * FROM veterinario WHERE nome_veterinario LIKE ?;";

        PreparedStatement pst = c.prepareStatement(sql);

        pst.setString(1, "%" + nome_veterinario + "%");

        ResultSet rs = pst.executeQuery();

        List<Veterinario> veterinaios = new ArrayList<>();

        while (rs.next()) {
            Veterinario vet = new Veterinario(
                    rs.getInt("id_veterinario"),
                    rs.getString("nome_veterinario"),
                    rs.getString("telefone_veterinario"),
                    rs.getString("endereco_veterinario"),
                    rs.getString("data_emissao"),
                    rs.getInt("num_conselho"));
            veterinaios.add(vet);
        }

        return veterinaios;

    }

}
