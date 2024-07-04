package org.example.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the VendingMachine interface.
 */
public class VendingMachineImpl implements VendingMachine {
    private int depositPool;  // Current balance in the vending machine
    private List<Product> products; // List of products available in the vending machine

    /**
     * Constructor to initialize the vending machine.
     */
    public VendingMachineImpl() {
        this.depositPool = 0; // Initialize the deposit pool to 0, which means no money has been added yet.
        this.products = new ArrayList<>(); // Create a new ArrayList to hold the products available in the vending machine.

        // Initialize the vending machine with some predefined products
        products.add(new Candy(1, "Bounty", 10, "Chocolate"));
        products.add(new Drink(2, "Pepsi Max", 15, 500));
    }
    /**
     * Adds currency to the vending machine's deposit pool.
     *
     * @param amount The amount to be added.
     */
    @Override
    public void addCurrency(int amount) {
        // Check if the amount is a valid denomination
        if (amount == 1 || amount == 2 || amount == 5 || amount == 10 || amount == 20 || amount == 50 ||
                amount == 100 || amount == 200 || amount == 500 || amount == 1000) {
            depositPool += amount; // Add the valid amount to the deposit pool
        } else {
            throw new IllegalArgumentException("Invalid currency amount"); // Throw an error if the amount is not valid
        }
    }

    /**
     * Requests a product from the vending machine.
     *
     * @param productId The ID of the product to be bought.
     * @return The requested product.
     */
    @Override
    public Product request(int productId) {
        // Find the product by ID
        for (Product product : products) {
            if (product.getId() == productId) {
                // Check if there is enough money to buy the product
                if (depositPool >= product.getPrice()) {
                    depositPool -= product.getPrice();
                    return product;
                } else {
                    throw new IllegalArgumentException("Insufficient funds");
                }
            }
        }
        throw new IllegalArgumentException("Product not found");
    }

    /**
     * Ends the session and returns the remaining balance.
     *
     * @return The remaining balance.
     */
    @Override
    public int endSession() {
        int refund = depositPool;
        depositPool = 0;
        return refund;
    }

    /**
     * Gets the description of a specific product.
     *
     * @param productId The ID of the product.
     * @return The product description.
     */
    @Override
    public String getDescription(int productId) {
        // Find the product by ID and return its description
        for (Product product : products) {
            if (product.getId() == productId) {
                return product.getDescription();
            }
        }
        return "Product not found";
    }

    /**
     * Gets the current balance in the vending machine.
     *
     * @return The current balance.
     */
    @Override
    public int getBalance() {
        return depositPool;
    }

    /**
     * Gets a list of available products.
     *
     * @return An array of product descriptions.
     */
    @Override
    public String[] getProducts() {
        String[] productArray = new String[products.size()];
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            productArray[i] = product.getId() + ", " + product.getName() + ", " + product.getPrice();
        }
        return productArray;
    }
}

