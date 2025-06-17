package desafio.assembleia.springboot.model;

public class Voto {

    private Long pautaId;
    private String cpfAssociado;
    private VotoTipo tipo;

    public Voto(Long pautaId, String cpfAssociado, VotoTipo tipo) {
        this.pautaId = pautaId;
        this.cpfAssociado = cpfAssociado;
        this.tipo = tipo;
    }

    // Enum pode ser interno ou externo à classe
    public enum VotoTipo {
        SIM, NAO
    }

    // Getters (opcional)
    public Long getPautaId() {
        return pautaId;
    }

    public String getCpfAssociado() {
        return cpfAssociado;
    }

    public VotoTipo getTipo() {
        return tipo;
    }

    public void setPautaId(Long pautaId) {
        this.pautaId = pautaId;
    }

    public void setCpfAssociado(String cpfAssociado) {
        this.cpfAssociado = cpfAssociado;
    }

    public void setTipo(VotoTipo tipo) {
        this.tipo = tipo;
    }
}
