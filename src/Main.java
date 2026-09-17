import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Veiculo> veiculos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int opcao;

        do {
            System.out.println("1 - Cadastrar veículo");
            System.out.println("2 - Listar veículos");
            System.out.println("3 - Atualizar quilometragem");
            System.out.println("4 - Remover veículo");
            System.out.println("5 - Sair");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException erro) {
                System.out.println(
                    "Opção inválida. Digite um número de 1 a 4."
                );
                opcao = 0;
                continue;
            }

            switch (opcao) {
                case 1: {
                    System.out.print("Digite a placa: ");
                    String placa = scanner.nextLine()
                        .trim()
                        .toUpperCase();

                    boolean placaDuplicada = false;

                    for (Veiculo veiculo : veiculos) {
                        if (veiculo.getPlaca()
                                .equalsIgnoreCase(placa)) {
                            placaDuplicada = true;
                            break;
                        }
                    }

                    if (placaDuplicada) {
                        System.out.println(
                            "Já existe um veículo cadastrado com essa placa."
                        );
                        break;
                    }

                    System.out.print("Digite o modelo: ");
                    String modelo = scanner.nextLine().trim();

                    System.out.print("Digite a quilometragem: ");

                    double quilometragem;

                    try {
                        quilometragem = Double.parseDouble(
                            scanner.nextLine()
                        );
                    } catch (NumberFormatException erro) {
                        System.out.println(
                            "Quilometragem inválida. Digite apenas números."
                        );
                        break;
                    }

                    if (quilometragem < 0) {
                        System.out.println(
                            "A quilometragem não pode ser negativa."
                        );
                        break;
                    }

                    Veiculo novoVeiculo = new Veiculo(
                        placa,
                        modelo,
                        quilometragem
                    );

                    veiculos.add(novoVeiculo);

                    System.out.println(
                        "Veículo cadastrado com sucesso."
                    );
                    break;
                }

                case 2: {
                    if (veiculos.isEmpty()) {
                        System.out.println(
                            "Nenhum veículo cadastrado."
                        );
                    } else {
                        System.out.println(
                            "\nVEÍCULOS CADASTRADOS"
                        );

                        for (Veiculo veiculo : veiculos) {
                            veiculo.exibirDados();
                            System.out.println(
                                "--------------------"
                            );
                        }
                    }
                    break;
                }

                case 3: {
                    System.out.print(
                        "Digite a placa do veículo: "
                    );

                    String placaProcurada =
                        scanner.nextLine().trim();

                    boolean encontrado = false;

                    for (Veiculo veiculo : veiculos) {
                        if (veiculo.getPlaca()
                                .equalsIgnoreCase(
                                    placaProcurada
                                )) {

                            encontrado = true;

                            System.out.print(
                                "Digite a nova quilometragem: "
                            );

                            try {
                                double novaQuilometragem =
                                    Double.parseDouble(
                                        scanner.nextLine()
                                    );

                                veiculo.atualizarQuilometragem(
                                    novaQuilometragem
                                );
                            } catch (
                                NumberFormatException erro
                            ) {
                                System.out.println(
                                    "Quilometragem inválida. " +
                                    "Digite apenas números."
                                );
                            }

                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println(
                            "Veículo não encontrado."
                        );
                    }

                    break;
                }

                case 4: {
                        System.out.print(
                            "Digite a placa do veículo que deseja remover: "
              );

                 String placaProcurada =
                 scanner.nextLine().trim();

                 boolean removido = false;

    for (int i = 0; i < veiculos.size(); i++) {
        Veiculo veiculo = veiculos.get(i);

        if (veiculo.getPlaca()
                .equalsIgnoreCase(placaProcurada)) {

            veiculos.remove(i);
            removido = true;

            System.out.println(
                "Veículo removido com sucesso."
            );
            break;
        }
    }

    if (!removido) {
        System.out.println("Veículo não encontrado.");
    }

    break;
}

                case 5:
                    System.out.println("Programa encerrado.");
                    break;
            }

        } while (opcao != 5);

        scanner.close();
    }
}