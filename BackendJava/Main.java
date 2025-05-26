import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author 
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Hospedaria hospedaria = new Hospedaria();
        List<Reserva> reservas = new ArrayList<>();
        List<Avaliacao> avaliacoes = new ArrayList<>();

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Listar suítes disponíveis");
            System.out.println("2. Fazer reserva");
            System.out.println("3. Realizar pagamento");
            System.out.println("4. Cancelar reserva");
            System.out.println("5. Fazer avaliação");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // consumir a quebra de linha

            switch (opcao) {
                case 1:
                    hospedaria.listarSuitesDisponiveis();
                    break;

                case 2:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();
                    Cliente cliente = new Cliente(nome, email, telefone, cpf);

                    System.out.println("Escolha a suíte:");
                    List<Suite> suites = hospedaria.getSuites();
                    for (int i = 0; i < suites.size(); i++) {
                        System.out.printf("%d - %s\n", i + 1, suites.get(i).getDescricaoCompleta());
                    }
                    int escolhaSuite = scanner.nextInt() - 1;
                    Suite suiteEscolhida = suites.get(escolhaSuite);

                    System.out.print("Data de Check-in (AAAA-MM-DD): ");
                    LocalDate checkIn = LocalDate.parse(scanner.next());
                    System.out.print("Data de Check-out (AAAA-MM-DD): ");
                    LocalDate checkOut = LocalDate.parse(scanner.next());

                    Reserva reserva = new Reserva(checkIn, checkOut, suiteEscolhida, cliente);
                    reservas.add(reserva);
                    suiteEscolhida.adicionarReserva(reserva);
                    System.out.println("Reserva realizada com sucesso!");
                    break;

                case 3:
                    if (reservas.isEmpty()) {
                        System.out.println("Nenhuma reserva encontrada.");
                        break;
                    }
                    System.out.println("Escolha a reserva para pagamento:");
                    for (int i = 0; i < reservas.size(); i++) {
                        System.out.printf("%d - Cliente: %s, Suíte: %s\n", i + 1,
                                reservas.get(i).getCliente().getNome(),
                                reservas.get(i).getSuite().getNome());
                    }
                    int escolhaReserva = scanner.nextInt() - 1;
                    Reserva reservaPagamento = reservas.get(escolhaReserva);

                    System.out.print("Forma de pagamento: ");
                    scanner.nextLine();
                    String formaPagamento = scanner.nextLine();

                    reservaPagamento.calcularValorTotal(formaPagamento);
                    reservaPagamento.getPagamento().realizarPagamento();
                    break;

                case 4:
                    if (reservas.isEmpty()) {
                        System.out.println("Nenhuma reserva para cancelar.");
                        break;
                    }
                    System.out.println("Escolha a reserva para cancelar:");
                    for (int i = 0; i < reservas.size(); i++) {
                        System.out.printf("%d - Cliente: %s, Suíte: %s\n", i + 1,
                                reservas.get(i).getCliente().getNome(),
                                reservas.get(i).getSuite().getNome());
                    }
                    int cancelar = scanner.nextInt() - 1;
                    reservas.get(cancelar).cancelarReserva();
                    break;

                case 5:
                    if (reservas.isEmpty()) {
                        System.out.println("Nenhuma reserva para avaliar.");
                        break;
                    }
                    System.out.println("Escolha a reserva que deseja avaliar:");
                    for (int i = 0; i < reservas.size(); i++) {
                        System.out.printf("%d - Cliente: %s, Suíte: %s\n", i + 1,
                                reservas.get(i).getCliente().getNome(),
                                reservas.get(i).getSuite().getNome());
                    }
                    int avaliacaoIndex = scanner.nextInt() - 1;
                    Reserva reservaAvaliacao = reservas.get(avaliacaoIndex);

                    System.out.print("Nota (1 a 5): ");
                    int nota = scanner.nextInt();
                    scanner.nextLine(); // consumir quebra de linha
                    System.out.print("Comentário: ");
                    String comentario = scanner.nextLine();

                    Avaliacao avaliacao = new Avaliacao(
                            reservaAvaliacao.getCliente(),
                            reservaAvaliacao.getSuite(),
                            nota,
                            comentario
                    );
                    avaliacoes.add(avaliacao);
                    System.out.println("Avaliação registrada com sucesso!");
                    avaliacao.exibirAvaliacao();
                    break;

                case 6:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
