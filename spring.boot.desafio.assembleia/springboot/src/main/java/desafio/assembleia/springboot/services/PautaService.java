package desafio.assembleia.springboot.services;

import desafio.assembleia.springboot.model.Pauta;
import desafio.assembleia.springboot.repository.PautaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PautaService {

    private final PautaRepository pautaRepository; //declaracao do repositorio

    public PautaService(PautaRepository pautaRepository){
        this.pautaRepository = pautaRepository; //injecao via construtor
    }

    //create
    public Pauta criarPauta(String titulo){
        if(titulo == null || titulo.trim().isEmpty()){
            throw new IllegalArgumentException("Título da pauta é obrigatório");
        }

        Pauta pauta = new Pauta();
        pauta.setTitulo(titulo.trim());
        return pautaRepository.salvar(pauta);
    }

    //search for ID
    public Pauta buscarPorId(Long id){
        return pautaRepository.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Pauta não encontrada"));
    }
}
