package projectAppMusic.bean;

public class Musica {
    private Long  id_musica;
    private Autor  autor;
    private Composicao composicao;

    public Musica(Long id_musica, Autor autor, Composicao composicao) {
        this.id_musica = id_musica;
        this.autor = autor;
        this.composicao = composicao;
    }

    public Musica(Long id_musica) {
        this.id_musica = id_musica;
    }

    public Musica(Autor autor, Composicao composicao) {
        this.autor = autor;
        this.composicao = composicao;
    }
    

    public Long getId_musica() {
        return id_musica;
    }

    public void setId_musica(Long id_musica) {
        this.id_musica = id_musica;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Composicao getComposicao() {
        return composicao;
    }

    public void setComposicao(Composicao composicao) {
        this.composicao = composicao;
    }

    @Override
    public String toString() {
        return "Musica{" + "id_musica=" + id_musica + ", autor=" + autor + ", composicao=" + composicao + '}';
    }
    
}
