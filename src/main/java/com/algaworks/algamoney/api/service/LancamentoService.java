package com.algaworks.algamoney.api.service;

import com.algaworks.algamoney.api.exception.PessoaInexistenteOuInativaException;
import com.algaworks.algamoney.api.model.Lancamento;
import com.algaworks.algamoney.api.model.Pessoa;
import com.algaworks.algamoney.api.repository.LancamentoRepository;
import com.algaworks.algamoney.api.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LancamentoService {

    @Autowired
    private LancamentoRepository repository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Lancamento> listarTodos() {
        return repository.findAll();
    }

    public Lancamento buscarPeloCodigo(Long codigo) {
        return repository.findById(codigo).orElse(null);
    }

    public Lancamento salvar(Lancamento lancamento) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(lancamento.getPessoa().getCodigo());
        if(!pessoa.isPresent() || pessoa.get().isInativo()) {
            throw new PessoaInexistenteOuInativaException();
        }
        return repository.save(lancamento);
    }


}
