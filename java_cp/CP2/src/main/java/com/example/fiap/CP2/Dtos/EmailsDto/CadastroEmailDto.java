package com.example.fiap.CP2.Dtos.EmailsDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CadastroEmailDto(
        @NotBlank @Size(max = 100)
        String nomeEmail,
        @NotBlank @Size(max = 150)
        String tipo) {
}
