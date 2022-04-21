package projectAppMusic.bean;


public class Autor {
    private Long idAutor;
    private String nome;

    public Autor(Long idAutor) {
        this.idAutor = idAutor;
    }

    
    public Autor(Long idAutor, String nome) {
        this.idAutor = idAutor;
        this.nome = nome;
    }

    public Autor(String nome) {
        this.nome = nome;
    }


    public Long getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Long idAutor) {
        this.idAutor = idAutor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Autor{" + "idAutor=" + idAutor + ", nome=" + nome + '}';
    }
    
}
