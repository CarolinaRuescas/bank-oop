package org.ies.bank.components;

import org.ies.bank.components.readers.scanner.ScannerBankReader;
import org.ies.bank.model.Bank;

import java.util.Scanner;

public class BankMenu {
    private final Scanner scanner;
    private final ScannerBankReader scannerBankReader;

    public BankMenu(Scanner scanner, ScannerBankReader scannerBankReader) {
        this.scanner = scanner;
        this.scannerBankReader = scannerBankReader;
    }

    public void run() {
        Bank bank = scannerBankReader.read();
        int option;
        do {
            option = chooseOption();

            if (option == 1) {
                bank.showAccount();
            } else if (option == 2) {
                showAccountOption(bank);
            } else if (option == 3) {
                showCustomerAccountsOption(bank);
            } else if (option == 4) {
                depositOption(bank);
            } else if (option == 5) {
                withdrawOption(bank);
            } else if (option == 6) {
                countCustomerAccountsOption(bank);
            } else if (option == 7) {
                showAccountCustomerOption(bank);
            } else if (option == 8) {
                transferOption(bank);
            } else if (option == 9) {
                System.out.println("Saliendo del menu...");
            } else {
                System.out.println("Opción inválida");
            }
        } while (option != 9);
    }

    private void transferOption(Bank bank) {
        System.out.println("Introduce el IBAN de la cuenta origen:");
        String iban = scanner.nextLine();

        System.out.println("Introduce el IBAN de la cuenta destino:");
        String iban2 = scanner.nextLine();

        System.out.println("¿Que cantidad de dinero queire transferir?");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        bank.transfer(iban, iban2, amount);
    }

    private void showAccountCustomerOption(Bank bank) {
        System.out.println("Introduce un IBAN:");
        String iban = scanner.nextLine();

        bank.showAccountCustomer(iban);
    }

    private void countCustomerAccountsOption(Bank bank) {
        System.out.println("Introduce un NIF:");
        String nif = scanner.nextLine();

        int count = bank.countCustomerAccount(nif);
        System.out.println(count);
    }

    private void withdrawOption(Bank bank) {
        System.out.println("Introduce un IBAN:");
        String iban = scanner.nextLine();

        System.out.println("Introduce la cantidad de dinero que quiere sacar:");
        int amount = scanner.nextInt();
        scanner.nextLine();

        bank.withdraw(iban, amount);
    }

    private void depositOption(Bank bank) {
        System.out.println("Introduce un IBAN:");
        String iban = scanner.nextLine();

        System.out.println("Introduce una cantidad de dinero");
        int amount = scanner.nextInt();
        scanner.nextLine();

        bank.deposit(iban, amount);
    }

    private void showCustomerAccountsOption(Bank bank) {
        System.out.println("Introduce un NIF:");
        String nif = scanner.nextLine();

        bank.showAccountCustomer(nif);
    }

    private void showAccountOption(Bank bank) {
        System.out.println("Introduce un IBAN:");
        String iban = scanner.nextLine();

        bank.showAccount(iban);
    }

    private int chooseOption() {
        int option;
        System.out.println("Elige una opción:");
        System.out.println("1.Mostrar las cuentas del banco");
        System.out.println("2.Mostrar datos de una cuenta");
        System.out.println("3.Mostrar los datos de las cuentas de un cliente");
        System.out.println("4.Ingresar dinero en cuenta");
        System.out.println("5.Sacar dinero de una cuenta");
        System.out.println("6.Mostrar el número de cuentas de un cliente");
        System.out.println("7.Mostrar los datos del cliente al que pertenece la cuenta");
        System.out.println("8.Realizar transferencia");
        System.out.println("9.Salir");

        //Leer la opcion
        option = scanner.nextInt();
        scanner.nextLine();
        return option;
    }
}
