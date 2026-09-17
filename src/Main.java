import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Veiculo> veiculos = new ArrayList<>();

        veiculos.add(new Veiculo("ABC1D23", "Fiat Argo", 45000));
        veiculos.add(new Veiculo("DEF4G56", "Toyota Corolla", 62000));
        veiculos.add(new Veiculo("HIJ7K89", "Volkswagen Polo", 28000));

        System.out.println("VEÍCULOS CADASTRADOS");
        System.out.println();

        for (Veiculo veiculo : veiculos) {
            veiculo.exibirDados();
            System.out.println("--------------------");
        }
    }
}