package com.gusto.tarefas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gusto.tarefas.model.Tarefa;
import com.gusto.tarefas.service.TarefaService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/tarefas")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TarefaController {

    private static final String REDIRECT_TO_HOMEPAGE = "redirect:/tarefas";

    private final TarefaService tarefaService;

    @GetMapping
    public String index(Model model, @ModelAttribute("novaTarefa") Tarefa tarefa) {
        model.addAttribute("tarefas", tarefaService.listarTarefas());
        model.addAttribute("novaTarefa", new Tarefa());

        return "index";
    }

    @PostMapping
    public String criar(@ModelAttribute("tarefa") Tarefa tarefa) {
        tarefaService.criarTarefa(tarefa);

        return REDIRECT_TO_HOMEPAGE;
    }

    @GetMapping("/{id}/concluir")
    public String concluir(@PathVariable long id) {
        tarefaService.concluirTarefa(id);

        return REDIRECT_TO_HOMEPAGE;
    }

    @GetMapping("/{id}/refazer")
    public String refazer(@PathVariable long id) {
        tarefaService.refazerTarefa(id);

        return REDIRECT_TO_HOMEPAGE;
    }

    @GetMapping("/{id}")
    public String remover(@PathVariable long id) {
        tarefaService.removerTarefa(id);

        return REDIRECT_TO_HOMEPAGE;
    }

}
