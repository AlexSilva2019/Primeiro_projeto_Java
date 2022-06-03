
package projectAppMusic.view;

import javax.swing.JOptionPane;
import projectAppMusic.bean.Usuario;
import projectAppMusic.controller.ControllerUsuario;
import java.sql.SQLException;
import java.util.List;
import org.junit.Test;
import projectAppMusic.controller.ControllerPessoa;



public class ManterUsuario {

    public static void inserir () throws SQLException, ClassNotFoundException {
        String login = JOptionPane.showInputDialog("Login");
        String Senha = JOptionPane.showInputDialog("Senha");
        String status = JOptionPane.showInputDialog("Status");
        String nome = JOptionPane.showInputDialog("Nome");
        Usuario usuEntrada = new Usuario(login, Senha, status, nome);
        
        ControllerPessoa  controllerPessoa = new  ControllerPessoa();
        usuEntrada = controllerPessoa.inserir(usuEntrada);
            
        ControllerUsuario contUsu = new ControllerUsuario();
        Usuario usuSaida = contUsu.inserir(usuEntrada);
        JOptionPane.showMessageDialog(null,"" + usuSaida.toString());
    }
    
    public static void alterar () throws SQLException, ClassNotFoundException {
        Long idUsu = Long.parseLong(JOptionPane.showInputDialog("id Usuario"));
        String login = JOptionPane.showInputDialog("Login");
        String Senha = JOptionPane.showInputDialog("Senha");
        String status = JOptionPane.showInputDialog("Status");
        Long id_Pessoa = Long.parseLong(JOptionPane.showInputDialog("id Pessoa"));
        String nome = JOptionPane.showInputDialog("Nome");
        Usuario usuEntrada = new Usuario(idUsu, login, Senha, status, id_Pessoa , nome);
        
        ControllerPessoa  controllerPessoa = new  ControllerPessoa();
            usuEntrada = controllerPessoa.alterar(usuEntrada);
            
        ControllerUsuario contUsu = new ControllerUsuario();
        Usuario usuSaida = contUsu.alterar(usuEntrada);
        JOptionPane.showMessageDialog(null,"" + usuSaida.toString());
    }
 
    public static void excluir () throws SQLException, ClassNotFoundException {
        Long idUsu = Long.parseLong(JOptionPane.showInputDialog("id"));
        Usuario usuEntrada = new Usuario(idUsu);
        ControllerUsuario contUsu = new ControllerUsuario();
        Usuario usuSaida = contUsu.excluir(usuEntrada);
        JOptionPane.showMessageDialog(null,"" + usuSaida.toString());
    }
    
    public static void listar () throws SQLException, ClassNotFoundException {
        
        String login = JOptionPane.showInputDialog("Login");
        Usuario usuEntrada = new Usuario(login);
        ControllerUsuario contUsu = new ControllerUsuario();
        List<Usuario> lista = contUsu.listar(usuEntrada);
        for(Usuario u : lista){
                    JOptionPane.showMessageDialog(null,"" + u.getLogin());
                } 
    }

    public static void buscar () throws SQLException, ClassNotFoundException {
        Long idUsu = Long.parseLong(JOptionPane.showInputDialog("id Usuario"));//request.getParameter("")
        Usuario usuEntrada = new Usuario(idUsu);
        ControllerUsuario contUsu = new ControllerUsuario();
        Usuario usuSaida = contUsu.buscar(usuEntrada);
        JOptionPane.showMessageDialog(null,"" + usuSaida.toString());
        
    }

    public static boolean validar () throws SQLException, ClassNotFoundException {
        boolean validado = false;
        String login = JOptionPane.showInputDialog("Login");
        String Senha = JOptionPane.showInputDialog("Senha");
        Usuario usuEntrada = new Usuario(login, Senha);
        ControllerUsuario contUsu = new ControllerUsuario();
        validado = contUsu.validar(usuEntrada);
        return validado;
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


