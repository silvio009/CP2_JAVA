package com.example.fiap.CP2.Repository;

import com.example.fiap.CP2.Model.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Long> {
}
