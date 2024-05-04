package com.example.fiap.CP2.Controllers;

import com.example.fiap.CP2.Dtos.AtualizarMedicoDto;
import com.example.fiap.CP2.Dtos.CadastroMedicoDto;
import com.example.fiap.CP2.Dtos.DetalhesMedicoDto;
import com.example.fiap.CP2.Dtos.EmailsDto.CadastroEmailDto;
import com.example.fiap.CP2.Dtos.EmailsDto.DetalhesEmailDto;
import com.example.fiap.CP2.Dtos.ListagemMedicoDto;
import com.example.fiap.CP2.Model.Email;
import com.example.fiap.CP2.Model.Medico;
import com.example.fiap.CP2.Repository.EmailRepository;
import com.example.fiap.CP2.Repository.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private EmailRepository emailRepository;



     // *****************EMAILS***********************//

     // POST 1:N (MEDICOS-EMAILS)
    @PostMapping("{id}/emails")
    public  ResponseEntity<DetalhesEmailDto> postt (@PathVariable("id") Long id,@RequestBody @Valid CadastroEmailDto dto,
                                                          UriComponentsBuilder uriBuilder){
        var post = medicoRepository.getReferenceById(id);
        var email = new Email(dto,post);
        emailRepository.save(email);
        var url = uriBuilder.path("/comentarios/{id}").buildAndExpand(post.getId()).toUri();
        return ResponseEntity.created(url).body(new DetalhesEmailDto(email));

    }
    // *****************EMAILS***********************//





    // MÉTODOS PARA O 1:1 (MEDICO-ESPECIALIDADE)
    @GetMapping
    public ResponseEntity<List<ListagemMedicoDto>> listaGet (Pageable pageable){
        var page = medicoRepository.findAll(pageable).stream().map(ListagemMedicoDto :: new ).toList();
        return ResponseEntity.ok(page);
    }



    @GetMapping("{id}")
    public ResponseEntity<DetalhesMedicoDto> get (@PathVariable("id") Long id){
        var get = medicoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesMedicoDto(get));
    }



    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesMedicoDto> create(@RequestBody @Valid CadastroMedicoDto cadastroMedicoDto,
                                                  UriComponentsBuilder uriBuilder) {
        var post = new Medico(cadastroMedicoDto);
        medicoRepository.save(post);
        var url = uriBuilder.path("/medicos/{id}").buildAndExpand(post.getId()).toUri();
        return ResponseEntity.created(url).body(new DetalhesMedicoDto(post));
    }


    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<DetalhesMedicoDto> update (@PathVariable("id") Long id, @RequestBody AtualizarMedicoDto atualizarMedicoDto) {
        var atualizar = medicoRepository.getReferenceById(id);
        atualizar.atualizarinfomacoes(atualizarMedicoDto);
        return ResponseEntity.ok(new DetalhesMedicoDto(atualizar));

    }


    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> deletar (@PathVariable("id") Long id){
        medicoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
