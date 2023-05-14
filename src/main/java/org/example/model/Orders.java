package org.example.model;

/**
 * Clasa Comanda reprezinta o tabela din baza de date
 * Aceasta clasa are 2 constructori,settere, gettere si metoda toString()
 */
public class Orders {
    private int id;
    private int clientID;
    private int productID;
    private int quantity;
    public Orders(int id, int clientID, int productID, int quantity) {
        super();
        this.id = id;
        this.clientID = clientID;
        this.productID = productID;
        this.quantity = quantity;
    }
    public Orders(int clientID, int productID, int quantity) {
        super();
        this.clientID = clientID;
        this.productID = productID;
        this.quantity = quantity;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getClientID() {
        return clientID;
    }
    public int getProductID() {
        return productID;
    }
    public int getQuantity() {
        return quantity;
    }
    @Override
    public String toString() {
        return "Orders [id=" + id + ", quantity=" + quantity +"]";
    }

}