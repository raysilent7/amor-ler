package br.com.amoler.domain;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class Address {

    @NotNull(message = "Rua não pode ser nula")
    private String street;
    private String neighborhood;
    @NotNull(message = "Município não pode ser nulo")
    private String city;
    @NotNull(message = "Estado não pode ser nulo")
    private String uf;
    private String zipCode;
    private String complement;
    private Long number;
}
