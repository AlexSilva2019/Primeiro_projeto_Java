/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectAppMusic.dao;

import java.sql.Connection;

import AppMusica.util.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.sql.Statement;
import projectAppMusic.bean.Pessoa;
import projectAppMusic.bean.Usuario;


/**
 *
 * @author User
 */
public class DaoPessoa {
    private final Conexao conexaoDB;
    private Connection connection;

    public DaoPessoa() {
        conexaoDB = new Conexao();
        
    }
    
    public Usuario inserir(Usuario usuario) throws SQLException{
        if (conexaoDB.conectar()) {
            String sql = "insert into pessoa" + " values (null, ?)";
            connection = conexaoDB.getConnection();
            
            PreparedStatement preparedStatement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, usuario.getNome());
            preparedStatement.executeUpdate();
            
            ResultSet resultado = preparedStatement.getGeneratedKeys();
            if (resultado.next()) {
                usuario.setId(resultado.getLong(1));
                System.out.println("TESTANDO");
            }
            resultado.close();
            connection.commit();
            conexaoDB.desconectar();
            return usuario;
            
        } else {
            return null;
        }
    }
    public Usuario alterar(Usuario usu) {
        if (conexaoDB.conectar()) {
            
            try {//possivelmente ocorrerá erro 
                connection = conexaoDB.getConnection();
        
        String sql = "UPDATE pessoa SET Nome = ? WHERE idPessoa = ?";
        // prepared statement para inserção
        PreparedStatement stmt = connection.prepareStatement(sql);
        // seta os valores
        
        stmt.setString(1,usu.getNome());
        stmt.setLong(2,usu.getId());

        // executa
        stmt.executeUpdate();
           
            stmt.close();
            connection.commit();
            conexaoDB.desconectar();
            return usu;
        } catch (SQLException ex) {//classe para tratamento de erros sql
           ex.printStackTrace();//mostrar erro 
            try {
                connection.rollback();//refaz a alteração no banco 
            } catch (SQLException ex1) {
                ex1.printStackTrace();
            }
            
            return null;//se retornar nulo quer dizer que houve erro
        } finally {//executa independente de qualquer erro 
                conexaoDB.desconectar();
        }  
            
        } else {
            return null;
        }
    }

    public Usuario excluir(Usuario usu) {
        
        if (conexaoDB.conectar()) {
            
            try {//possivelmente ocorrerá erro 
                connection = conexaoDB.getConnection();
        
        String sql = "delete from pessoa WHERE idPessoa = ?";
        // prepared statement para inserção
        PreparedStatement stmt = connection.prepareStatement(sql);
        // seta os valores
        
        
        stmt.setLong(1,usu.getId());

        // executa
        stmt.executeUpdate();
           
     
            connection.commit();
            conexaoDB.desconectar();
            return usu;
        } catch (SQLException ex) {//classe para tratamento de erros sql
           ex.printStackTrace();//mostrar erro 
            try {
                connection.rollback();//refaz a alteração no banco 
            } catch (SQLException ex1) {
                ex1.printStackTrace();
            }
            
            return null;//se retornar nulo quer dizer que houve erro
        } finally {//executa independente de qualquer erro 
                conexaoDB.desconectar();
        }  
            
        } else {
            return null;
        }
}
    
    
    
    
}
