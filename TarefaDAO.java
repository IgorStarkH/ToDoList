package com.mycompany.todolist;

import com.mycompany.todolist.Tarefa;
import java.util.List;

public interface TarefaDAO {
    void adicionarTarefa(Tarefa tarefa);
    List<Tarefa> listarTarefas();
    Tarefa buscarTarefaPorId(int id);
    void atualizarTarefa(Tarefa tarefa);
    void removerTarefa(int id);
}
