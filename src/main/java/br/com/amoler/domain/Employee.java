package br.com.amoler.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;


@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class Employee extends User {

    private BigDecimal salary;
}
