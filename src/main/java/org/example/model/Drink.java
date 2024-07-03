package org.example.model;

public class Drink extends Product {
    private int volume;

    public Drink(int id, String name, double price, int volume) {
        super(id, name, price);
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }

    @Override
    public String getDescription() {
        return "Drink: " + getName() + ", Volume: " + volume + "ml, Price: " + getPrice();
    }
}
