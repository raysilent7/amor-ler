package br.com.amoler.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("user")
public abstract class User {

    private String name;
    private String cpf;
    private String email;
    private PersonType personType;
    private Address address;
}
