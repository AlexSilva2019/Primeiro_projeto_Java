package projectAppMusic.bean;

public class Composicao {
    private Long codigo_composicao;
    private String nome_composicao;
    private String duracao_composicao;

    public Composicao(Long codigo_composicao, String nome_composicao, String duracao_composicao) {
        this.codigo_composicao = codigo_composicao;
        this.nome_composicao = nome_composicao;
        this.duracao_composicao = duracao_composicao;
    }

    public Composicao(Long codigo_composicao, String nome_composicao) {
        this.codigo_composicao = codigo_composicao;
        this.nome_composicao = nome_composicao;
    }

    public Composicao(Long codigo_composicao) {
        this.codigo_composicao = codigo_composicao;
    }
    
    

    public Composicao(String nome_composicao) {
        this.nome_composicao = nome_composicao;
    }

    public Composicao(String nome_composicao, String duracao_composicao) {
        this.nome_composicao = nome_composicao;
        this.duracao_composicao = duracao_composicao;
    }
    
    

    public Long getCodigo_composicao() {
        return codigo_composicao;
    }

    public void setCodigo_composicao(Long codigo_composicao) {
        this.codigo_composicao = codigo_composicao;
    }

    public String getNome_composicao() {
        return nome_composicao;
    }

    public void setNome_composicao(String nome_composicao) {
        this.nome_composicao = nome_composicao;
    }

    public String getDuracao_composicao() {
        return duracao_composicao;
    }

    public void setDuracao_composicao(String duracao_composicao) {
        this.duracao_composicao = duracao_composicao;
    }

    @Override
    public String toString() {
        return "Composicao{" + "codigo_composicao=" + codigo_composicao + ", nome_composicao=" + nome_composicao + ", duracao_composicao=" + duracao_composicao + '}';
    }

    
}
