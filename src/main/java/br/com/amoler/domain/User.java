package br.com.amoler.domain;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("user")
@Data
@SuperBuilder
public abstract class User {

    protected String name;
    protected String document;
    protected String email;
    protected Address address;
    protected UserType userType;
}
