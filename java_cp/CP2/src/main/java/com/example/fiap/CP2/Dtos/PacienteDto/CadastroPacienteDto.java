package com.example.fiap.CP2.Dtos.PacienteDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record CadastroPacienteDto(
        @NotBlank
        String nome,

        @NotBlank @Size(max = 16)
        String cpf,

        @NotBlank
        String rg,

        LocalDate nascimento
) {
}
