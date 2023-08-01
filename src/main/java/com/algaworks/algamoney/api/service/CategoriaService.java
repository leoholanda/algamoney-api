package com.algaworks.algamoney.api.service;

import com.algaworks.algamoney.api.model.Categoria;
import com.algaworks.algamoney.api.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.List;
import java.util.LinkedHashSet;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public Set<Categoria> listarTodos() {
        List<Categoria> repositoryAll = repository.findAll(Sort.by(
                Sort.Direction.ASC,
                "nome"));

        return new LinkedHashSet<>(repositoryAll);
    }

    public Categoria salvar(Categoria categoria) {
        return repository.save(categoria);
    }

    public Categoria buscarPeloCodigo(Long codigo) {
        return repository.findById(codigo).orElse(null);
    }
}
