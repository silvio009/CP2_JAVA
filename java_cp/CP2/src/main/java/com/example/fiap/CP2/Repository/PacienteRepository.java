package com.example.fiap.CP2.Repository;

import com.example.fiap.CP2.Model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente,Long> {
}
