package com.mycompany.todolist;

import java.util.ArrayList;
import java.util.List;

public class TarefaDAOImpl implements TarefaDAO {
    private List<Tarefa> tarefas = new ArrayList<>();
    private int contadorId = 1;

    @Override
    public void adicionarTarefa(Tarefa tarefa) {
        tarefa.setId(contadorId++);
        tarefas.add(tarefa);
    }

    @Override
    public List<Tarefa> listarTarefas() {
        return tarefas;
    }

    @Override
    public Tarefa buscarTarefaPorId(int id) {
        return tarefas.stream()
                      .filter(t -> t.getId() == id)
                      .findFirst()
                      .orElse(null);
    }

    @Override
    public void atualizarTarefa(Tarefa tarefa) {
        Tarefa tarefaExistente = buscarTarefaPorId(tarefa.getId());
        if (tarefaExistente != null) {
            tarefaExistente.setTitulo(tarefa.getTitulo());
            tarefaExistente.setDescricao(tarefa.getDescricao());
            tarefaExistente.setConcluida(tarefa.isConcluida());
        }
    }

    @Override
    public void removerTarefa(int id) {
        tarefas.removeIf(t -> t.getId() == id);
    }
}
