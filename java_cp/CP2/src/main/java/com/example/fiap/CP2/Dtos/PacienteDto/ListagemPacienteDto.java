package com.example.fiap.CP2.Dtos.PacienteDto;

import com.example.fiap.CP2.Model.Paciente;

import java.time.LocalDate;

public record ListagemPacienteDto(Long id, String nome, String cpf, String rg, LocalDate nascimento) {

    public ListagemPacienteDto(Paciente paciente){
        this(paciente.getId(),paciente.getNome(),paciente.getCpf(),paciente.getRg(),paciente.getNascimento());
    }
}
