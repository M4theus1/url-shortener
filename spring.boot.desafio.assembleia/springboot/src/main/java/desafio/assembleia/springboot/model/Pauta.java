package desafio.assembleia.springboot.model;

public class Pauta {
    private Long id;
    private String titulo;

    public Pauta(Long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public Pauta() {
        this.id = id;
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
