public class Main {
    public static void main(String[] args) {
        Veiculo veiculo = new Veiculo(
            "ABC1D23",
            "Fiat Argo",
            45000
        );

        System.out.println("Dados iniciais:");
        veiculo.exibirDados();

        System.out.println("\nApós atualização:");
        veiculo.atualizarQuilometragem(52000);
        veiculo.exibirDados();
    }
}