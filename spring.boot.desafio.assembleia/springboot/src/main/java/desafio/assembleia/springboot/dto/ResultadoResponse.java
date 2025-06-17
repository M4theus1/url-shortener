package desafio.assembleia.springboot.dto;

public class ResultadoResponse {
    private String pauta;
    private int totalVotos;
    private int votosSim;
    private int votosNao;
    private String resultado;

    public ResultadoResponse(String pauta, int totalVotos, int votosSim, int votosNao, String resultado) {
        this.pauta = pauta;
        this.votosSim = votosSim;
        this.votosNao = votosNao;
        this.totalVotos = votosSim + votosNao;
        this.resultado = votosSim > votosNao ? "APROVADA" : "REJEITADA";

    }

    public String getPauta() {
        return pauta;
    }

    public void setPauta(String pauta) {
        this.pauta = pauta;
    }

    public int getTotalVotos() {
        return totalVotos;
    }

    public void setTotalVotos(int totalVotos) {
        this.totalVotos = totalVotos;
    }

    public int getVotosSim() {
        return votosSim;
    }

    public void setVotosSim(int votosSim) {
        this.votosSim = votosSim;
    }

    public int getVotosNao() {
        return votosNao;
    }

    public void setVotosNao(int votosNao) {
        this.votosNao = votosNao;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
}
