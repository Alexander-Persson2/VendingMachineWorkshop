package org.example.model;

public interface VendingMachine {
    void addCurrency(int amount); // Method to add money to the vending machine
    Product request(int productId); // Method to buy a product
    int endSession(); // Method to end the session and return remaning money
    String getDescription(int productId);
    int getBalance();
    String[] getProducts();
}
