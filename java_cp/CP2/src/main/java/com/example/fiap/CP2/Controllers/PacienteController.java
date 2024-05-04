package com.example.fiap.CP2.Controllers;

import com.example.fiap.CP2.Dtos.AtualizarMedicoDto;
import com.example.fiap.CP2.Dtos.CadastroMedicoDto;
import com.example.fiap.CP2.Dtos.DetalhesMedicoDto;
import com.example.fiap.CP2.Dtos.ListagemMedicoDto;
import com.example.fiap.CP2.Dtos.PacienteDto.AtualizarPacienteDto;
import com.example.fiap.CP2.Dtos.PacienteDto.CadastroPacienteDto;
import com.example.fiap.CP2.Dtos.PacienteDto.DetalhesPacienteDto;
import com.example.fiap.CP2.Dtos.PacienteDto.ListagemPacienteDto;
import com.example.fiap.CP2.Model.Medico;
import com.example.fiap.CP2.Model.Paciente;
import com.example.fiap.CP2.Repository.PacienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;


@RestController
@RequestMapping("pacientes")

public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @GetMapping
    public ResponseEntity<List<ListagemPacienteDto>> listaGet (Pageable pageable){
        var page = pacienteRepository.findAll(pageable).stream().map(ListagemPacienteDto :: new ).toList();
        return ResponseEntity.ok(page);
    }



    @GetMapping("{id}")
    public ResponseEntity<DetalhesPacienteDto> get (@PathVariable("id") Long id){
        var get = pacienteRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesPacienteDto(get));
    }



    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesPacienteDto> create(@RequestBody @Valid CadastroPacienteDto cadastroPacienteDto,
                                                      UriComponentsBuilder uriBuilder) {
        var post = new Paciente(cadastroPacienteDto);
        pacienteRepository.save(post);
        var url = uriBuilder.path("/medicos/{id}").buildAndExpand(post.getId()).toUri();
        return ResponseEntity.created(url).body(new DetalhesPacienteDto(post));
    }




    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<DetalhesPacienteDto> update (@PathVariable("id") Long id, @RequestBody AtualizarPacienteDto atualizarPacienteDto) {
        var atualizar = pacienteRepository.getReferenceById(id);
        atualizar.atualizarinfomacoes(atualizarPacienteDto);
        return ResponseEntity.ok(new DetalhesPacienteDto(atualizar));

    }


    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> deletar (@PathVariable("id") Long id){
        pacienteRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
