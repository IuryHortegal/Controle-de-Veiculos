import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Path ARQUIVO_VEICULOS =
        Path.of("veiculos.txt");

    public static void main(String[] args) {
        ArrayList<Veiculo> veiculos =
           carregarVeiculos();
        Scanner scanner = new Scanner(System.in);

        int opcao;

        do {
            System.out.println("\nCONTROLE DE VEÍCULOS");
            System.out.println("1 - Cadastrar veículo");
            System.out.println("2 - Listar veículos");
            System.out.println("3 - Atualizar quilometragem");
            System.out.println("4 - Remover veículo");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(
                    scanner.nextLine()
                );
            } catch (NumberFormatException erro) {
                System.out.println(
                    "Opção inválida. Digite um número de 1 a 5."
                );

                opcao = 0;
                continue;
            }

            switch (opcao) {
                case 1: {
                    cadastrarVeiculo(veiculos, scanner);
                      salvarVeiculos(veiculos);
                    break;
                }

                case 2: {
                    listarVeiculos(veiculos);
                    break;
                }

                case 3: {
                    atualizarQuilometragemDoVeiculo(
                  veiculos,
                    scanner
                );

                salvarVeiculos(veiculos);
                break;
            }

                case 4: {
                    removerVeiculo(veiculos, scanner);
                    salvarVeiculos(veiculos);
                break;
            }

                case 5: {
                    System.out.println(
                        "Programa encerrado."
                    );
                    break;
                }

                default: {
                    System.out.println(
                        "Opção inválida. " +
                        "Digite um número de 1 a 5."
                    );
                }
            }

        } while (opcao != 5);

        scanner.close();
    }

    private static void cadastrarVeiculo(
            ArrayList<Veiculo> veiculos,
            Scanner scanner) {

        System.out.print("Digite a placa: ");

        String placa = scanner.nextLine()
            .trim()
            .toUpperCase();

        Veiculo veiculoExistente =
            buscarVeiculoPorPlaca(
                veiculos,
                placa
            );

        if (veiculoExistente != null) {
            System.out.println(
                "Já existe um veículo cadastrado " +
                "com essa placa."
            );
            return;
        }

        System.out.print("Digite o modelo: ");

        String modelo =
            scanner.nextLine().trim();

        System.out.print(
            "Digite a quilometragem: "
        );

        double quilometragem;

        try {
            quilometragem =
                Double.parseDouble(
                    scanner.nextLine()
                );
        } catch (NumberFormatException erro) {
            System.out.println(
                "Quilometragem inválida. " +
                "Digite apenas números."
            );
            return;
        }

        if (quilometragem < 0) {
            System.out.println(
                "A quilometragem não pode ser negativa."
            );
            return;
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
    }

    private static void listarVeiculos(
            ArrayList<Veiculo> veiculos) {

        if (veiculos.isEmpty()) {
            System.out.println(
                "Nenhum veículo cadastrado."
            );
            return;
        }

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

    private static void atualizarQuilometragemDoVeiculo(
            ArrayList<Veiculo> veiculos,
            Scanner scanner) {

        System.out.print(
            "Digite a placa do veículo: "
        );

        String placaProcurada =
            scanner.nextLine().trim();

        Veiculo veiculoEncontrado =
            buscarVeiculoPorPlaca(
                veiculos,
                placaProcurada
            );

        if (veiculoEncontrado == null) {
            System.out.println(
                "Veículo não encontrado."
            );
            return;
        }

        System.out.print(
            "Digite a nova quilometragem: "
        );

        try {
            double novaQuilometragem =
                Double.parseDouble(
                    scanner.nextLine()
                );

            veiculoEncontrado
                .atualizarQuilometragem(
                    novaQuilometragem
                );

        } catch (NumberFormatException erro) {
            System.out.println(
                "Quilometragem inválida. " +
                "Digite apenas números."
            );
        }
    }

    private static void removerVeiculo(
            ArrayList<Veiculo> veiculos,
            Scanner scanner) {

        System.out.print(
            "Digite a placa do veículo " +
            "que deseja remover: "
        );

        String placaProcurada =
            scanner.nextLine().trim();

        Veiculo veiculoEncontrado =
            buscarVeiculoPorPlaca(
                veiculos,
                placaProcurada
            );

        if (veiculoEncontrado == null) {
            System.out.println(
                "Veículo não encontrado."
            );
            return;
        }

        veiculos.remove(veiculoEncontrado);

        System.out.println(
            "Veículo removido com sucesso."
        );
    }

    private static Veiculo buscarVeiculoPorPlaca(
            ArrayList<Veiculo> veiculos,
            String placa) {

        for (Veiculo veiculo : veiculos) {
            if (veiculo.getPlaca()
                    .equalsIgnoreCase(placa)) {
                return veiculo;
            }
        }

        return null;
    }
    private static void salvarVeiculos(
        ArrayList<Veiculo> veiculos) {

    ArrayList<String> linhas =
        new ArrayList<>();

    for (Veiculo veiculo : veiculos) {
        String linha =
            veiculo.getPlaca() + ";" +
            veiculo.getModelo() + ";" +
            veiculo.getQuilometragem();

        linhas.add(linha);
    }

    try {
        Files.write(
            ARQUIVO_VEICULOS,
            linhas
        );
    } catch (IOException erro) {
        System.out.println(
            "Não foi possível salvar os veículos."
        );
    }
}
       private static ArrayList<Veiculo> carregarVeiculos() {
    ArrayList<Veiculo> veiculos =
        new ArrayList<>();

    if (!Files.exists(ARQUIVO_VEICULOS)) {
        return veiculos;
    }

    try {
        ArrayList<String> linhas =
            new ArrayList<>(
                Files.readAllLines(
                    ARQUIVO_VEICULOS
                )
            );

        for (String linha : linhas) {
            String[] dados =
                linha.split(";", 3);

            if (dados.length != 3) {
                continue;
            }

            try {
                String placa = dados[0];
                String modelo = dados[1];

                double quilometragem =
                    Double.parseDouble(
                        dados[2]
                    );

                Veiculo veiculo =
                    new Veiculo(
                        placa,
                        modelo,
                        quilometragem
                    );

                veiculos.add(veiculo);
            } catch (IllegalArgumentException erro) {
                System.out.println(
                    "Um registro inválido foi ignorado."
                );
            }
        }
    } catch (IOException erro) {
        System.out.println(
            "Não foi possível carregar os veículos."
        );
    }

    return veiculos;
}
}