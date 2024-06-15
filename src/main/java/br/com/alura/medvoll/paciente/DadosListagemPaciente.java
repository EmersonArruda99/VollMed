package br.com.alura.medvoll.paciente;

public record DadosListagemPaciente(String nome, String email, String cpf) {

    public  DadosListagemPaciente(Paciente paciente) {
        this(paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }

}
