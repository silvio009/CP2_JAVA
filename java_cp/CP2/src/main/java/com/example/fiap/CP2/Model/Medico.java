package com.example.fiap.CP2.Model;

import com.example.fiap.CP2.Dtos.AtualizarMedicoDto;
import com.example.fiap.CP2.Dtos.CadastroMedicoDto;
import com.example.fiap.CP2.Dtos.DetalhesMedicoDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table( name = "TB_MEDICO")
public class Medico {


    @OneToMany(mappedBy = "medico", cascade = CascadeType.ALL)
    private List<Email> emails;




    @ManyToMany()
    @JoinTable(name = "TB_CONSULTA",
    joinColumns = @JoinColumn(name = "ID_MEDICO"),
    inverseJoinColumns = @JoinColumn(name = "ID_PACIENTE"))
    private List<Paciente> pacientes;

    @OneToOne(mappedBy = "medico",
            cascade = CascadeType.ALL)
    private Especialidade especialidade;





    @Id
    @GeneratedValue
    @Column(name = "ID_MEDICO" ,precision = 8)
    private Long id;

    @Column(name = "NM_MEDICO" , length = 100, nullable = false)
    private String nome;

    @Column(name = "NR_CRM" , precision = 15, nullable = false)
    private String crm;

    @Column(name = "NR_TELEFONE" , length = 14, nullable = false)
    private String telefone;

    public Medico(CadastroMedicoDto cadastroMedicoDto) {
        nome = cadastroMedicoDto.nome();
        crm = cadastroMedicoDto.crm();
        telefone = cadastroMedicoDto.telefone();
        especialidade = new Especialidade();
        especialidade.setMedico(this);
        especialidade.setNomeEspecialidade(cadastroMedicoDto.nomeEspecialidade());
    }

    public void atualizarinfomacoes(AtualizarMedicoDto atualizarMedicoDto) {

        if (atualizarMedicoDto.crm()!=null)
            crm = atualizarMedicoDto.crm();
        if (atualizarMedicoDto.telefone() !=null)
            telefone = atualizarMedicoDto.telefone();
        if (atualizarMedicoDto.nomeEspecialidade()!=null)
            especialidade.setNomeEspecialidade(atualizarMedicoDto.nomeEspecialidade());
    }

}
