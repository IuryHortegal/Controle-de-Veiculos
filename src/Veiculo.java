public class Veiculo {
    private String placa;
    private String modelo;
    private double quilometragem;

    public Veiculo(String placa, String modelo, double quilometragem) {
        this.placa = placa;
        this.modelo = modelo;
        this.quilometragem = quilometragem;
    }

    public void exibirDados() {
        System.out.println("Placa: " + placa);
        System.out.println("Modelo: " + modelo);
        System.out.println("Quilometragem: " + quilometragem + " km");
    }
}