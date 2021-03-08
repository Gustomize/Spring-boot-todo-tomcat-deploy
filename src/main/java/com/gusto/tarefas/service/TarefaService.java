package com.gusto.tarefas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gusto.tarefas.exception.TarefaNaoEncontradaException;
import com.gusto.tarefas.model.Tarefa;
import com.gusto.tarefas.repository.TarefaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TarefaService {

    private final TarefaRepository tarefaRepository;
    private static final String TAREFA_NAO_ENCONTRADA = "Tarefa não encontrada";

    public List<Tarefa> listarTarefas() {
        return tarefaRepository.findAll();
    }

    public void criarTarefa(Tarefa tarefa) {
        tarefa.setStatus(false);
        tarefaRepository.save(tarefa);
    }

    public void concluirTarefa(long id) {
        Tarefa tarefa = getTarefa(id);
        tarefa.setStatus(true);
        tarefaRepository.save(tarefa);
    }

    public void refazerTarefa(long id) {
        Tarefa tarefa = getTarefa(id);
        tarefa.setStatus(false);
        tarefaRepository.save(tarefa);
    }

    public void removerTarefa(long id) {
        Tarefa tarefa = getTarefa(id);
        tarefaRepository.deleteById(tarefa.getId());
    }

    private Tarefa getTarefa(long id) {
        return tarefaRepository.findById(id)
                .orElseThrow(() -> new TarefaNaoEncontradaException(TAREFA_NAO_ENCONTRADA));
    }

}
