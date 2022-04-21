/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectAppMusic.controller;

import java.sql.SQLException;
import java.util.List;
import projectAppMusic.bean.Usuario;
import projectAppMusic.bean.Usuario;
import projectAppMusic.dao.DaoPessoa;
import projectAppMusic.dao.DaoUsuario;


public class ControllerPessoa {
    
    DaoPessoa daoPes;
    
    public ControllerPessoa() {
        daoPes = new DaoPessoa();
        
    }

    public Usuario inserir(Usuario pesEntrada) throws SQLException {
        return daoPes.inserir(pesEntrada);
    }

    public Usuario alterar(Usuario pesEntrada) {
        return daoPes.alterar(pesEntrada);
    }

    public Usuario excluir(Usuario pesEntrada) {
        return daoPes.excluir(pesEntrada);
    }

}

