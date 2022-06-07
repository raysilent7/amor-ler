package br.com.amoler.service.strategy;

import br.com.amoler.domain.Employee;
import br.com.amoler.domain.User;
import br.com.amoler.domain.UserType;
import br.com.amoler.domain.request.RegistryRequest;
import br.com.amoler.domain.response.AddressResponse;
import br.com.amoler.domain.response.ViaCepResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@Component
public class EmployeeStrategy extends UserAbstractStrategy {

    @Override
    public Mono<User> buildNewUser (RegistryRequest request, UserType type) {
        return Mono.just(Employee.builder()
                .userType(type)
                .name(request.getName())
                .document(request.getDocument())
                .email(request.getEmail())
                .address(request.getAddress())
                .salary(request.getSalary())
                .build());
    }

    @Override
    public Mono<User> completeUserRegister (Tuple2<User, ViaCepResponse> tuple) {
        Employee employee = (Employee) tuple.getT1();
        AddressResponse response = tuple.getT2().getAddressResponseList().get(0);
        employee.getAddress().setZipCode(response.getZipCode());
        return Mono.just(employee);
    }
}
