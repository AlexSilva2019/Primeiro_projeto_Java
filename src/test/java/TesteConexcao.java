
import AppMusica.util.Conexao;
import org.junit.Test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class TesteConexcao {
    @Test
    public void testeconnection(){
        Conexao c1 = new Conexao();
        if (c1.conectar()) {
            System.out.println("Conexao realizada com sucesso");
        } else {
            System.out.println("Falha na conexao");
        }
    }
    
    
}
