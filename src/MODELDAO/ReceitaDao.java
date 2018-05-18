package MODELDAO;

import IGenerics.IGenerics;
import Model.Receita;
import Model.Tratador;
import Model.Vacina;
import CONECTION.ConnectionFactory;
import Model.BoletimDiario;
import Model.Veterinario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReceitaDao implements IGenerics<Receita, Integer> {

    @Override
    public void inserir(Receita r) throws ClassNotFoundException, SQLException {

        Connection c = ConnectionFactory.getConnection();

        String sql = "INSERT INTO receita (dataaviada, observacoes,nomemedicamento,dose,frequencia,nomeanimal,veterinario)"
                + " VALUES(?,?,?,?,?,?,?);";

        PreparedStatement psm = c.prepareStatement(sql);

        psm.setString(1, r.getDataaviada());
        psm.setString(2, r.getObservacoes());
        psm.setString(3, r.getNomemedicamento());
        psm.setString(4, r.getDose());
        psm.setString(5, r.getFrequencia());
        psm.setString(6, r.getNomeanimal());
        psm.setInt(7, r.getVeterinario().getId_veterinario());
        psm.executeUpdate();

    }

    @Override
    public void apagar(Receita r) throws ClassNotFoundException, SQLException {

        Connection c = ConnectionFactory.getConnection();

        String sql = "DELETE FROM "
                + "receita WHERE idreceita = ?;";

        PreparedStatement pst = c.prepareStatement(sql);

        pst.setInt(1, r.getIdreceita());

        pst.executeUpdate();

    }

    @Override
    public void alterar(Receita obj) throws ClassNotFoundException, SQLException {

    }

    @Override
    public Receita buscarUm(Integer id) throws ClassNotFoundException, SQLException {

        Connection c = ConnectionFactory.getConnection();

        String sql = "SELECT * FROM receita r "
                + "WHERE r.dataaviada = ?;";

        PreparedStatement pst = c.prepareStatement(sql);

        pst.setInt(1, id);

        ResultSet rs = pst.executeQuery();

        Receita rec = null;

        if (rs.next()) {

            rec = new Receita();

            rec.setIdreceita(rs.getInt("idreceita"));
            rec.setDataaviada(rs.getString("dataaviada"));
            rec.setObservacoes(rs.getString("observacoes"));
            rec.setNomemedicamento(rs.getString("nomemedicamento"));
            rec.setDose(rs.getString("dose"));
            rec.setFrequencia(rs.getString("frequencia"));
            Veterinario trat = new VeterinarioDao().buscarUm(rs.getInt("veterinario"));
            rec.setVeterinario(trat);

        }
        return rec;

    }

    @Override
    public List<Receita> buscarTodos() throws ClassNotFoundException, SQLException {

        Connection c = ConnectionFactory.getConnection();

        String sql = "SELECT * FROM receita;";

        PreparedStatement pst = c.prepareStatement(sql);

        ResultSet rs = pst.executeQuery();

        List<Receita> rec = new ArrayList<>();

        while (rs.next()) {

            Receita r = new Receita();
            r.setIdreceita(rs.getInt("idreceita"));
            r.setDataaviada(rs.getString("dataaviada"));
            r.setObservacoes(rs.getString("observacoes"));
            r.setNomemedicamento(rs.getString("nomemedicamento"));
            r.setDose(rs.getString("dose"));
            r.setFrequencia(rs.getString("frequencia"));
            r.setNomeanimal(rs.getString("Nomeanimal"));
            Veterinario vet = new VeterinarioDao().buscarUm(rs.getInt("veterinario"));
            r.setVeterinario(vet);
            rec.add(r);
        }
        return rec;

    }

    public List<Receita> buscarPeloNome(String dataaviada) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();

        String sql = "SELECT * FROM receita WHERE dataaviada LIKE ?;";

        PreparedStatement pst = c.prepareStatement(sql);

        pst.setString(1, "%" + dataaviada + "%");

        ResultSet rs = pst.executeQuery();

        List<Receita> receitas = new ArrayList<>();

        while (rs.next()) {
            Veterinario vet = new VeterinarioDao().buscarUm(rs.getInt("veterinario"));
            
            Receita rec = new Receita(rs.getInt("idreceita"),
                    rs.getString("dataaviada"),
                    rs.getString("observacoes"),
                    rs.getString("nomemedicamento"),
                    rs.getString("dose"),
                    rs.getString("frequencia"),
                    rs.getString("nomeanimal"),
                    vet);
            receitas.add(rec);
        }

        return receitas;
    }

}
