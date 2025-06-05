package com.empresa.acrilico.controller;

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
