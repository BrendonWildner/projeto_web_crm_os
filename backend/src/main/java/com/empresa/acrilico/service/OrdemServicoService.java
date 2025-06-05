
package com.empresa.acrilico.service;
import com.empresa.acrilico.model.OrdemServico;
import com.empresa.acrilico.repository.OrdemServicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrdemServicoService {
    private final OrdemServicoRepository repository;

    public OrdemServico salvar(OrdemServico os) {
        os.setDataCriacao(LocalDateTime.now());
        return repository.save(os);
    }

    public List<OrdemServico> listar() {
        return repository.findAll();
    }

    public OrdemServico atualizarStatus(Long id, OrdemServico.Status status) {
        OrdemServico os = repository.findById(id).orElseThrow();
        os.setStatus(status);
        if (status == OrdemServico.Status.FINALIZADO) {
            os.setDataConclusao(LocalDateTime.now());
        }
        return repository.save(os);
    }
}
