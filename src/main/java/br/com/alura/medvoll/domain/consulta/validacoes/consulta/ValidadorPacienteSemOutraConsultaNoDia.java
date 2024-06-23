package br.com.alura.medvoll.domain.consulta.validacoes.consulta;

import br.com.alura.medvoll.domain.ValidacaoException;
import br.com.alura.medvoll.domain.consulta.ConsultaRepository;
import br.com.alura.medvoll.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteSemOutraConsultaNoDia implements ValidadorAgendamentoDeConsulta {

    @Autowired
    private ConsultaRepository repository;

    public void validar(DadosAgendamentoConsulta dados){
        var primeiroHorario = dados.data().withHour(7);
        var ultimoHorario = dados.data().withHour(18);
        var pacientePossuiOutraDataNoDia = repository.existsByPacienteIdAndDataBetween(dados.idPaciente(), primeiroHorario, ultimoHorario);
        if (pacientePossuiOutraDataNoDia){
        throw new ValidacaoException("Paciente ja possui uma consulta nesse dia");
        }
    }


}
