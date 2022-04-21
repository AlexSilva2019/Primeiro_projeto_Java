    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import projectAppMusic.bean.Composicao;


public class DaoComposicao {
    
    private final Conexao conexaoDB;
    private Connection connection;

    public DaoComposicao() {
        conexaoDB = new Conexao();

    }

    public Composicao inserir(Composicao comp) {
    	
    	 if (conexaoDB.conectar()) {

             try {
                 connection = conexaoDB.getConnection();

                 String sql = "insert into composicao" + " (nome_composicao, duracao_composicao)" + " values (?,?)";

                 // prepared statement para inserção
                 PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                 // seta os valores
                 stmt.setString(1, comp.getNome_composicao());
                 stmt.setString(2, comp.getDuracao_composicao());
                    
                 // executa
                 stmt.executeUpdate();
                 ResultSet rs = stmt.getGeneratedKeys();
                 if (rs.next()) {
                     comp.setCodigo_composicao(rs.getLong(1));

                 }
                 rs.close();

                 stmt.close();
                 connection.commit();
                 conexaoDB.desconectar();
                 return comp;
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

    public Composicao alterar(Composicao comp) {
    	
    	if (conexaoDB.conectar()) {

            try {//possivelmente ocorrerá erro 
                connection = conexaoDB.getConnection();

                String sql = "UPDATE composicao SET nome_composicao = ? WHERE codigo_composicao = ?";
                // prepared statement para inserção
                PreparedStatement stmt = connection.prepareStatement(sql);
                // seta os valores

                stmt.setString(1, comp.getNome_composicao());
                stmt.setLong(2, comp.getCodigo_composicao());

                // executa
                stmt.executeUpdate();

                stmt.close();
                connection.commit();
                conexaoDB.desconectar();
                return comp;
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

    public Composicao excluir(Composicao comp) {
    	

        if (conexaoDB.conectar()) {
            
        String sql = "DELETE FROM composicao WHERE codigo_composicao = ?";
            
            try {
                connection = conexaoDB.getConnection();
                
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setLong(1, comp.getCodigo_composicao());
                
                preparedStatement.executeUpdate();
                
                connection.commit();
                conexaoDB.desconectar();

                return  comp;
                
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

    public Composicao buscar(Composicao comp) {
    	
    	 if (conexaoDB.conectar()) {

             try {//possivelmente ocorrerá erro 
                 connection = conexaoDB.getConnection();

                 connection = conexaoDB.getConnection();
                 
                 String sql = "select * from composicao WHERE codigo_composicao = ?";
                 PreparedStatement stmt = connection.prepareStatement(sql);

                 stmt.setLong(1, comp.getCodigo_composicao());

                 ResultSet rs = stmt.executeQuery();

                 Composicao retorno = null;
                 if (rs.next()) {

                     retorno = new Composicao(
                             rs.getLong("codigo_composicao"),
                             rs.getString("nome_composicao"));
                    
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

    public List<Composicao> listar(Composicao compEnt) {
    	
    	if (conexaoDB.conectar()) {

            try {//possivelmente ocorrerá erro 
                connection = conexaoDB.getConnection();

                connection = conexaoDB.getConnection();

                List<Composicao> comps = new ArrayList<>();

                String sql = "select * from composicao where nome_composicao like ?";

                PreparedStatement stmt = connection.prepareStatement(sql);
                // seta os valores
                stmt.setString(1, "%" + compEnt.getNome_composicao() + "%");

                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    // criando o objeto Usuario
                    Composicao comp = new Composicao(
                            rs.getLong("codigo_composicao"),
                            rs.getString("nome_composicao")
                    );

                    // adiciona o usu à lista de usus
                    comps.add(comp);
                }

                rs.close();
                stmt.close();
                conexaoDB.desconectar();
                return comps;

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
    	
    	
