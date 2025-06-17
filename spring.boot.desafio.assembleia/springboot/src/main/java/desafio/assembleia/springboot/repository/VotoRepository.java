package desafio.assembleia.springboot.repository;

import desafio.assembleia.springboot.model.Voto;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class VotoRepository {

    // Mapeia uma lista de votos por pautaId
    private final Map<Long, List<Voto>> votosPorPauta = new ConcurrentHashMap<>();

    // Salvar um voto
    public void salvar(Voto voto) {
        votosPorPauta
                .computeIfAbsent(voto.getPautaId(), k -> new ArrayList<>())
                .add(voto);
    }

    // Buscar todos os votos de uma pauta
    public List<Voto> buscarPorPautaId(Long pautaId) {
        return votosPorPauta.getOrDefault(pautaId, Collections.emptyList());
    }

    // Verificar se um CPF já votou em uma pauta
    public boolean jaVotou(Long pautaId, String cpfAssociado) {
        return votosPorPauta.getOrDefault(pautaId, Collections.emptyList())
                .stream()
                .anyMatch(v -> v.getCpfAssociado().equals(cpfAssociado));
    }

    // Contar votos SIM e NAO
    public long contarVotosSim(Long pautaId) {
        return votosPorPauta.getOrDefault(pautaId, Collections.emptyList())
                .stream()
                .filter(v -> v.getTipo().equals(Voto.VotoTipo.SIM))
                .count();
    }

    public long contarVotosNao(Long pautaId) {
        return votosPorPauta.getOrDefault(pautaId, Collections.emptyList())
                .stream()
                .filter(v -> v.getTipo().equals(Voto.VotoTipo.NAO))
                .count();
    }
}
