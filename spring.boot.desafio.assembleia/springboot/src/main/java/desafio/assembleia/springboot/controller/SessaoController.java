package desafio.assembleia.springboot.controller;

import desafio.assembleia.springboot.model.Sessao;
import desafio.assembleia.springboot.services.SessaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sessao")
public class SessaoController {

    private final SessaoService sessaoService;

    public SessaoController(SessaoService sessaoService) {
        this.sessaoService = sessaoService;
    }

    @PostMapping
    public ResponseEntity<?> abrirSessao(@RequestBody SessaoRequest request) {
        try {
            Sessao sessao = sessaoService.abrirSessao(request.getPautaId(), request.getDuracaoEmMinutos());
            return ResponseEntity.status(HttpStatus.CREATED).body(sessao);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    public static class SessaoRequest {
        private Long pautaId;
        private Integer duracaoEmMinutos;

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
    }
}
