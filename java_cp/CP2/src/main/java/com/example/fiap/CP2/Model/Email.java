package com.example.fiap.CP2.Model;


import com.example.fiap.CP2.Dtos.EmailsDto.CadastroEmailDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_EMAIL")
public class Email {


    @ManyToOne()
    @JoinColumn(name = "ID_MEDICO",nullable = false)
    private Medico medico;



    @Id
    @GeneratedValue
    @Column(name = "ID_EMAIL", precision = 8)
    private Long id;

    @Column(name = "NM_EMAIL", length = 100, nullable = false)
    private String nomeEmail;

    @Column(name = "TP_EMAIL", length = 150, nullable = false)
    private String tipo;


    public Email(CadastroEmailDto dto, Medico post) {
        nomeEmail = dto.nomeEmail();
        tipo = dto.tipo();
        this.medico = post;
    }
}
