package br.com.alura.medvoll.controller;

import br.com.alura.medvoll.endereco.Endereco;
import br.com.alura.medvoll.medico.DadosCadastroMedico;
import br.com.alura.medvoll.medico.DadosListagemMedico;
import br.com.alura.medvoll.medico.Medico;
import br.com.alura.medvoll.medico.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repositorio;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){
        repositorio.save(new Medico(dados));
    }

    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return repositorio.findAll(paginacao).map(DadosListagemMedico::new);
    }
}
