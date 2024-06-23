package br.com.alura.medvoll.domain.consulta.validacoes.consulta;

import br.com.alura.medvoll.domain.ValidacaoException;
import br.com.alura.medvoll.domain.consulta.DadosAgendamentoConsulta;
import br.com.alura.medvoll.domain.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoAtivo implements ValidadorAgendamentoDeConsulta {

    @Autowired
    private MedicoRepository repository;

    public void validar(DadosAgendamentoConsulta dados){
        //se escolha de medico for opcional
        if (dados.idMedico() == null){
            return;
        }

        var medicoEstaAtivo = repository.findAtivoById(dados.idMedico());
        if (!medicoEstaAtivo){
            throw new ValidacaoException("Consulta não pode ser agendada com este médico!");
        }
    }
}
