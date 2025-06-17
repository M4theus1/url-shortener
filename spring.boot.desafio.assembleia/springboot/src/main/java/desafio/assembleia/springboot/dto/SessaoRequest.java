package desafio.assembleia.springboot.dto;

import jakarta.validation.constraints.NotNull;

public class SessaoRequest {

    @NotNull
    private Long pautaId;

    @NotNull
    private int duracaoEmMinutos;

    public Long getPautaId() {
        return pautaId;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }
}
