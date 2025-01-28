package org.ies.bank;

import org.ies.bank.components.*;
import org.ies.bank.components.readers.scanner.ScannerAccountReader;
import org.ies.bank.components.readers.scanner.ScannerBankReader;
import org.ies.bank.components.readers.scanner.ScannerCustomerReader;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ScannerCustomerReader scannerCustomerReader = new ScannerCustomerReader(scanner);
        ScannerAccountReader scannerAccountReader = new ScannerAccountReader(scanner, scannerCustomerReader);
        ScannerBankReader scannerBankReader = new ScannerBankReader(scanner, scannerAccountReader);
        BankApp3 bankApp3 = new BankApp3(scannerBankReader);

        bankApp3.run();
    }

    public static class Main4 {
    }
}
