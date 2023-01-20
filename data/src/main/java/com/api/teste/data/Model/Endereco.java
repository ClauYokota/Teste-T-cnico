package com.api.teste.data.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEndereco;

    @Column(nullable = false, length = 100)
    private String logradouro;

    @Column(nullable = false, length = 10)
    private Long cep;

    @Column(nullable = false, length = 10)
    private Integer numero;

    @Column(nullable = false, length = 50)
    private String cidade;

    @Column
    private Integer idPessoa;



}
