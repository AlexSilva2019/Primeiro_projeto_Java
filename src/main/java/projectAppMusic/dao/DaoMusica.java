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
import projectAppMusic.bean.Musica;
/**
 *
 * @author User
 */
public class DaoMusica {
    
    private final Conexao conexaoDB;
    private Connection connection;

    public DaoMusica() {
        conexaoDB = new Conexao();
    }
    
    public Musica inserir(Musica msc) {
        if (conexaoDB.conectar()) {

            try {
                connection = conexaoDB.getConnection();

                String sql = "insert into musica" + " (Autor_idAutor, composicao_codigo_composicao)" + " values (?,?)";

                // prepared statement para inserção
                PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                // seta os valores
                stmt.setLong(1, msc.getAutor().getIdAutor());
                stmt.setLong(2, msc.getComposicao().getCodigo_composicao());   
                // executa
                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    msc.setId_musica(rs.getLong(1));

                }
                rs.close();

                stmt.close();
                connection.commit();
                conexaoDB.desconectar();
                return msc;
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

     public Musica alterar(Musica msc) {
        if (conexaoDB.conectar()) {

            try {//possivelmente ocorrerá erro 
                connection = conexaoDB.getConnection();
                String sql = "UPDATE musica SET Autor_idAutor = ?, composicao_codigo_composicao = ? "
                        + " WHERE id_musica = ?";
                // prepared statement para inserção
                PreparedStatement stmt = connection.prepareStatement(sql);
                // seta os valores
                
                stmt.setLong(1, msc.getAutor().getIdAutor());
                stmt.setLong(2, msc.getComposicao().getCodigo_composicao());
                stmt.setLong(3, msc.getId_musica());    
                // executa
                stmt.executeUpdate();

                stmt.close();
                connection.commit();
                conexaoDB.desconectar();
                return msc;
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
     
     public Musica excluir(Musica msc) {
        
        if (conexaoDB.conectar()) {
            
        String sql = "DELETE FROM musica WHERE id_musica = ?";
            
            try {
                connection = conexaoDB.getConnection();
                
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setLong(1, msc.getId_musica());
                
                preparedStatement.executeUpdate();
                
                connection.commit();
                conexaoDB.desconectar();

                return  msc;
                
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
     
     public Musica buscar(Musica msc) {
        
        if (conexaoDB.conectar()) {

            try {//possivelmente ocorrerá erro 
                connection = conexaoDB.getConnection();

                connection = conexaoDB.getConnection();
                
                String sql = "select * from musica WHERE id_musica = ?";
                PreparedStatement stmt = connection.prepareStatement(sql);

                stmt.setLong(1, msc.getId_musica());

                ResultSet rs = stmt.executeQuery();

                Musica retorno = null;
                if (rs.next()) {

                   retorno = new Musica(rs.getLong("id_musica"));
                   
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
     
     public List<Musica> listar(Musica mscEnt) throws SQLException {
        // usus: array armazena a lista de registros
        if (conexaoDB.conectar()) {

            try {//possivelmente ocorrerá erro 
                connection = conexaoDB.getConnection();

                connection = conexaoDB.getConnection();

                List<Musica> msca = new ArrayList<>();

                String sql = "select * from musica where id_musica like ?";

                PreparedStatement stmt = connection.prepareStatement(sql);
                // seta os valores
                stmt.setString(1, "%" + mscEnt.getId_musica() + "%");

                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    // criando o objeto Usuario
                    Musica msc = new Musica(
                            rs.getLong("id_musica"));

                    // adiciona o usu à lista de usus
                    msca.add(msc);
                }

                rs.close();
                stmt.close();
                conexaoDB.desconectar();
                return msca;

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
