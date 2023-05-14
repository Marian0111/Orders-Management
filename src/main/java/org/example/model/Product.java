package org.example.model;

/**
 * Clasa Product reprezinta o tabela din baza de date
 * Aceasta clasa are 2 constructori,settere ,gettere si metoda toString()
 */
public class Product {
    private int id;
    private String name;
    private double price;
    private int stock;
    public Product(int id, String name, double price, int stock) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
    public Product(String name, double price, int stock) {
        super();
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", price=" + price + ", stock=" + stock + "]";
    }

}