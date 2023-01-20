package com.api.teste.data.Service;

import com.api.teste.data.Model.Pessoa;
import com.api.teste.data.Repository.PessoaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {
    @Autowired
    PessoaRepository pessoaRepository;

    public List<Pessoa> listarPessoas(){
        return pessoaRepository.findAll();
    }

    public Pessoa cadastrarPessoa(Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }

    public Pessoa consultarUmaPessoa(Integer idPessoa){
        Optional<Pessoa>pessoa = pessoaRepository.findById(idPessoa);
        return pessoa.orElseThrow(
                ()-> new EntityNotFoundException("Pessoa não cadastrado com o id " +idPessoa)
        );
    }

    public Pessoa editarPessoa(Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }



}
