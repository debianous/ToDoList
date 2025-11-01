import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Tarefa> listaDeTarefas = new ArrayList<>();
        ArrayList<Tarefa> listaConcluidas = new ArrayList<>();
        boolean executando = true;
        System.out.println("ToDo List da Deborah [PT-BR]");
        while (executando) {
            System.out.println("\t\t[ MENU ]\t\t");
            System.out.println("1- Cadastrar tarefa\n2- Listar tarefas pendentes\n3- Buscar tarefa por título\n4- Marcar tarefa como concluída\n5- Remover uma tarefa\n0- Sair");
            System.out.println("\nDigite uma das opções do Menu: ");

            Scanner sc = new Scanner(System.in);
            int opcao = sc.nextInt();
            sc.nextLine(); // para limpar o buffer
            executando = switch (opcao) {
                case 1 -> {
                    System.out.println("Digite o título: ");
                    String tituloTarefa = sc.nextLine();
                    System.out.println("Digite a descrição: ");
                    String descricao = sc.nextLine();
                    System.out.println("Digite a data de entrega (AAAA-MM-DD): ");
                    LocalDate dataEntrega = LocalDate.parse(sc.nextLine());
                    boolean status = false;
                    Tarefa novaTarefa = new Tarefa (tituloTarefa, descricao, dataEntrega, status);
                    listaDeTarefas.add(novaTarefa);
                    System.out.println(novaTarefa);
                    yield true;
                }
                case 2 -> {
                    int tamanho = listaDeTarefas.size();
                    for (int i = 0; i < tamanho; i++) {
                        System.out.println(i + " - " + listaDeTarefas.get(i));
                    }
                    System.out.println("Tarefas pendentes listadas com sucesso!");
                    yield true;
                }
                case 3 -> {
                    System.out.println("Tarefa buscada com sucesso!");
                    yield true;
                }
                case 4 -> {
                    int tamanho = listaDeTarefas.size();
                    for (int i = 0; i < tamanho; i++) {
                        System.out.println(i + " - " + listaDeTarefas.get(i));
                    }
                    System.out.println("Digite o índice da tarefa desejada a partir da lista acima: ");
                    int id = sc.nextInt();
                    if (id >= 0 && id < tamanho) {
                        Tarefa selecionada = listaDeTarefas.get(id);
                        selecionada.concluir();
                        listaConcluidas.add(selecionada);
                        listaDeTarefas.remove(id);
                        System.out.println("Tarefa marcada como concluída com sucesso!");
                    } else if (!listaDeTarefas.get(id).isStatus()) {
                        System.out.println("Essa tarefa já está concluída.");
                    } else {
                        System.out.println("Índice inválido.");
                    }
                    yield true;
                }
                case 5 -> {
                    int tamanho = listaDeTarefas.size();
                    for (int i = 0; i < tamanho; i++) {
                        System.out.println(i + " - " + listaDeTarefas.get(i));
                    }
                    System.out.println("Digite o índice da tarefa desejada a partir da lista acima: ");
                    int id = sc.nextInt();
                    if (id >= 0 && id < tamanho) {
                        Tarefa selecionada = listaDeTarefas.get(id);
                        listaDeTarefas.remove(id);
                        System.out.println("Tarefa removida com sucesso!");
                    } else {
                    System.out.println("Índice inválido.");
                    }
                    yield true;
                }
                case 0 -> false;
                default -> {
                    System.out.println("Opção inválida.");
                    yield true;
                }
            };
        }
    }
}