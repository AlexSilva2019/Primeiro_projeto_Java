package projectAppMusic.controller;


import projectAppMusic.dao.DaoAutor;
import java.sql.SQLException;
import java.util.List;
import projectAppMusic.bean.Autor;


public class ControllerAutor {
    
    DaoAutor daoAut;
    
    public Autor inserir(Autor a) throws SQLException, ClassNotFoundException {
        daoAut = new DaoAutor();
        return daoAut.inserir(a);
    }

    public List<Autor> listar(Autor a) throws SQLException, ClassNotFoundException {
        daoAut = new DaoAutor();
        return daoAut.listar(a);
    }

    public Autor alterar(Autor a) throws SQLException, ClassNotFoundException {
        daoAut = new DaoAutor();
        return daoAut.alterar(a);
    }

    public Autor buscar(Autor a) throws SQLException, ClassNotFoundException {
        daoAut = new DaoAutor();
        return daoAut.buscar(a);
    }

    public Autor excluir(Autor a) throws SQLException, ClassNotFoundException {
        daoAut = new DaoAutor();
        return daoAut.excluir(a);
    }
    
}
