package br.com.amoler.domain.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ViaCepResponse {
    List<AddressResponse> addressResponseList;
}
