package br.com.amoler.repository;


import br.com.amoler.domain.User;
import br.com.amoler.domain.UserType;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveMongoRepository<User, String> {

    Mono<User> findByDocumentAndUserType (String document, UserType userType);
}
