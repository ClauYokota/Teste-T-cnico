package com.api.teste.data.Service;

import com.api.teste.data.Model.Endereco;
import com.api.teste.data.Model.Pessoa;
import com.api.teste.data.Repository.EnderecoRepository;
import com.api.teste.data.Repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {
    @Autowired
    EnderecoRepository enderecoRepository;
    @Autowired
    PessoaRepository pessoaRepository;

    @Autowired
    PessoaService pessoaService;

   public List<Endereco>listarEnderecos(){
       return enderecoRepository.findAll();
   }

   public Endereco cadastrarEndereco(Endereco endereco, Integer idPessoa) {
       Optional<Pessoa>pessoa = pessoaRepository.findById(idPessoa);
           endereco.setIdPessoa(idPessoa);
           enderecoRepository.save(endereco);

           pessoa.get().setEndereco(endereco);
           pessoaRepository.save(pessoa.get());
           return endereco;
   }

   public Endereco editarEndereco (Endereco endereco){
       return enderecoRepository.save(endereco);
   }

   public List <Endereco> listarEnderecosPessoa(Integer idPessoa){

       return enderecoRepository.findByPessoa(idPessoa);
   }

   public Pessoa editarEnderecoPrincipal(Integer idEndereco, Integer idPessoa){
       Pessoa pessoa = pessoaService.consultarUmaPessoa(idPessoa);
       Optional<Endereco>endereco = enderecoRepository.findById(idEndereco);
       pessoa.setEndereco(endereco.get());
       return pessoaRepository.save(pessoa);
   }




}
