/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectAppMusic.dao;

import projectAppMusic.bean.Usuario;
import AppMusica.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoUsuario {

    private final Conexao conexaoDB;
    private Connection connection;

    public DaoUsuario() {
        conexaoDB = new Conexao();

    }

    public Usuario inserir(Usuario usu) {
        if (conexaoDB.conectar()) {

            try {
                connection = conexaoDB.getConnection();

                String sql = "insert into usuario" + " (Pessoa_idPessoa, Login, Password, Status)" + " values (?,?,?,?)";

                // prepared statement para inserção
                PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                // seta os valores
                stmt.setLong(1, usu.getId());
                stmt.setString(2, usu.getLogin());
                stmt.setString(3, usu.getSenha());
                stmt.setString(4, usu.getStatus());

                // executa
                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    usu.setIdUsu(rs.getLong(1));

                }
                rs.close();

                stmt.close();
                connection.commit();
                conexaoDB.desconectar();
                return usu;
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

    public Usuario alterar(Usuario usu) {
        if (conexaoDB.conectar()) {

            try {//possivelmente ocorrerá erro 
                connection = conexaoDB.getConnection();

                String sql = "UPDATE usuario SET Login = ?, Password = ?, Status = ? WHERE idUsuario = ?";
                // prepared statement para inserção
                PreparedStatement stmt = connection.prepareStatement(sql);
                // seta os valores

                stmt.setString(1, usu.getLogin());
                stmt.setString(2, usu.getSenha());
                stmt.setString(3, usu.getStatus());
                stmt.setLong(4, usu.getIdUsu());

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
                
                String sql = "select * from usuario WHERE idUsuario = ?";
                PreparedStatement stmt = connection.prepareStatement(sql);

                stmt.setLong(1, usu.getIdUsu());

                ResultSet rs = stmt.executeQuery();

                
                if (rs.next()) {

                    usu.setId(rs.getLong("Pessoa_idPessoa"));
                    System.out.println("Passou");        
                            
                }
                rs.close();
                
                sql = "delete from usuario WHERE idUsuario = ?";
                // prepared statement para inserção
                stmt = connection.prepareStatement(sql);
                // seta os valores

                stmt.setLong(1, usu.getIdUsu());

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

    public Usuario buscar(Usuario usu) {
        if (conexaoDB.conectar()) {

            try {//possivelmente ocorrerá erro 
                connection = conexaoDB.getConnection();

                connection = conexaoDB.getConnection();
                /*idUsuario bigint AI PK 
            Pessoa_idPessoa bigint 
            Login varchar(45) 
            Password varchar(45) 
            Status
            
            Long idUsu, String login, String senha, String status, Long id
                 */
                String sql = "select * from usuario WHERE idUsuario = ?";
                PreparedStatement stmt = connection.prepareStatement(sql);

                stmt.setLong(1, usu.getIdUsu());

                ResultSet rs = stmt.executeQuery();

                Usuario retorno = null;
                if (rs.next()) {

                    retorno = new Usuario(
                            rs.getLong("idUsuario"),
                            rs.getString("Login"),
                            rs.getString("Password"),
                            rs.getString("Status"),
                            rs.getLong("Pessoa_idPessoa"));
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

    public List<Usuario> listar(Usuario usuEnt) throws SQLException {
        // usus: array armazena a lista de registros
        if (conexaoDB.conectar()) {

            try {//possivelmente ocorrerá erro 
                connection = conexaoDB.getConnection();

                connection = conexaoDB.getConnection();

                List<Usuario> usus = new ArrayList<>();

                String sql = "select * from usuario where Login like ?";

                PreparedStatement stmt = connection.prepareStatement(sql);
                // seta os valores
                stmt.setString(1, "%" + usuEnt.getLogin() + "%");

                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    // criando o objeto Usuario
                    Usuario usu = new Usuario(
                            rs.getLong("idUsuario"),
                            rs.getString("Login"),
                            rs.getString("Password"),
                            rs.getString("Status"),
                            rs.getLong("Pessoa_idPessoa")
                    );
                    // adiciona o usu à lista de usus
                    usus.add(usu);
                }

                rs.close();
                stmt.close();
                conexaoDB.desconectar();
                return usus;

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

    public Usuario validar(Usuario usu) {

        if (conexaoDB.conectar()) {

            try {//possivelmente ocorrerá erro 
                connection = conexaoDB.getConnection();

                connection = conexaoDB.getConnection();

                // cria o select para ser executado no banco de dados 
                String sql = "select * from usuario WHERE Login = ? AND Password = ?";
                // prepared statement para seleção
                PreparedStatement stmt = connection.prepareStatement(sql);
                // seta os valores
                stmt.setString(1, usu.getLogin());
                stmt.setString(2, usu.getSenha());

                ResultSet rs = stmt.executeQuery();

                Usuario retorno = null;
                if (rs.next()) {

                    retorno = new Usuario(
                            rs.getLong("idUsuario"),
                            rs.getString("Login"),
                            rs.getString("Password"),
                            rs.getString("Status"),
                            rs.getLong("Pessoa_idPessoa"));
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
}
