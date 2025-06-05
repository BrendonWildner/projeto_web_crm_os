package com.empresa.acrilico.controller;

@RestController
@RequestMapping("/fluxo-caixa")
@RequiredArgsConstructor
public class FluxoCaixaController {
    private final FluxoCaixaService service;

    @PostMapping
    public FluxoCaixa registrar(@RequestBody FluxoCaixa fluxo) {
        return service.registrar(fluxo);
    }

    @GetMapping
    public List<FluxoCaixa> listar() {
        return service.listar();
    }

    @GetMapping("/saldo")
    public BigDecimal saldo() {
        return service.saldoAtual();
    }
}
