package com.example.fiap.CP2.Controllers;


import com.example.fiap.CP2.Dtos.DetalhesMedicoDto;
import com.example.fiap.CP2.Dtos.EmailsDto.CadastroEmailDto;
import com.example.fiap.CP2.Dtos.EmailsDto.DetalhesEmailDto;
import com.example.fiap.CP2.Dtos.EmailsDto.ListagemEmailDto;
import com.example.fiap.CP2.Dtos.ListagemMedicoDto;
import com.example.fiap.CP2.Model.Email;
import com.example.fiap.CP2.Repository.EmailRepository;
import com.example.fiap.CP2.Repository.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("emails")
public class EmailController {
    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private EmailRepository emailRepository;




}
