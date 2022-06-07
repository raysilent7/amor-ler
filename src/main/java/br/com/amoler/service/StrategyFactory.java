package br.com.amoler.service;

import br.com.amoler.domain.UserType;
import br.com.amoler.service.strategy.CustomerStrategy;
import br.com.amoler.service.strategy.EmployeeStrategy;
import br.com.amoler.service.strategy.UserAbstractStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StrategyFactory {

    private final EmployeeStrategy employeeStrategy;
    private final CustomerStrategy customerStrategy;

    public UserAbstractStrategy getStrategy (UserType userType) {
        if (UserType.CUSTOMER.equals(userType)) {
            return customerStrategy;
        }
        return employeeStrategy;
    }
}
