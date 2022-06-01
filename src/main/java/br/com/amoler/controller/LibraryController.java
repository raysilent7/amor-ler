package br.com.amoler.controller;

import br.com.amoler.domain.Employee;
import br.com.amoler.domain.PersonType;
import br.com.amoler.domain.request.RegistryRequest;
import br.com.amoler.service.RegistryService;
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
public class LibraryController {

    private final RegistryService registryService;

    @PostMapping(value = "/cadastro/funcionario", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public Mono<Employee> registryEmployee(@RequestBody RegistryRequest registryRequest) {

        return registryService.register(registryRequest, PersonType.EMPLOYEE);
    }
}
