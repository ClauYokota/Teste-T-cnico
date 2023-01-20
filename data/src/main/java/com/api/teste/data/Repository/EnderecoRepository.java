package com.api.teste.data.Repository;

import com.api.teste.data.Model.Endereco;
import com.api.teste.data.Model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
    @Query(value = "SELECT * FROM ENDERECO WHERE ID_PESSOA =:idPessoa", nativeQuery = true)
    List<Endereco>findByPessoa(Integer idPessoa);

}
