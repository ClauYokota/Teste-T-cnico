package com.api.teste.data.Controller;


import com.api.teste.data.Model.Endereco;
import com.api.teste.data.Model.Pessoa;
import com.api.teste.data.Repository.EnderecoRepository;
import com.api.teste.data.Service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("endereco")
public class EnderecoController {
    @Autowired
    EnderecoService enderecoService;

    @GetMapping("/listar")
    public List<Endereco>listarEnderecos(){
        List<Endereco>enderecos = enderecoService.listarEnderecos();
        return enderecos;
    }

    @PostMapping("/cadastrar/{idPessoa}")
    public ResponseEntity<Endereco>cadastrarEndereco(@PathVariable Integer idPessoa, @RequestBody Endereco endereco){
        endereco = enderecoService.cadastrarEndereco(endereco, idPessoa);
        URI novaUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(endereco.getIdEndereco()).toUri();
        return ResponseEntity.created(novaUri).body(endereco);
    }

    @PutMapping("/editar")
    public ResponseEntity<Endereco>editarEndereco(@RequestBody Endereco endereco){
        enderecoService.editarEndereco(endereco);
        return ResponseEntity.ok().body(endereco);
    }

    @GetMapping("/listar/{idPessoa}")
    public List<Endereco>listarEnderecosPessoa(@PathVariable Integer idPessoa){
        List<Endereco>enderecos = enderecoService.listarEnderecosPessoa(idPessoa);
        return enderecos;
    }

    @PutMapping("/editar/principal/{idEndereco}/{idPessoa}")
    public ResponseEntity<Pessoa>editarEnderecoPrincipal(@PathVariable Integer idEndereco, @PathVariable Integer idPessoa){
        Pessoa pessoa = enderecoService.editarEnderecoPrincipal(idEndereco, idPessoa);
        return ResponseEntity.ok().body(pessoa);
    }

}
