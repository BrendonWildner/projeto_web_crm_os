
package com.empresa.acrilico.model;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class OrdemServico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cliente;
    private String descricao;

    @Enumerated(EnumType.STRING)
    private Status status;
    private BigDecimal valor;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataConclusao;

    public enum Status {
        NOVO, ANDAMENTO, FINALIZADO
    }
}
