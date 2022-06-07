package br.com.amoler.domain.request;

import br.com.amoler.domain.Address;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class RegistryRequest {

    private String name;
    private String document;
    private String email;
    private Address address;
    private BigDecimal salary;
}
