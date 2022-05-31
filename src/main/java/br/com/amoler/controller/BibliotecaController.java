package br.com.amoler.controller;

import br.com.amoler.domain.Funcionario;
import br.com.amoler.domain.request.FuncionarioRequest;
import br.com.amoler.service.CadastroService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/biblioteca")
@RequiredArgsConstructor
public class BibliotecaController {

    private final CadastroService cadastroService;

    @PostMapping(value = "/cadastro/funcionario", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public Mono<Funcionario> cadastroFuncionario(@RequestBody FuncionarioRequest request) {

        return cadastroService.cadastrar(request);
    }
}
