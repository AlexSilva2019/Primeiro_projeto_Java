/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectAppMusic;

import projectAppMusic.view.ManterAutor;
import projectAppMusic.view.ManterUsuario;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import projectAppMusic.view.ManterComposicao;
import projectAppMusic.view.ManterMusica;
/**
 *
 * @author ProfAlexandre
 */
public class projectAppMusic {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        
        if(ManterUsuario.validar()) {
            menu();
        } else {
            JOptionPane.showMessageDialog(null,"Usuario Invalido");
        }
    }

    public static void menu() throws SQLException, ClassNotFoundException {
            int operacao = Integer.parseInt(JOptionPane.showInputDialog("0 - Sair \n 1 - Usuario \n 2 - Autor \n 3 - Composição \n 4 - Musica"));
            switch (operacao) {
                case 0:
                    int sair = JOptionPane.showConfirmDialog(null,"Sair? ");
                    if(sair > 0) menu();
                    System.out.println("Valor de Sair = " + sair);
                    break;
                case 1:
                    ManterUsuario.menu();
                    break;
                case 2:
                    ManterAutor.menu();
                    break;
                case 3:
                    ManterComposicao.menu();
                    break;
                case 4:
                    ManterMusica.menu();
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Erro opcao invalida");
                    menu();
                    break;
            }
    }

}
