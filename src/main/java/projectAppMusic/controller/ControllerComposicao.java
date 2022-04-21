/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectAppMusic.controller;

import java.sql.SQLException;
import java.util.List;
import projectAppMusic.bean.Composicao;
import projectAppMusic.dao.DaoComposicao;

/**
 *
 * @author User
 */
public class ControllerComposicao {
    
    DaoComposicao daoComp;
    
    public Composicao inserir(Composicao c) throws SQLException, ClassNotFoundException {
        daoComp = new DaoComposicao();
        return daoComp.inserir(c);
    }

    public List<Composicao> listar(Composicao c) throws SQLException, ClassNotFoundException {
        daoComp = new DaoComposicao();
        return daoComp.listar(c);
    }

    public Composicao alterar(Composicao c) throws SQLException, ClassNotFoundException {
        daoComp = new DaoComposicao();
        return daoComp.alterar(c);
    }

    public Composicao buscar(Composicao c) throws SQLException, ClassNotFoundException {
        daoComp = new DaoComposicao();
        return daoComp.buscar(c);
    }

    public Composicao excluir (Composicao c) throws SQLException, ClassNotFoundException {
        daoComp = new DaoComposicao();
        return daoComp.excluir(c);
    }
   
} 
