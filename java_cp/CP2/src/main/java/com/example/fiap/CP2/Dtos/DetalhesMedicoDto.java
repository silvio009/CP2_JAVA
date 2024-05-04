package com.example.fiap.CP2.Dtos;

import com.example.fiap.CP2.Model.Medico;

public record DetalhesMedicoDto(Long id, String nome, String crm, String telefone, String nomeEspecialidade) {

   public DetalhesMedicoDto(Medico medico){
       this(medico.getId(),medico.getNome(),medico.getCrm(),medico.getTelefone(),medico.getEspecialidade().getNomeEspecialidade());
   }

}


