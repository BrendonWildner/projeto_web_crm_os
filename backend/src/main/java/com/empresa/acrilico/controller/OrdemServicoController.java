
package com.empresa.acrilico.controller;
import com.empresa.acrilico.model.OrdemServico;
import com.empresa.acrilico.service.OrdemServicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/ordens")
@RequiredArgsConstructor
public class OrdemServicoController {
    private final OrdemServicoService service;

    @PostMapping
    public OrdemServico criar(@RequestBody OrdemServico os) {
        return service.salvar(os);
    }

    @GetMapping
    public List<OrdemServico> listar() {
        return service.listar();
    }

    @PatchMapping("/{id}/status")
    public OrdemServico atualizarStatus(@PathVariable Long id, @RequestParam OrdemServico.Status status) {
        return service.atualizarStatus(id, status);
    }
}
