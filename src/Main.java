import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Veiculo> veiculos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int opcao;

        do {
            System.out.println("\nCONTROLE DE VEÍCULOS");
            System.out.println("1 - Cadastrar veículo");
            System.out.println("2 - Listar veículos");
            System.out.println("3 - Atualizar quilometragem");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    System.out.print("Digite a placa: ");
                    String placa = scanner.nextLine();

                    System.out.print("Digite o modelo: ");
                    String modelo = scanner.nextLine();

                    System.out.print("Digite a quilometragem: ");
                    double quilometragem =
                        Double.parseDouble(scanner.nextLine());

                    Veiculo novoVeiculo =
                        new Veiculo(placa, modelo, quilometragem);

                    veiculos.add(novoVeiculo);

                    System.out.println("Veículo cadastrado com sucesso.");
                    break;

                case 2:
                    if (veiculos.isEmpty()) {
                        System.out.println("Nenhum veículo cadastrado.");
                    } else {
                        System.out.println("\nVEÍCULOS CADASTRADOS");

                        for (Veiculo veiculo : veiculos) {
                            veiculo.exibirDados();
                            System.out.println("--------------------");
                        }
                    }
                    break;

                case 3:
                    System.out.print("Digite a placa do veículo: ");
                    String placaProcurada = scanner.nextLine();

                    boolean encontrado = false;

                    for (Veiculo veiculo : veiculos) {
                        if (veiculo.getPlaca()
                                .equalsIgnoreCase(placaProcurada)) {

                            System.out.print(
                                "Digite a nova quilometragem: "
                            );

                            double novaQuilometragem =
                                Double.parseDouble(scanner.nextLine());

                            veiculo.atualizarQuilometragem(
                                novaQuilometragem
                            );

                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Veículo não encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("Programa encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 4);

        scanner.close();
    }
}