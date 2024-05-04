package com.example.fiap.CP2.Dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CadastroMedicoDto(
        @NotBlank @Size(max = 100)
        String nome,

        @NotBlank @Size(max = 20)
        String crm,

        @NotBlank @Size(max = 15)
        String telefone,

        @NotBlank @Size(max = 100)
        String nomeEspecialidade
) {}