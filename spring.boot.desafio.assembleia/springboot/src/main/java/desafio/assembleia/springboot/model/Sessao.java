package desafio.assembleia.springboot.model;

import java.time.LocalDateTime;

public class Sessao {
    private Long pautaId;
    private Integer duracaoEmMinutos;
    private LocalDateTime dataHoraInicio;
    private LocalDateTime dataHoraFim;

    public Sessao() {
    }

    public Sessao(Long pautaId, Integer duracaoEmMinutos) {
        this.pautaId = pautaId;
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public Long getPautaId() {
        return pautaId;
    }

    public void setPautaId(Long pautaId) {
        this.pautaId = pautaId;
    }

    public Integer getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public void setDuracaoEmMinutos(Integer duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public LocalDateTime getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(LocalDateTime dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public LocalDateTime getDataHoraFim() {
        return dataHoraFim;
    }

    public void setDataHoraFim(LocalDateTime dataHoraFim) {
        this.dataHoraFim = dataHoraFim;
    }
}
