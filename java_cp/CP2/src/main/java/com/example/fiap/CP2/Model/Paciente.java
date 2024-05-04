package com.example.fiap.CP2.Model;

import com.example.fiap.CP2.Dtos.PacienteDto.AtualizarPacienteDto;
import com.example.fiap.CP2.Dtos.PacienteDto.CadastroPacienteDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.naming.Name;
import java.time.LocalDate;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table( name = "TB_PACIENTE")
public class Paciente {

      @ManyToMany(mappedBy = "pacientes")
      private List<Medico> medicos;



    @Id
    @GeneratedValue
    @Column(name = "ID_PACIENTE" ,precision = 8)
    private Long id;


    @Column(name = "NM_PACIENTE" ,length =  100 , nullable = false)
    private String nome;


    @Column(name = "NR_CPF",length =  12 , nullable = false)
    private String cpf;


    @Column(name = "NR_RG",length =  15 , nullable = false)
    private String rg;


    @Column(name ="DT_NASCIMENTO",nullable = false)
    @CreatedDate
    private LocalDate nascimento;

    public Paciente(CadastroPacienteDto cadastroPacienteDto) {
        nome = cadastroPacienteDto.nome();
        cpf = cadastroPacienteDto.cpf();
        rg = cadastroPacienteDto.rg();
        nascimento =cadastroPacienteDto.nascimento();
    }

    public void atualizarinfomacoes(AtualizarPacienteDto atualizarPacienteDto) {
        if (atualizarPacienteDto.nome()!= null)
            nome = atualizarPacienteDto.nome();
        if (atualizarPacienteDto.cpf()!= null)
            cpf = atualizarPacienteDto.cpf();
        if (atualizarPacienteDto.rg() != null)
            rg = atualizarPacienteDto.rg();
    }
}