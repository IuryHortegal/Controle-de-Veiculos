public class Veiculo {
    private String placa;
    private String modelo;
    private double quilometragem;

    public Veiculo(String placa, String modelo, double quilometragem) {
        this.placa = placa;
        this.modelo = modelo;
        this.quilometragem = quilometragem;
    }

    public void atualizarQuilometragem(double novaQuilometragem) {
        if (novaQuilometragem >= quilometragem) {
            quilometragem = novaQuilometragem;
            System.out.println("Quilometragem atualizada com sucesso.");
        } else {
            System.out.println("A nova quilometragem não pode ser menor que a atual.");
        }
    }

    public boolean precisaDeManutencao() {
        return quilometragem >= 50000;
    }

    public void exibirDados() {
        System.out.println("Placa: " + placa);
        System.out.println("Modelo: " + modelo);
        System.out.println("Quilometragem: " + quilometragem + " km");

        if (precisaDeManutencao()) {
            System.out.println("Status: manutenção necessária");
        } else {
            System.out.println("Status: manutenção em dia");
        }
    }
    public String getPlaca() {
    return placa;
}
}