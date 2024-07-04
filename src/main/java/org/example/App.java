package org.example;

import org.example.model.*;

public class App {
    public static void main(String[] args) {
        VendingMachine vm = new VendingMachineImpl();

        // Display available products
        System.out.println("Available products:");
        for (String product : vm.getProducts()) {
            System.out.println(product);
        }

        // Add money to the vending machine
        vm.addCurrency(20);
        System.out.println("Balance after adding 20: " + vm.getBalance());

        // Request a product
        Product boughtProduct = vm.request(2);
        System.out.println("Bought product: " + boughtProduct.getDescription());

        // Check if the bought product is a Drink and display its volume
        if (boughtProduct instanceof Drink) {
            Drink boughtDrink = (Drink) boughtProduct;
            System.out.println("Bought drink volume: " + boughtDrink.getVolume() + "ml");
        }

        // Display balance after purchase

        System.out.println("Balance after purchase: " + vm.getBalance());

        // End session and get refund

        vm.endSession();
        System.out.println("Balance after ending session: " + vm.getBalance());

    }
}
