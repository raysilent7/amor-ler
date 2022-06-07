package br.com.amoler.service.strategy;

import br.com.amoler.domain.User;
import br.com.amoler.domain.UserType;
import br.com.amoler.domain.request.RegistryRequest;
import br.com.amoler.domain.response.ViaCepResponse;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.util.Objects;

public abstract class UserAbstractStrategy {

    public Mono<User> checkUserAlreadyRegistered (User user) {
        if (Objects.isNull(user)) {
            return Mono.empty();
        }
        return Mono.error(new RuntimeException("Usuario ja está cadastrado."));
    }

    public Mono<User> buildNewUser (RegistryRequest request, UserType type) {
        return null;
    }

    public Mono<User> completeUserRegister (Tuple2<User, ViaCepResponse> tuple) {
        return null;
    }
}
