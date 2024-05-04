package com.example.fiap.CP2.Dtos.EmailsDto;

import com.example.fiap.CP2.Dtos.DetalhesMedicoDto;
import com.example.fiap.CP2.Model.Email;

public record DetalhesEmailDto(Long id, String nomeEmail, String tipo, DetalhesMedicoDto detalhesMedicoDto) {

    public DetalhesEmailDto(Email email){
        this(email.getId(),email.getNomeEmail(),email.getTipo(),new DetalhesMedicoDto(email.getMedico()));
    }

}
