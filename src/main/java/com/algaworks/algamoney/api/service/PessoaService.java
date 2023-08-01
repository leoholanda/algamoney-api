package com.algaworks.algamoney.api.service;

import com.algaworks.algamoney.api.model.Categoria;
import com.algaworks.algamoney.api.model.Pessoa;
import com.algaworks.algamoney.api.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    public Set<Pessoa> listarTodos() {
        List<Pessoa> repositoryAll = repository.findAll(Sort.by(
                Sort.Direction.ASC,
                "nome"))
                .stream()
                .filter(p -> p.getAtivo())
                .sorted((p1, p2) -> p1.getNome().compareTo(p2.getNome()))
                .collect(Collectors.toList());

        return new LinkedHashSet<>(repositoryAll);
    }

    public Pessoa salvar(Pessoa pessoa) {
        return repository.save(pessoa);
    }

    public Pessoa buscarPeloCodigo(Long codigo) {
        return repository.findById(codigo).orElse(null);
    }


}
