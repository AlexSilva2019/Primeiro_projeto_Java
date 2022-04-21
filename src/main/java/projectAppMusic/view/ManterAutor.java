/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectAppMusic.view;

import projectAppMusic.controller.ControllerAutor;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.junit.Test;
import projectAppMusic.bean.Autor;

/**
 *
 * @author ProfAlexandre
 */

public class ManterAutor {
    
    public static void inserir() throws SQLException, ClassNotFoundException {
        
        String nome = JOptionPane.showInputDialog("Nome");
        Autor autorEntrada = new Autor(nome);

            ControllerAutor ca  = new ControllerAutor();
            
            Autor autorSaida = ca.inserir(autorEntrada);
            
            if (autorSaida != null && autorSaida.getIdAutor()!= null) {
                JOptionPane.showMessageDialog(null, autorSaida);
                
            } else {
                JOptionPane.showMessageDialog(null, "Erro") ;
            }
 
        
    }
    
    public static void listar() throws SQLException, ClassNotFoundException {
        
            String nome = JOptionPane.showInputDialog("Nome");
            
            Autor autorEntrada = new Autor(nome);

            ControllerAutor ca  = new ControllerAutor();
            
            List<Autor> listaAutores = new ArrayList<>();
            
            listaAutores  = ca.listar(autorEntrada);
            
            if (listaAutores != null || ! listaAutores.isEmpty()) {
                for(Autor a : listaAutores){
                    JOptionPane.showMessageDialog(null, a);
                }
                

            } else {
                JOptionPane.showMessageDialog(null, "Falha ao listar    ") ;
            }  
        
   }

    public static void alterar() throws SQLException, ClassNotFoundException {
       
        Autor aut = new Autor(1L, "NOMEDOIS");

            ControllerAutor ca = new ControllerAutor();
            
            aut = ca.alterar(aut);
  
            if (aut != null && aut.getIdAutor() != null) {
                System.out.println(aut);
                
            } else {
                System.out.println("Falha na alteração");
            }
        
    }

    public static void buscar() throws SQLException, ClassNotFoundException {
        
            Autor aut = new Autor(1L);

            ControllerAutor au  = new ControllerAutor();
            
            Autor autSaida = au.buscar(aut);
            
            if (autSaida != null) {
                System.out.println(autSaida);
                
            } else {
                System.out.println("Falha na inserção");
            }  
    }

    public static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Autor autEntrada = new Autor(1L);
        ControllerAutor contAut = new ControllerAutor();
        Autor autSaida = contAut.excluir(autEntrada);
        JOptionPane.showMessageDialog(null, autSaida.toString());
    }
 
    public static void menu() throws SQLException, ClassNotFoundException {
        int operacao = Integer.parseInt(JOptionPane.showInputDialog("0 - Sair \n 1 - Inserir \n 2 - Alterar \n 3 - Excluir \n 4 - Buscar \n 5 - Listar"));
        switch (operacao) {
            case 0:
               int sair = JOptionPane.showConfirmDialog(null,"Deseja Sair");
               System.out.println("Valor de Sair = " + sair);
               if(sair > 0) menu();
               break;
            case 1:
               inserir();
               break;
           case 2:
               alterar();
               break;
           case 3:
               excluir();
               break;
           case 4:
               buscar();
               break;
           case 5:
               listar();
               break;
           default:
               JOptionPane.showMessageDialog(null,"Erro opcao invalida");
               menu();
               break;
        }
    }


}
