package application;
import model.entities.Account;
import model.exceptions.DomainExceptions;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try{

            System.out.println("Digite os dados da conta:");
            System.out.print("Numero: ");
            int number = sc.nextInt();

            System.out.print("Nome: ");
            sc.nextLine();
            String holder = sc.nextLine();

            System.out.print("Saldo: ");
            Double balance = sc.nextDouble();

            System.out.print("Limite de Saque: ");
            Double withdrawLimit = sc.nextDouble();
            Account acc = new Account(number, holder, balance, withdrawLimit);

            System.out.println();
            System.out.print("Digite o Valor para saque: ");
            Double ammount = sc.nextDouble();
            acc.withdraw(ammount);

            System.out.println(acc);

        } catch (DomainExceptions e) {
            System.out.println("Erro no Saque: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Error in Program");
        }

        sc.close();
    }
}
