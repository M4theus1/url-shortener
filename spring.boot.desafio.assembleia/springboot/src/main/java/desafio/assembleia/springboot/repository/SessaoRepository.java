package desafio.assembleia.springboot.repository;

import desafio.assembleia.springboot.model.Sessao;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class SessaoRepository {

    // Sessões identificadas por pautaId
    private final Map<Long, Sessao> sessoes = new ConcurrentHashMap<>();

    // Salvar sessão vinculada a uma pauta
    public Sessao salvar(Sessao sessao) {
        Long pautaId = sessao.getPautaId();
        sessoes.put(pautaId, sessao);
        return sessao;
    }

    // Buscar por pautaId
    public Optional<Sessao> buscarPorPautaId(Long pautaId) {
        return Optional.ofNullable(sessoes.get(pautaId));
    }

    // Listar todas as sessões (opcional)
    public List<Sessao> listarTodas() {
        return new ArrayList<>(sessoes.values());
    }
}
