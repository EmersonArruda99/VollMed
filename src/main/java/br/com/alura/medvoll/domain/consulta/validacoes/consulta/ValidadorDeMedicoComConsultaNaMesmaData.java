package br.com.alura.medvoll.domain.consulta.validacoes.consulta;

import br.com.alura.medvoll.domain.consulta.ConsultaRepository;
import br.com.alura.medvoll.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorDeMedicoComConsultaNaMesmaData implements ValidadorAgendamentoDeConsulta {

    @Autowired
    private ConsultaRepository repository;

    public void validar(DadosAgendamentoConsulta dados){
        var medicoPossuiOutraConsultaNesseHorario = repository.existsByMedicoIdAndDataAndMotivoCancelamentoIsNull(dados.idMedico(), dados.data());
    }
}
