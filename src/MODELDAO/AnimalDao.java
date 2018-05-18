package MODELDAO;

import IGenerics.IGenerics;
import Model.Animal;
import Model.BoletimDiario;
import Model.Tratador;
import CONECTION.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnimalDao implements IGenerics<Animal, Integer> {

    @Override
    public void inserir(Animal a) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();

        String sql = "INSERT INTO animal (nome_animal, nascimento_animal, peso_animal,origem_animal,especie_animal,tratador_animal)"
                + " VALUES(?,?,?,?,?,?);";
        PreparedStatement psm = c.prepareStatement(sql);
        psm.setString(1, a.getNome_animal());
        psm.setString(2, a.getNascimento_animal());
        psm.setDouble(3, a.getPeso_animal());
        psm.setString(4, a.getOrigem_animal());
        psm.setString(5, a.getEspecie_animal());
        psm.setInt(6, a.getTratador_animal().getId_tratador());
        psm.executeUpdate();
    }

    @Override
    public void apagar(Animal a) throws ClassNotFoundException, SQLException {
        
        Connection c = ConnectionFactory.getConnection();
        
        
        String sql = "DELETE FROM "
                + "animal WHERE id_animal = ?;";

        PreparedStatement pst = c.prepareStatement(sql);

        pst.setInt(1, a.getId_animal());

        pst.executeUpdate();
    }

    @Override
    public void alterar(Animal obj) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Animal buscarUm(Integer id) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();

        String sql = "SELECT * from animal where id_animal = ?;";

        PreparedStatement pst = c.prepareStatement(sql);

        pst.setInt(1, id);

        Animal a = new Animal();
        
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            a.setId_animal(rs.getInt("id_animal"));
            a.setNome_animal(rs.getString("nome_animal"));
            a.setNascimento_animal(rs.getString("nascimento_animal"));
            a.setPeso_animal(rs.getDouble("peso_animal"));
            a.setOrigem_animal(rs.getString("origem_animal"));
            a.setEspecie_animal(rs.getString("especie_animal"));
            Tratador t = new TratadorDao().buscarUm(rs.getInt("tratador_animal"));
            a.setTratador_animal(t);
        }

        return a;
    }


    @Override
    public List<Animal> buscarTodos() throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();

        String sql = "SELECT * FROM animal;";

        PreparedStatement pst = c.prepareStatement(sql);

        ResultSet rs = pst.executeQuery();

        List<Animal> vet = new ArrayList<>();

        while (rs.next()) {
            Animal a = new Animal();
            a.setId_animal(rs.getInt("id_animal"));
            a.setNome_animal(rs.getString("nome_animal"));
            a.setNascimento_animal(rs.getString("nascimento_animal"));
            a.setPeso_animal(rs.getDouble("peso_animal"));
            a.setOrigem_animal(rs.getString("origem_animal"));
            a.setEspecie_animal(rs.getString("especie_animal"));
            Tratador t = new TratadorDao().buscarUm(rs.getInt("tratador_animal"));
            a.setTratador_animal(t);
            vet.add(a);
        }
        return vet;
    }

    
    public List<Animal> buscarPeloNome(String nomeanimal) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();
        
        String sql = "SELECT * FROM animal WHERE nome_animal LIKE ?;";
        
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setString(1, "%"+nomeanimal+"%");
        ResultSet rs = pst.executeQuery(); 
        
        
        List<Animal> animais = new ArrayList<>();
        
        
                
        while(rs.next()){
            
            Tratador trat = new TratadorDao().buscarPeloNome(rs.getString("tratador_animal"));
        
            Animal a = new Animal(rs.getInt("id_animal"),
            rs.getString("nome_animal"),rs.getString("nascimento_animal"),
            rs.getDouble("peso_animal"),
            rs.getString("origem_animal"),
            rs.getString("especie_animal"),
            trat);
                            
            animais.add(a);
        }   
        
        return animais;
    }
}

