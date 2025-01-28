package org.ies.bank.components.readers.scanner;

import org.ies.bank.components.readers.BankReader;
import org.ies.bank.model.Account;
import org.ies.bank.model.Bank;

import java.util.Scanner;

public class ScannerBankReader implements BankReader {
    private final Scanner scanner;
    private final ScannerAccountReader scannerAccountReader;

    public ScannerBankReader(Scanner scanner, ScannerAccountReader scannerAccountReader) {
        this.scanner = scanner;
        this.scannerAccountReader = scannerAccountReader;
    }

    @Override
    public Bank read(){
        System.out.println("INTRODUCE LOS DATOS DEL BANCO");
        System.out.println("Introduce el nombre del banco: ");
        String name = scanner.nextLine();

        System.out.println("¿Cuántas cuentas quiere buscar? ");
        int size = scanner.nextInt();
        scanner.nextLine();


        Account[] accounts = new Account[size];
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = scannerAccountReader.read();
        }

        return new Bank(
                name,
                accounts
        );

    }
}
