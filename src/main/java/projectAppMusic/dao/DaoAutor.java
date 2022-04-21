/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectAppMusic.dao;

import AppMusica.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import projectAppMusic.bean.Autor;

/**
 *
 * @author User
 */
public class DaoAutor {
    
    private final Conexao conexaoDB;
    private Connection connection;

    public DaoAutor() {
        conexaoDB = new Conexao();

    }
    
    public Autor inserir(Autor aut) {
        if (conexaoDB.conectar()) {

            try {
                connection = conexaoDB.getConnection();

                String sql = "insert into autor" + " (Nome)" + " values (?)";

                // prepared statement para inserção
                PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                // seta os valores
                stmt.setString(1, aut.getNome());
                   
                // executa
                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    aut.setIdAutor(rs.getLong(1));

                }
                rs.close();

                stmt.close();
                connection.commit();
                conexaoDB.desconectar();
                return aut;
            } catch (SQLException ex) {
                ex.printStackTrace();
                try {
                    connection.rollback();
                } catch (SQLException ex1) {
                    ex1.printStackTrace();
                }
                return null;
            }

        } else {
            return null;
        }

    }
    
    public Autor alterar(Autor aut) {
        
        if (conexaoDB.conectar()) {

            try {//possivelmente ocorrerá erro 
                connection = conexaoDB.getConnection();
                String sql = "UPDATE autor SET Nome = ? WHERE idAutor = ?";
                // prepared statement para inserção
                PreparedStatement stmt = connection.prepareStatement(sql);
                // seta os valores

                stmt.setString(1, aut.getNome());
                stmt.setLong(2, aut.getIdAutor());

                // executa
                stmt.executeUpdate();

                stmt.close();
                connection.commit();
                conexaoDB.desconectar();
                return aut;
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
    
    public Autor excluir(Autor aut) {
        
        if (conexaoDB.conectar()) {
            
        String sql = "DELETE FROM autor WHERE idAutor = ?";
            
            try {
                connection = conexaoDB.getConnection();
                
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setLong(1, aut.getIdAutor());
                
                preparedStatement.executeUpdate();
                
                connection.commit();
                conexaoDB.desconectar();

                return  aut;
                
            } catch (SQLException e) {
                e.printStackTrace();
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                return null;
            }
            finally{
                conexaoDB.desconectar();
            }
        } else {
            return null;
        }  
    }
    
    public Autor buscar(Autor aut) {
        
        if (conexaoDB.conectar()) {

            try {//possivelmente ocorrerá erro 
                connection = conexaoDB.getConnection();

                connection = conexaoDB.getConnection();
                
                String sql = "select * from autor WHERE idAutor = ?";
                PreparedStatement stmt = connection.prepareStatement(sql);

                stmt.setLong(1, aut.getIdAutor());

                ResultSet rs = stmt.executeQuery();

                Autor retorno = null;
                if (rs.next()) {

                    retorno = new Autor(
                            rs.getLong("idAutor"),
                            rs.getString("Nome"));
                   
                }
                rs.close();
                conexaoDB.desconectar();
                return retorno;

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
    
    public List<Autor> listar(Autor autEnt) throws SQLException {
        // usus: array armazena a lista de registros
        if (conexaoDB.conectar()) {

            try {//possivelmente ocorrerá erro 
                connection = conexaoDB.getConnection();

                List<Autor> auts = new ArrayList<>();

                String sql = "select * from autor where Nome like ?";

                PreparedStatement stmt = connection.prepareStatement(sql);
                // seta os valores
                stmt.setString(1, "%" + autEnt.getNome() + "%");

                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    // criando o objeto Usuario
                    Autor aut = new Autor(
                            rs.getLong("idAutor"),
                            rs.getString("Nome"));
                          
                
                    // adiciona o usu à lista de usus
                    auts.add(aut);
                }

                rs.close();
                stmt.close();
                conexaoDB.desconectar();
                return auts;

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
