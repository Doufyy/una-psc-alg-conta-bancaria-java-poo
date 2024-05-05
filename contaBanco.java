import java.util.Scanner;

class ContaBancaria {
	private double saldo;

    public ContaBancaria(String nome, int numeroConta, double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
    }

    public void sacar(double valor) {
        if (valor > saldo) {
            System.out.println("Saldo insuficiente para realizar a operação.");
        } else if (valor > 5000) {
            System.out.println("Valor do saque acima do permitido.");
        } else {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
        }
    }

    public double obterSaldo() {
        return saldo;
    }
}

public class contaBanco {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o nome da pessoa:");
        String nome = sc.nextLine();

        System.out.println("Digite o número da conta:");
        int numeroConta = sc.nextInt();

        System.out.println("Digite o saldo inicial:");
        double saldoInicial = sc.nextDouble();

        ContaBancaria conta = new ContaBancaria(nome, numeroConta, saldoInicial);
        System.out.println("Conta bancária criada com sucesso...");

        while (true) {
            System.out.println("\nEscolha uma operação:");
            System.out.println("1. Depositar");
            System.out.println("2. Sacar");
            System.out.println("3. Ver saldo disponivel");
            System.out.println("4. Sair");

            int escolha = sc.nextInt();

            switch (escolha) {
                case 1:
                    System.out.println("Digite o valor a depositar:");
                    double valorDeposito = sc.nextDouble();
                    conta.depositar(valorDeposito);
                    break;
                case 2:
                    System.out.println("Digite o valor a sacar:");
                    double valorSaque = sc.nextDouble();
                    conta.sacar(valorSaque);
                    break;
                case 3:
                    System.out.println("Saldo disponível: R$" + conta.obterSaldo());
                    break;
                case 4:
                    System.out.println("Saindo do programa...");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
    }
}
