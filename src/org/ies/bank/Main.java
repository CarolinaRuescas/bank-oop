package org.ies.bank;


import org.ies.bank.components.readers.scanner.ScannerAccountReader;
import org.ies.bank.components.BankApp;
import org.ies.bank.components.readers.scanner.ScannerBankReader;
import org.ies.bank.components.readers.scanner.ScannerCustomerReader;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ScannerCustomerReader scannerCustomerReader = new ScannerCustomerReader(scanner);
        ScannerAccountReader scannerAccountReader = new ScannerAccountReader(scanner, scannerCustomerReader);
        ScannerBankReader scannerBankReader = new ScannerBankReader(scanner, scannerAccountReader);
        BankApp bankApp = new BankApp(scanner, scannerBankReader);

        bankApp.run();
    }
}