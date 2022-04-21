/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AppMusica.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexao {
    
    private String banco = "jdbc:mysql://localhost/appmusica?useTimezone=true&serverTimezone=UTC";
    private String usuario = "root";
    private String senha = "@l3x2020.010203";
 
    private static Connection connection;

    public Conexao() {
    }

    public boolean conectar(){
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(banco, usuario, senha);
            connection.setAutoCommit(false);
            return true;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível se conectar ao Banco de dados");
            System.out.println("Status--> Erro " + e.getMessage());
            return false;
        }
    }

    public void desconectar(){
        try {
            if(connection != null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    public Connection getConnection() {
        return connection;
    }
    
}
