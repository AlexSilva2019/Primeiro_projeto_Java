package projectAppMusic.bean;

public class Usuario extends Pessoa {
    
    private Long idUsu;
    private String login;
    private String senha;
    private String status;

    public Usuario(String login) {
        this.login = login;
    }

    public Usuario() {
    }
 
    
    public Usuario(Long id, String nome) {
        super(id, nome);
    }

    
    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }


    public Usuario(Long idUsu, String login, String senha, String status) {
        this.idUsu = idUsu;
        this.login = login;
        this.senha = senha;
        this.status = status;
    }

    public Usuario(Long idUsu) {
        this.idUsu = idUsu;
    }

    public Usuario(Long idUsu, String login, String senha, String status, Long id, String nome) {
        super(id, nome);
        this.idUsu = idUsu;
        this.login = login;
        this.senha = senha;
        this.status = status;
    }

    public Usuario(Long idUsu, String login, String senha, String status, Long id) {
        super(id);
        this.idUsu = idUsu;
        this.login = login;
        this.senha = senha;
        this.status = status;
    }
    
    
    public Usuario(String login, String senha, String status, String nome) {
    super(nome);
    this.login = login;
    this.senha = senha;
    this.status = status;
    
    }

   


    public Long getIdUsu() {
        return idUsu;
    }

    public void setIdUsu(Long idUsu) {
        this.idUsu = idUsu;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return super.toString() + "Usuario{" + "idUsu=" + idUsu + ", login=" + login + ", senha=" + senha + ", status=" + status + '}';
    }
    
    
}
