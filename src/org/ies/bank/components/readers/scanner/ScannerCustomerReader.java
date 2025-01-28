package org.ies.bank.components.readers.scanner;

import org.ies.bank.components.readers.CustomerReader;
import org.ies.bank.model.Customer;

import java.util.Scanner;

public class ScannerCustomerReader implements CustomerReader {
    private final Scanner scanner;

    public ScannerCustomerReader(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public Customer read(){
        System.out.println("INTRODUCE LOS DATOS DEL CLIENTE");
        System.out.println("Introduce el NIF: ");
        String nif = scanner.nextLine();

        System.out.println("Introduce el nombre: ");
        String name = scanner.nextLine();

        System.out.println("Introduce el apellido: ");
        String surname = scanner.nextLine();

        return new Customer(
                nif,
                name,
                surname
        );
    }



}
