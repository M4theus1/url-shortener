package desafio.assembleia.springboot.controller;

import desafio.assembleia.springboot.model.Pauta;
import desafio.assembleia.springboot.services.PautaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pauta")
public class PautaController {

    private final PautaService pautaService;

    public PautaController(PautaService pautaService) {
        this.pautaService = pautaService;
    }

    @PostMapping
    public ResponseEntity<?> criarPauta(@RequestBody PautaRequest request) {
        try {
            Pauta pauta = pautaService.criarPauta(request.getTitulo());
            return ResponseEntity.status(HttpStatus.CREATED).body(pauta);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    public static class PautaRequest {
        private String titulo;

        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }
    }
}
