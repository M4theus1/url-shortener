package desafio.assembleia.springboot.dto;

import jakarta.validation.constraints.NotNull;

public class PautaRequest {

    @NotNull
    private Long id;

    @NotNull
    private String titulo;

    public Long getId(){
        return id;
    }

    public String getTitulo(){
        return titulo;
    }
}
