/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectAppMusic.view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import projectAppMusic.bean.Autor;
import projectAppMusic.bean.Composicao;
import projectAppMusic.bean.Musica;
import projectAppMusic.controller.ControllerMusica;

/**
 *
 * @author User
 */
public class ManterMusica {
        
    
    public static void inserir() throws SQLException, ClassNotFoundException {
        
        Long idAutor = Long.parseLong(JOptionPane.showInputDialog("ID do autor"));
        Long idComposicao = Long.parseLong(JOptionPane.showInputDialog("ID da composicao"));
        
            Autor autor = new Autor(idAutor);
            
            Composicao composicao = new Composicao(idComposicao);
            
            Musica mscEntrada = new Musica(autor, composicao);

            ControllerMusica ca  = new ControllerMusica();
            
            Musica mscSaida = ca.inserir(mscEntrada);
            
            if (mscSaida != null && mscSaida.getId_musica()!= null) {
                JOptionPane.showMessageDialog(null,mscSaida);
                
            } else {
                JOptionPane.showMessageDialog(null, "Falha ao inserir");
            }
 
        
    }
    
    public static void listar() throws SQLException, ClassNotFoundException {
        
            Long id = Long.parseLong((JOptionPane.showInputDialog("ID da Musica")));
            
            Musica mscEntrada = new Musica(id);

            ControllerMusica ca  = new ControllerMusica();
            
            List<Musica> listMusicas = new ArrayList<>();
            
            listMusicas  = ca.listar(mscEntrada);
            
            if (listMusicas != null || ! listMusicas.isEmpty()) {
                for(Musica a : listMusicas){
                    JOptionPane.showMessageDialog(null, a);
                }
                

            } else {
                JOptionPane.showMessageDialog(null, "Falha ao listar    ") ;
            }  
        
   }

    public static void alterar() throws SQLException, ClassNotFoundException {
       
        Long idAutor = Long.parseLong(JOptionPane.showInputDialog("ID do autor"));
        Long idComposicao = Long.parseLong(JOptionPane.showInputDialog("ID da composicao"));
        Long idMusica = Long.parseLong(JOptionPane.showInputDialog("ID da Musica"));
        
            Autor autor = new Autor(idAutor);
            
            Composicao composicao = new Composicao(idComposicao);

            Musica mscEntrada = new Musica(idMusica, autor, composicao);

            ControllerMusica ca = new ControllerMusica();
            
            mscEntrada = ca.alterar(mscEntrada);
  
            if (mscEntrada != null && mscEntrada.getId_musica() != null) {
                System.out.println(mscEntrada);
                
            } else {
                JOptionPane.showMessageDialog(null, "Falha ao alterar");
            }
        
    }

    public static void buscar() throws SQLException, ClassNotFoundException {
            
        Long idMusica = Long.parseLong(JOptionPane.showInputDialog("ID da Musica"));
        
           Musica msc = new Musica(idMusica);

           ControllerMusica au  = new ControllerMusica();
            
           Musica mscSaida = au.buscar(msc);
            
            if (mscSaida != null) {
                JOptionPane.showMessageDialog(null,"" + mscSaida.toString());
                
            } else {
                JOptionPane.showMessageDialog(null, "Falha ao buscar");
            }  
    }

    public static void excluir() throws SQLException, ClassNotFoundException {
        Long id = Long.parseLong(JOptionPane.showInputDialog("ID da Musica"));
        
        Musica mscEntrada = new Musica(id);
        
        ControllerMusica contmsc = new ControllerMusica();
        
        Musica mscSaida = contmsc.excluir(mscEntrada);
        
        JOptionPane.showMessageDialog(null, mscSaida.toString());
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
