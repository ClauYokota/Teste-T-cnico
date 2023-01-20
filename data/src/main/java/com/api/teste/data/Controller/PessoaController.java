package com.api.teste.data.Controller;

import com.api.teste.data.Model.Pessoa;
import com.api.teste.data.Service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
public class PessoaController {
    @Autowired
    PessoaService pessoaService;

    @GetMapping("/listar")
    public List<Pessoa> listarPessoas(){
        return pessoaService.listarPessoas();
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Pessoa>cadastrarPessoa(@RequestBody Pessoa pessoa){
        pessoa = pessoaService.cadastrarPessoa(pessoa);
        URI novaUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pessoa.getIdPessoa()).toUri();
        return ResponseEntity.created(novaUri).body(pessoa);
    }

    @GetMapping("/listar/{idPessoa}")
    public ResponseEntity<Pessoa>consultarUmaPessoa(@PathVariable Integer idPessoa){
        Pessoa pessoa = pessoaService.consultarUmaPessoa(idPessoa);
        return ResponseEntity.ok().body(pessoa);
    }

    @PutMapping("/editar")
    public ResponseEntity<Pessoa>editarPessoa(@RequestBody Pessoa pessoa){
        pessoaService.editarPessoa(pessoa);
        return ResponseEntity.ok().body(pessoa);
    }
}
