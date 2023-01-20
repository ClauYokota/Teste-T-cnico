package com.api.teste.data.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name="pessoa")
@Getter
@Setter
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPessoa;

    @Column(nullable = false, length = 100)
    private String nome;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(columnDefinition = "date", nullable = false)
    private Date dataNascimento;

    @ManyToOne
    @JoinColumn(name = "idEndereco")
    private Endereco endereco;
}
