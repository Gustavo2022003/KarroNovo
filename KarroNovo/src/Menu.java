import java.security.Principal;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    public Menu(){
        this.veiculos.add(new Carro(4, "G", 1, "Prata", "Chevrolet", "Prisma", 40000.00));
        this.veiculos.add(new Moto(false, 150, "G", 3, "rosa", "kawasaki", "ninja", 40000.00));
        this.veiculos.add(new Caminhao(1000.00, 1, "G", 1, "Prata", "Chevrolet", "Prisma", 40000.00));
        System.out.println("Veiculos do Banco de Dados carregados! \n");
    }

    ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();

    Scanner scanner = new Scanner(System.in);


    public void menu(){
        System.out.println("");
        System.out.println("O que deseja fazer?\n1 - Cadastrar novo veículo\n2 - Editar veículo\n3 - Ver informações de um veículo específico\n4 - Excluir um veículo\n5 - Ver todos os veículos\n6 - Sair");

        Integer user_input =  scanner.nextInt();

        switch (user_input){
            case 1:
                menu_cadastro();
                break;
            case 2:
                editarVeiculo();
                break;
            case 3:
                consultarVeiculo();
                break;
            case 4:
                excluirVeiculo();
                break;
            case 5:
                for (Veiculo veiculo : veiculos){
                    veiculo.exibir();
                }
                break;
            case 6:
                break;
            default:
                System.out.println("Erro!");
                break;
        }
        menu();

    }

    public void menu_cadastro(){

        System.out.println("Qual tipo de veículo será cadastrado?\n1 - Carro\n2 - Moto\n3 - Caminhão\n4 - Bicicleta\n5 - Voltar ao menu principal");

        Integer user_input = scanner.nextInt();

        switch (user_input){
            case 1:
                this.veiculos.add(new Carro());
                break;
            case 2:
                this.veiculos.add(new Moto());
                break;
            case 3:
                this.veiculos.add(new Caminhao());
                break;
            case 4:
                this.veiculos.add(new Bicicleta());
                break;
            case 5:
                menu();
                break;
            default:
                System.out.println("Erro!");
        }
    }

    public void consultarVeiculo(){
        Integer index = this.getVeiculoIndex();

        if (index.equals(-1)){
            System.out.println("Veículo não encontrado!");
        } else{
            this.veiculos.get(index).exibir();
        }
    }

    public Integer getVeiculoIndex() {
        System.out.println("Digite o código do veículo:");
        Integer codigo = scanner.nextInt();
        Integer index = 0;

        for (Veiculo veiculo : this.veiculos) {
            // Verifica se o código do véiculo é igual ao código fornecido
            if (veiculo.getCodigo().equals(codigo)) {
                return index;
            } else {
                return index++;
            }
        }

        return -1;
    }

    public void editarVeiculo(){
        Integer index = this.getVeiculoIndex();

        if (index.equals(-1)){
            System.out.println("Veículo não encontrado!");
        }else{
            System.out.println("Você tem certeza que deseja editar este veículo? [S/N]");
            this.veiculos.get(index).exibir();
            String input = scanner.next().toUpperCase();
            if(input.equals("S")){
                this.veiculos.get(index).editar();
            } else {
                menu();
            }
        }
    }

    public void excluirVeiculo(){
        Integer index = this.getVeiculoIndex();

        if (index.equals(-1)){
            System.out.println("Veículo não localizado");
        } else{
            System.out.println("Informações do veículo:");
            this.veiculos.get(index).exibir();
            System.out.println("\nDeseja mesmo excluir este veículo? [S/N]");
            String input = scanner.next().toUpperCase();
            if (input.equals("S")){
                this.veiculos.remove(this.veiculos.get(index));
                System.out.println("Veículo excluido com sucesso!");
            } else {
                System.out.println("Operação cancelada com sucesso!");
            }
        }

    }

}
