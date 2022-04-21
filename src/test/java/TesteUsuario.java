
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import projectAppMusic.bean.Pessoa;
import projectAppMusic.bean.Usuario;
import projectAppMusic.controller.ControllerPessoa;
import projectAppMusic.controller.ControllerUsuario;
import projectAppMusic.dao.DaoPessoa;
import projectAppMusic.view.ManterAutor;
import projectAppMusic.view.ManterComposicao;
import projectAppMusic.view.ManterMusica;
import projectAppMusic.view.ManterUsuario;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class TesteUsuario {
    @Test
    public void executarTeste() throws SQLException, ClassNotFoundException {
 //ManterComposicao.inserir();
 //ManterMusica.excluir();
//ManterComposicao.excluir();
//ManterAutor.inserir();
        //ManterAutor.menu();
        //testInserir();
        //testAlterar();
        //testExcluir();
        //testBuscar();
        //testListar();
        //testValidar();
        //ManterUsuario.inserir();
    }
    public void testInserir() throws SQLException {
       
            Usuario usuEntrada = new Usuario("log", "sn", "sts", "testando");
            
            ControllerPessoa  controllerPessoa = new  ControllerPessoa ();
            usuEntrada = controllerPessoa.inserir(usuEntrada);
            
            ControllerUsuario uc  = new ControllerUsuario();
            
            Usuario usuSaida = uc.inserir(usuEntrada);
            
            if (usuSaida != null && usuSaida.getId()!= null) {
                System.out.println(usuSaida);
                
            } else {
                System.out.println("Falha na inserção");
            }
        
    }
    
   
    public void testAlterar() throws SQLException, ClassNotFoundException {
        //Usuario(Long idUsu, String login, String senha, String status, Long id, String nome)
            Usuario usu = new Usuario(9L , "ACESSO", "PASS", "STAT", 18L, "NAME");

            ControllerPessoa cp = new ControllerPessoa();
            
            usu = cp.alterar(usu);
            
            ControllerUsuario uc  = new ControllerUsuario();
            
            Usuario usuSaida = uc.alterar(usu);
            
            if (usuSaida != null && usuSaida.getIdUsu()!= null) {
                System.out.println(usuSaida);
                
            } else {
                System.out.println("Falha na alteração");
            }
        
    }
    
    public void testExcluir() throws SQLException, ClassNotFoundException {
        
            Usuario u = new Usuario();
            
            u.setId(26L);
            ControllerPessoa ucP  = new ControllerPessoa();
            
            u = ucP.excluir(u);
            
            
            if (u != null) {
                System.out.println(u);
                
            } else {
                System.out.println("Falha na inserção");
            }
        
    }
    
    public void testBuscar() throws SQLException, ClassNotFoundException {
        
            Usuario usu = new Usuario(9L);

            ControllerUsuario uc  = new ControllerUsuario();
            
            Usuario usuSaida = uc.buscar(usu);
            
            if (usuSaida != null) {
                System.out.println(usuSaida);
                
            } else {
                System.out.println("Falha na inserção");
            }  
    }
    
    public void testListar() throws SQLException, ClassNotFoundException {
        
            Usuario usu = new Usuario("ACESSO");

            ControllerUsuario uc  = new ControllerUsuario();
            
            List<Usuario> listaUsuarios = new ArrayList<>();
            
            listaUsuarios  = uc.listar(usu);
            
            if (listaUsuarios != null) {
                for(Usuario u : listaUsuarios){
                    System.out.println(u);
                }

            } else {
                System.out.println("Falha na listagem");
            }  
    }
    
    public void testValidar() throws SQLException, ClassNotFoundException {
        
            Usuario usu = new Usuario("ACESSO", "PASS");

            ControllerUsuario uc  = new ControllerUsuario();

            if (uc.validar(usu)) {
                System.out.println("Usuario validado! ");
                
            } else {
                System.out.println("não validado");
            }  
    }
    
}


