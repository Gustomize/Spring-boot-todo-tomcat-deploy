package com.gusto.tarefas.exception;

public class TarefaNaoEncontradaException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TarefaNaoEncontradaException(String message) {
		super(message);
	}

}
