package com.algaworks.algamoney.api.controller;

import com.algaworks.algamoney.api.event.RecursoCriadoEvent;
import com.algaworks.algamoney.api.model.Pessoa;
import com.algaworks.algamoney.api.service.PessoaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
    
    @Autowired
    private PessoaService service;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping
    public Set<Pessoa> listarTodos() {
        return service.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Pessoa> criar(@RequestBody @Valid Pessoa pessoa, HttpServletResponse response) {
        Pessoa pessoaSalva = service.salvar(pessoa);
        publisher.publishEvent(new RecursoCriadoEvent(this, response, pessoaSalva.getCodigo()));
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Pessoa> buscarPeloCodigo(@PathVariable Long codigo) {
        Pessoa pessoa = service.buscarPeloCodigo(codigo);
        return pessoa != null ? ResponseEntity.ok(pessoa) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long codigo) {
        service.remover(codigo);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Pessoa> atualizar(@PathVariable Long codigo,
                                            @RequestBody @Valid Pessoa pessoa) {
        Pessoa pessoaSalva = service.atualizar(codigo, pessoa);
        return ResponseEntity.ok(pessoaSalva);
    }

    @PutMapping("/{codigo}/ativo")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarPropriedadeAtivo(@PathVariable Long codigo, @RequestBody Boolean ativo) {
        service.atualizarPropriedadeAtivo(codigo, ativo);
    }

}
