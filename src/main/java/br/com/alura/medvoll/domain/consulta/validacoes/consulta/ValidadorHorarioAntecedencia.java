package br.com.alura.medvoll.domain.consulta.validacoes.consulta;

import br.com.alura.medvoll.domain.ValidacaoException;
import br.com.alura.medvoll.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component("ValidadorHorarioAntecedenciaAgendamento")
public class ValidadorHorarioAntecedencia implements ValidadorAgendamentoDeConsulta {

    public void validar(DadosAgendamentoConsulta dados){

        var dataConsulta = dados.data();
        var agora = LocalDateTime.now();
        var diferencaEmMinutos = Duration.between(agora, dataConsulta).toMinutes();

        if(diferencaEmMinutos < 30){
            throw new ValidacaoException("Consultas devem ser agendadas com antecedência minima de 30 minutos!");
        }

    }
}

