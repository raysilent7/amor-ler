package br.com.amoler.service;

import br.com.amoler.client.ViaCepClient;
import br.com.amoler.domain.User;
import br.com.amoler.domain.UserType;
import br.com.amoler.domain.request.RegistryRequest;
import br.com.amoler.repository.UserRepository;
import br.com.amoler.service.strategy.UserAbstractStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class RegistryService {

    private final UserRepository userRepository;
    private final StrategyFactory strategyFactory;
    private final ViaCepClient viaCepClient;

    public Mono<User> register (RegistryRequest request, UserType type) {
        UserAbstractStrategy strategy = strategyFactory.getStrategy(type);
        return userRepository.findByDocumentAndUserType(request.getDocument(), type)
                .flatMap(strategy::checkUserAlreadyRegistered)
                .switchIfEmpty(strategy.buildNewUser(request, type))
                .zipWhen(viaCepClient::getZipCodeByAddress)
                .flatMap(strategy::completeUserRegister)
                .flatMap(userRepository::save);
    }
}
