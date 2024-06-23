package br.com.alura.medvoll.controller;

import br.com.alura.medvoll.domain.consulta.AgendaDeConsultas;
import br.com.alura.medvoll.domain.consulta.DadosAgendamentoConsulta;
import br.com.alura.medvoll.domain.consulta.DadosCancelamentoConsulta;
import br.com.alura.medvoll.domain.consulta.DadosDetalhamentoConsulta;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController @RequestMapping("consultas")
public class ConsultaController {
    @Autowired
    private AgendaDeConsultas agenda;

    @PostMapping @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendamentoConsulta dados){
        var dto = agenda.agendar(dados);
        return  ResponseEntity.ok(dto);
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity cancelar(@RequestBody @Valid DadosCancelamentoConsulta dados) {
        agenda.cancelar(dados);
        return ResponseEntity.noContent().build();
    }
}
