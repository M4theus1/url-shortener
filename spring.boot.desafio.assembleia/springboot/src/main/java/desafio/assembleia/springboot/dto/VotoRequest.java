package desafio.assembleia.springboot.dto;

import desafio.assembleia.springboot.model.Voto;
import jakarta.validation.constraints.NotNull;

public class VotoRequest {

    @NotNull
    private Long pautaId;

    @NotNull
    private String cpfAssociado;

    @NotNull
    private Voto.VotoTipo tipo;

    public Long getPautaId() {
        return pautaId;
    }

    public String getCpfAssociado() {
        return cpfAssociado;
    }

    public Voto.VotoTipo getTipo() {
        return tipo;
    }
}
