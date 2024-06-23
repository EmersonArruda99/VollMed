package br.com.alura.medvoll.domain.consulta;

import java.time.LocalDateTime;

public record DadosDetalhamentoConsult(Long id, Long idMedico, Long idPaciente, LocalDateTime data) {
}
