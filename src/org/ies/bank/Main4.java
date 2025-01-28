package org.ies.bank;

import org.ies.bank.components.readers.scanner.ScannerAccountReader;
import org.ies.bank.components.BankApp4;
import org.ies.bank.components.readers.scanner.ScannerBankReader;
import org.ies.bank.components.readers.scanner.ScannerCustomerReader;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ScannerCustomerReader scannerCustomerReader = new ScannerCustomerReader(scanner);
        ScannerAccountReader scannerAccountReader = new ScannerAccountReader(scanner, scannerCustomerReader);
        ScannerBankReader scannerBankReader = new ScannerBankReader(scanner, scannerAccountReader);

        BankApp4 bankApp4 = new BankApp4(scannerBankReader);

        bankApp4.run();

    }
}


