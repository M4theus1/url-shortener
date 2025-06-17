package desafio.assembleia.springboot.services;

import desafio.assembleia.springboot.model.Voto;
import desafio.assembleia.springboot.model.Voto.VotoTipo;
import desafio.assembleia.springboot.repository.VotoRepository;
import org.springframework.stereotype.Service;

@Service
public class VotoService {

    private final VotoRepository votoRepository;
    private final PautaService pautaService;
    private final SessaoService sessaoService;

    public VotoService(VotoRepository votoRepository,
                       PautaService pautaService,
                       SessaoService sessaoService) {
        this.votoRepository = votoRepository;
        this.pautaService = pautaService;
        this.sessaoService = sessaoService;
    }

    // Registrar voto
    public void registrarVoto(Long pautaId, String cpfAssociado, String votoStr) {
        // Valida se pauta existe
        pautaService.buscarPorId(pautaId);

        // Verifica se sessão existe e está ativa
        if (!sessaoService.sessaoAtiva(pautaId)) {
            throw new IllegalStateException("Sessão encerrada ou inexistente para esta pauta.");
        }

        // Verifica se já votou
        if (votoRepository.jaVotou(pautaId, cpfAssociado)) {
            throw new IllegalArgumentException("Associado já votou nesta pauta.");
        }

        // Valida tipo de voto
        VotoTipo tipo;
        try {
            tipo = VotoTipo.valueOf(votoStr.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Voto inválido. Use SIM ou NAO.");
        }

        // Cria e salva voto
        Voto voto = new Voto(pautaId, cpfAssociado, tipo);
        votoRepository.salvar(voto);
    }
}
