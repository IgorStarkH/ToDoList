package com.mycompany.todolist;

import java.util.Scanner;

public class ToDoList {

    public static void main(String[] args) {
        TarefaDAO tarefaDAO = new TarefaDAOImpl(); 
        TarefaService tarefaService = new TarefaService(tarefaDAO);
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            clearConsole(); 


System.out.println("\n=============================");
System.out.println("        To-Do List         ");
System.out.println("=============================");
System.out.println("1. Cadastrar Tarefa");
System.out.println("2. Listar Tarefas");
System.out.println("3. Editar Tarefa");
System.out.println("4. Excluir Tarefa");
System.out.println("5. Sair");
System.out.println("=============================");
System.out.print("Escolha uma opcao: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.print("Titulo da Tarefa: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Descricao da Tarefa: ");
                    String descricao = scanner.nextLine();
                    tarefaService.cadastrarTarefa(titulo, descricao);
                    pause(); 
                    break;
                case 2:
                    tarefaService.listarTarefas();
                    pause(); 
                    break;
                case 3:
                    System.out.print("ID da Tarefa: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Novo Titulo: ");
                    String novoTitulo = scanner.nextLine();
                    System.out.print("Nova Descricao: ");
                    String novaDescricao = scanner.nextLine();
                    System.out.print("Tarefa Concluida? (true/false): ");
                    boolean concluida = scanner.nextBoolean();
                    tarefaService.editarTarefa(id, novoTitulo, novaDescricao, concluida);
                    pause(); 
                    break;
                case 4:
                    System.out.print("ID da Tarefa: ");
                    int idExcluir = scanner.nextInt();
                    tarefaService.excluirTarefa(idExcluir);
                    pause(); 
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opcao invalida.");
                    pause();
            }
        } while (opcao != 5);

        scanner.close();
    }


    private static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            System.out.println("Erro ao limpar o console.");
        }
    }

    private static void pause() {
        System.out.println("Pressione Enter para continuar...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
}
