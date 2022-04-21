/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectAppMusic.view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import projectAppMusic.bean.Composicao;
import projectAppMusic.controller.ControllerComposicao;

/**
 *
 * @cmphor User
 */
public class ManterComposicao {
    
    public static void inserir() throws SQLException, ClassNotFoundException {
        
        String nome = JOptionPane.showInputDialog("Nome");
        String duracaoComp = JOptionPane.showInputDialog("Duração da musica");
        
            Composicao compEntrada = new Composicao(nome, duracaoComp);

            ControllerComposicao ca  = new ControllerComposicao();
            
            Composicao compSaida = ca.inserir(compEntrada);
            
            if (compSaida != null && compSaida.getCodigo_composicao() != null) {
                JOptionPane.showMessageDialog(null,compSaida);
                
            } else {
                JOptionPane.showMessageDialog(null, "Erro") ;
            }
 
        
    }
    
    public static void listar() throws SQLException, ClassNotFoundException {
        
            String nome = JOptionPane.showInputDialog("Nome");
            
            Composicao compEntrada = new Composicao(nome);

            ControllerComposicao ca  = new ControllerComposicao();
            
            List<Composicao> listComposicoes = new ArrayList<>();
            
            listComposicoes  = ca.listar(compEntrada);
            
            if (listComposicoes != null || ! listComposicoes.isEmpty()) {
                for(Composicao a : listComposicoes){
                    JOptionPane.showMessageDialog(null, a);
                }
                

            } else {
                JOptionPane.showMessageDialog(null, "Falha ao listar    ") ;
            }  
        
   }

    public static void alterar() throws SQLException, ClassNotFoundException {
       
        Composicao cmp = new Composicao(1L, "NOMEDOIS");

            ControllerComposicao ca = new ControllerComposicao();
            
            cmp = ca.alterar(cmp);
  
            if (cmp != null && cmp.getCodigo_composicao() != null) {
                JOptionPane.showMessageDialog(null, cmp);
                
            } else {
                JOptionPane.showMessageDialog(null, "Falha ao alterar");
            }
        
    }

    public static void buscar() throws SQLException, ClassNotFoundException {
        
           Composicao cmp = new Composicao(1L);

            ControllerComposicao au  = new ControllerComposicao();
            
           Composicao cmpSaida = au.buscar(cmp);
            
            if (cmpSaida != null) {
                System.out.println(cmpSaida);
                
            } else {
                System.out.println("Falha na inserção");
            }  
    }

    public static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        
        Composicao cmpEntrada = new Composicao(1L);
        
        ControllerComposicao contcmp = new ControllerComposicao();
        
        Composicao cmpSaida = contcmp.excluir(cmpEntrada);
        
        JOptionPane.showMessageDialog(null, cmpSaida.toString());
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
