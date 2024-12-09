package org.ies.bank.components;

import org.ies.bank.model.Account;
import org.ies.bank.model.Bank;

import java.util.Scanner;

public class BankApp {
    private final Scanner scanner;
    private final BankReader bankReader;

    public BankApp(Scanner scanner, BankReader bankReader) {
        // se necesita el Scanner para hacer el  menu
        this.scanner = scanner;
        // se necesita el BankReader para pedir un banco al usuario
        this.bankReader = bankReader;
    }

    public void run() {
        // siempre empezamos pidiendo los datos con el reader
        Bank bank = bankReader.read();
        int option;
        do {
            option = chooseOption();
            if (option == 1) {
                bank.showAccount();
            } else if (option == 2) {
                System.out.println("Intorduce el IBAN de la cuenta:");
                String iban = scanner.nextLine();
                if (bank.findAccount(iban) != null){
                    bank.findAccount(iban);
                }else{
                    System.out.println("No existe la cuenta");
                }

            } else if (option == 3) {
                System.out.println("Introduce el NIF del cliente: ");
                String nif = scanner.nextLine();
                bank.showAccountNif(nif);
                for (Account account : bank.getAccounts()) {
                    if (account.getCustomer().getNif().equals(nif)) {
                        account.showInfo();
                    }
                }
            }else if (option ==4){
                System.out.println("Intorduce el IBAN de la cuenta: ");
                String iban = scanner.nextLine();
                System.out.println("Introduce la cantidad de dinero que quiere ingresar: ");
                double amount;

                do{
                    amount = scanner.nextDouble();
                    scanner.nextLine();
                    if (amount <0);
                    System.out.println("Solo puede ingresar dinero");
                }while (amount < 0);
                bank.deposit(iban,amount);

            }else if (option == 5){
                System.out.println("Intorduce el IBAN de la cuenta: ");
                String iban = scanner.nextLine();
                System.out.println("Introduce la cantidad de dinero que quiere ingresar: ");
                double amount;

                do{
                    amount = scanner.nextDouble();
                    scanner.nextLine();
                    if (amount < 0);
                    System.out.println("Solo puede ingresar dinero");
                }while (amount < 0);
                bank.deposit(iban,-amount);
            }else if(option == 6){
                System.out.println("Introduce el NIF del cliente");
                String nif = scanner.nextLine();
                int customerAccountsNumber = bank.countCustomerAccount(nif);
                System.out.println("El cliente tiene" + customerAccountsNumber + "cuentas");
            }else if (option == 7){
                System.out.println("Introduce el IBAN");
                String iban = scanner.nextLine();

                bank.showAccountCustomer(iban);
            }
        }while (option != 8) ;
    }

    private int chooseOption() {
        int option;
        do {
            System.out.println("¡BIENVENIDO!");
            System.out.println("1. Mostrar las cuentas de un banco");
            System.out.println("2. Mostrar datos de una cuenta");
            System.out.println("3. Mostrar los datos de las cuentas de un cliente");
            System.out.println("4. Ingresar dinero en cuenta");
            System.out.println("5. Sacar dinero de una cuenta");
            System.out.println("6. Contar cuentas cliente");
            System.out.println("7. Mostrar titular de cuenta");
            System.out.println("8. SALIR");
            option = scanner.nextInt();
            scanner.nextLine();
        } while (option < 1 || option > 8);
        return option;
    }
}
