package com.algaworks.algamoney.api.service;

import com.algaworks.algamoney.api.exception.PessoaInexistenteOuInativaException;
import com.algaworks.algamoney.api.model.Lancamento;
import com.algaworks.algamoney.api.model.Pessoa;
import com.algaworks.algamoney.api.repository.LancamentoRepository;
import com.algaworks.algamoney.api.repository.PessoaRepository;
import com.algaworks.algamoney.api.repository.filter.LancamentoFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LancamentoService {

    @Autowired
    private LancamentoRepository repository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public Page<Lancamento> pesquisar(LancamentoFilter filter, Pageable pageable) {
        return repository.filtrar(filter, pageable);
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

    public void remover(Long codigo) {
        repository.deleteById(codigo);
    }

}
