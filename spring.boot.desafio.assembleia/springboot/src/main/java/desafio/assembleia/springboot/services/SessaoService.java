package desafio.assembleia.springboot.services;

import desafio.assembleia.springboot.model.Sessao;
import desafio.assembleia.springboot.repository.SessaoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class SessaoService {

    private final SessaoRepository sessaoRepository;
    private final PautaService pautaService;

    public SessaoService(SessaoRepository sessaoRepository, PautaService pautaService) {
        this.sessaoRepository = sessaoRepository;
        this.pautaService = pautaService;
    }

    //create
    public Sessao abrirSessao(Long pautaId, Integer duracaoEmMinutos) {
        //verifica se pauta existe
        pautaService.buscarPorId(pautaId);

        //verifica se ja existe sessao para essa pauta
        if(sessaoRepository.buscarPorPautaId(pautaId).isPresent()){
            throw new IllegalArgumentException("Sessao já foi aberta para esta pauta");
        }
        int duracao = (duracaoEmMinutos != null && duracaoEmMinutos > 0) ? duracaoEmMinutos : 1;

        Sessao sessao = new Sessao();
        sessao.setPautaId(pautaId);
        sessao.setDataHoraInicio(LocalDateTime.now());
        sessao.setDataHoraFim(LocalDateTime.now().plusMinutes(duracao));

        return sessaoRepository.salvar(sessao);
    }

    // Buscar sessão por pautaId
    public Sessao buscarPorPautaId(Long pautaId) {
        return sessaoRepository.buscarPorPautaId(pautaId)
                .orElseThrow(() -> new IllegalArgumentException("Sessão não encontrada para a pauta " + pautaId));
    }

    // Verificar se a sessão está ativa
    public boolean sessaoAtiva(Long pautaId) {
        Sessao sessao = buscarPorPautaId(pautaId);
        return LocalDateTime.now().isBefore(sessao.getDataHoraFim());
    }
}
