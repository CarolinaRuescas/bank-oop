package org.ies.bank.components.readers.scanner;

import org.ies.bank.components.readers.AccountReader;
import org.ies.bank.model.Account;
import org.ies.bank.model.Customer;

import java.util.Scanner;

public class ScannerAccountReader implements AccountReader {
    private final Scanner scanner;
    private final ScannerCustomerReader scannerCustomerReader;

    public ScannerAccountReader(Scanner scanner, ScannerCustomerReader scannerCustomerReader) {
        this.scanner = scanner;
        this.scannerCustomerReader = scannerCustomerReader;
    }

    @Override
    public Account read(){
        System.out.println("INTRODUCE LOS DATOS DE LA CUENTA");
        System.out.println("Introduce IBAN: ");
        String iban = scanner.nextLine();

        System.out.println("Introduce el balance: ");
        double balance = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Introduce el cliente: ");
        Customer customer = scannerCustomerReader.read();



        return new Account(
                iban,
                balance,
                customer
        );
    }




}
