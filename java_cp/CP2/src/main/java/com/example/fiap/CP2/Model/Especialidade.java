package com.example.fiap.CP2.Model;

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
@Table( name = "TB_ESPECIALIDADE")
public class Especialidade {

    @OneToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_MEDICO")
    private Medico medico;



    @Id
    @GeneratedValue
    @Column(name = "ID_ESPECIALIDADE" ,precision = 8)
    private Long id;

    @Column(name = "NM_ESPECIALIDADE" ,length = 100, nullable = false)
    private String nomeEspecialidade;
}
