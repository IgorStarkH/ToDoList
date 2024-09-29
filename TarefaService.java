package com.mycompany.todolist;

import java.util.List;

public class TarefaService {
    private TarefaDAO tarefaDAO;

    public TarefaService(TarefaDAO tarefaDAO) {
        this.tarefaDAO = tarefaDAO;
    }

    public void cadastrarTarefa(String titulo, String descricao) {
        Tarefa novaTarefa = new Tarefa(0, titulo, descricao);
        tarefaDAO.adicionarTarefa(novaTarefa);
        System.out.println("Tarefa cadastrada com sucesso!");
    }

    public void listarTarefas() {
        List<Tarefa> tarefas = tarefaDAO.listarTarefas();
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
        } else {
            tarefas.forEach(System.out::println);
        }
    }

    public void editarTarefa(int id, String novoTitulo, String novaDescricao, boolean concluida) {
        Tarefa tarefa = tarefaDAO.buscarTarefaPorId(id);
       
        if (tarefa != null) {
            tarefa.setTitulo(novoTitulo);
            tarefa.setDescricao(novaDescricao);
            tarefa.setConcluida(concluida);
            tarefaDAO.atualizarTarefa(tarefa);
            System.out.println("Tarefa atualizada com sucesso!");
            
        } else {
            System.out.println("Tarefa nao encontrada.");
        }
    
    }
    public void excluirTarefa(int id) {
        Tarefa tarefa = tarefaDAO.buscarTarefaPorId(id);
        if (tarefa != null) {
            tarefaDAO.removerTarefa(id);
            System.out.println("Tarefa removida com sucesso!");
        } else {
            System.out.println("Tarefa nao encontrada.");
        }
    }
}
