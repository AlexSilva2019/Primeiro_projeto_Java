/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectAppMusic.controller;

import java.sql.SQLException;
import java.util.List;
import projectAppMusic.bean.Musica;
import projectAppMusic.dao.DaoMusica;

/**
 *
 * @author User
 */
public class ControllerMusica {
	
    DaoMusica daoMsc;
    
    public Musica inserir(Musica m) throws SQLException, ClassNotFoundException {
        daoMsc = new DaoMusica();
        return daoMsc.inserir(m);
    }

    public List<Musica> listar(String m) throws SQLException, ClassNotFoundException {
        daoMsc = new DaoMusica();
        return daoMsc.listar(m);
    }

    public Musica alterar(Musica m) throws SQLException, ClassNotFoundException {
        daoMsc = new DaoMusica();
        return daoMsc.alterar(m);
    }

    public Musica buscar(Musica m) throws SQLException, ClassNotFoundException {
        daoMsc = new DaoMusica();
        return daoMsc.buscar(m);
    }

    public Musica excluir (Musica m) throws SQLException, ClassNotFoundException {
        daoMsc = new DaoMusica();
        return daoMsc.excluir(m);
    }
    
}
