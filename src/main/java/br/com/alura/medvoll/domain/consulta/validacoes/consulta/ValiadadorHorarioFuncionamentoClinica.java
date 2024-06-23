package br.com.alura.medvoll.domain.consulta.validacoes.consulta;

import br.com.alura.medvoll.domain.ValidacaoException;
import br.com.alura.medvoll.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValiadadorHorarioFuncionamentoClinica  implements ValidadorAgendamentoDeConsulta {

    public void validar(DadosAgendamentoConsulta dados){

        var dataConsulta = dados.data();
        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDaAberturaDaClinica = dataConsulta.getHour() < 7;
        var depoisDoEncerramentoDaClinica = dataConsulta.getHour() > 18;

        if (domingo || antesDaAberturaDaClinica || depoisDoEncerramentoDaClinica){
        throw new ValidacaoException("Consulta fora do horario de funcionamento");
        }
    }
}
