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

	public List<Tarefa> listarTarefas() {
		return tarefaRepository.findAll();
	}

	public Tarefa criarTarefa(Tarefa tarefa) {
		tarefa.setStatus(false);

		return tarefaRepository.save(tarefa);
	}

	public Tarefa concluirTarefa(long id) {
		Tarefa tarefa = tarefaRepository.findById(id) //
				.orElseThrow(() -> new TarefaNaoEncontradaException("Tarefa não encontrada"));

		tarefa.setStatus(true);

		return tarefaRepository.save(tarefa);
	}

	public Tarefa refazerTarefa(long id) {
		Tarefa tarefa = tarefaRepository.findById(id) //
				.orElseThrow(() -> new TarefaNaoEncontradaException("Tarefa não encontrada"));

		tarefa.setStatus(false);

		return tarefaRepository.save(tarefa);
	}

	public void removerTarefa(long id) {
		Tarefa tarefa = tarefaRepository.findById(id) //
				.orElseThrow(() -> new TarefaNaoEncontradaException("Tarefa não encontrada"));

		tarefaRepository.deleteById(tarefa.getId());
	}

}
