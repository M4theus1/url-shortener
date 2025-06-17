package desafio.assembleia.springboot.repository;

import desafio.assembleia.springboot.model.Pauta;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class PautaRepository {

    private final Map<Long, Pauta> pautas = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    //Salvar
    public Pauta salvar(Pauta pauta) {
        long id = idGenerator.getAndIncrement();
        pauta.setId(id);
        pautas.put(id, pauta);
        return pauta;
    }

    //buscar por id
    public Optional<Pauta> buscarPorId(Long id) {
        return Optional.ofNullable(pautas.get(id));
    }

    //listar
    public List <Pauta> listarTodas(){
        return new ArrayList<>(pautas.values());
    }
}
