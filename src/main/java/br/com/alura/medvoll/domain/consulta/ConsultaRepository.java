package br.com.alura.medvoll.domain.consulta;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.function.BiPredicate;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    boolean existsByMedicoIdAndDataAndMotivoCancelamentoIsNull(Long idMedico, LocalDateTime data);

    Boolean existsByPacienteIdAndDataBetween(Long aLong, LocalDateTime primeiroHorario, LocalDateTime ultimoHorario);
}
