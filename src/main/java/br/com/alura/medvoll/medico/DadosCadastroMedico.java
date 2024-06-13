package br.com.alura.medvoll.medico;

import br.com.alura.medvoll.endereco.DadosEndereco;

public record DadosCadastroMedico(String nome,
                                  String email,
                                  String crm,
                                  Especialidade especialidade,
                                  DadosEndereco endereco) {
}
