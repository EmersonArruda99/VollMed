package br.com.alura.medvoll.controller;

import br.com.alura.medvoll.domain.usuario.DadosAutenticacao;
import br.com.alura.medvoll.domain.usuario.Usuario;
import br.com.alura.medvoll.infra.security.DadosTokenJwt;
import br.com.alura.medvoll.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados){
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var autenticado = manager.authenticate(authenticationToken);

        var tokenJwt = tokenService.gerarToken((Usuario) autenticado.getPrincipal());

        return ResponseEntity.ok(new DadosTokenJwt(tokenJwt));
    }

}
