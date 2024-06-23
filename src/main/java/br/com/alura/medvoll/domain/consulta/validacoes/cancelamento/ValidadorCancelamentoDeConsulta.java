package br.com.alura.medvoll.domain.consulta.validacoes.cancelamento;

import br.com.alura.medvoll.domain.consulta.DadosCancelamentoConsulta;

public interface ValidadorCancelamentoDeConsulta {
    void validar(DadosCancelamentoConsulta dados);
}
