package com.algaworks.algamoney.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "codigo")
@Entity
@Table(name = "pessoa")
@Getter
@Setter
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    private String nome;

    private boolean ativo;

    @Embedded
    private Endereco endereco;

    @Transient
    @JsonIgnore
    public boolean isInativo() {
        return !this.ativo;
    }

}
