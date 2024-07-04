package org.example.model;

public interface VendingMachine {
    void addCurrency(int amount); // Method to add money to the vending machine
    Product request(int productId); // Method to buy a product
    int endSession(); // Method to end the session and return remaning money
    String getDescription(int productId); // Gets the description of a specific product
    int getBalance(); // Gets the current balance
    String[] getProducts(); // Gets an array of descriptions for all products
}
