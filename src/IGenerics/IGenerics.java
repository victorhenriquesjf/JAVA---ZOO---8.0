package IGenerics;

import java.sql.SQLException;
import java.util.List;

public interface IGenerics<C,K> {
    public void inserir (C obj) throws ClassNotFoundException, SQLException;
    public void apagar (C obj) throws ClassNotFoundException, SQLException;
    public void alterar (C obj) throws ClassNotFoundException, SQLException;
    public C buscarUm(K id) throws ClassNotFoundException, SQLException;
    public List<C> buscarTodos() throws ClassNotFoundException, SQLException;
}
