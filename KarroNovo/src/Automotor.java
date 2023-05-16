import java.util.Scanner;

public class Automotor extends Veiculo{
    private String tipoCombustivel;

    Scanner scanner = new Scanner(System.in);

    public Automotor(){
        super();
        System.out.println("Digite o tipo de combustível\nG - Gasolina\nA - Alcool\nF - Flex\nE - Eletrico\nD - Diesel\n");
        this.tipoCombustivel = scanner.nextLine().toUpperCase();

        while(!(this.tipoCombustivel.contains("G")  || this.tipoCombustivel.contains("A") || this.tipoCombustivel.contains("F") || this.tipoCombustivel.contains("E") || this.tipoCombustivel.contains("D"))){
            System.out.println("Digite o tipo de combustível\nG- Gasolina\nA- Alcool\nF- Flex\nE- Eletrico\nD- Diesel");
            this.tipoCombustivel = scanner.nextLine();
        }
    }

    public Automotor(String tipoCombustivel, Integer codigo, String cor, String marca, String modelo, Double valor){
        super(codigo, cor, marca, modelo, valor);
        this.tipoCombustivel = tipoCombustivel;
    }

    @Override
    public void exibir(){
        super.exibir();
        System.out.println("Tipo do combustivel: " + this.tipoCombustivel);
    }
    
    public String getTipoCombustivel(){
        return this.tipoCombustivel;
    }

    @Override
    public void editar(){
        super.editar();
        System.out.println("Digite o tipo de combustível\nG - Gasolina\nA - Alcool\nF - Flex\nE - Eletrico\nD - Diesel\n");
        this.tipoCombustivel = scanner.nextLine().toUpperCase();

        while(!(this.tipoCombustivel.contains("G")  || this.tipoCombustivel.contains("A") || this.tipoCombustivel.contains("F") || this.tipoCombustivel.contains("E") || this.tipoCombustivel.contains("D"))){
            System.out.println("Digite o tipo de combustível\nG- Gasolina\nA- Alcool\nF- Flex\nE- Eletrico\nD- Diesel");
            this.tipoCombustivel = scanner.nextLine();
        }
    }
}
