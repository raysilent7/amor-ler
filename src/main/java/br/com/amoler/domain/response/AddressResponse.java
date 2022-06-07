package br.com.amoler.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressResponse {

    @JsonProperty("logradouro")
    private String street;
    @JsonProperty("bairro")
    private String neighborhood;
    @JsonProperty("localidade")
    private String city;
    @JsonProperty("uf")
    private String UF;
    @JsonProperty("CEP")
    private String zipCode;
    @JsonProperty("complemento")
    private String complement;
    private String ibge;
    private String gia;
    @JsonProperty("logradouro")
    private String prefix;
    private String siafi;
}
