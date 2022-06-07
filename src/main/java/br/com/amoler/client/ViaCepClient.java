package br.com.amoler.client;

import br.com.amoler.domain.Address;
import br.com.amoler.domain.User;
import br.com.amoler.domain.response.ViaCepResponse;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;

@Component
public class ViaCepClient {

    private final WebClient webClient;
    private final String VIA_CEP_URL = "https://viacep.com.br/ws";

    public ViaCepClient () {
        HttpClient httpClient = HttpClient.create().responseTimeout(Duration.ofMillis(5000));
        this.webClient = WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .baseUrl(VIA_CEP_URL)
                .build();
    }

    public Mono<ViaCepResponse> getZipCodeByAddress (User user) {
        Address address = user.getAddress();
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/{UF}/{city}/{street}/json/").build(address.getUf(), address.getCity(), address.getStreet()))
                .retrieve()
                .bodyToMono(ViaCepResponse.class);
    }
}
