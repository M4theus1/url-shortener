package desafio.assembleia.springboot.controller;

import desafio.assembleia.springboot.services.VotoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/voto")
public class VotoController {

    private final VotoService votoService;

    public VotoController(VotoService votoService) {
        this.votoService = votoService;
    }

    @PostMapping
    public ResponseEntity<?> registrarVoto(@RequestBody VotoRequest request) {
        try {
            votoService.registrarVoto(request.getPautaId(), request.getCpfAssociado(), request.getVoto());
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    public static class VotoRequest {
        private Long pautaId;
        private String cpfAssociado;
        private String voto;

        public Long getPautaId() {
            return pautaId;
        }

        public void setPautaId(Long pautaId) {
            this.pautaId = pautaId;
        }

        public String getCpfAssociado() {
            return cpfAssociado;
        }

        public void setCpfAssociado(String cpfAssociado) {
            this.cpfAssociado = cpfAssociado;
        }

        public String getVoto() {
            return voto;
        }

        public void setVoto(String voto) {
            this.voto = voto;
        }
    }
}
