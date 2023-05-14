package org.example.bll.validators;

import org.example.dao.*;
import org.example.model.*;

/**
 * Clasa IdValidator implementeaza interfata Validator
 * Metoda validate() primeste o comanda ca si parametru si verifica daca exista clientul si produsul respectiv in baza de date.
 */
public class IdValidator implements Validator<Orders> {
    public void validate(Orders t) {
        ProductDAO productdao = new ProductDAO();
        Product pr = productdao.findById(t.getProductID());
        if(pr == null){
            throw new IllegalArgumentException("Product with id = " + t.getProductID() + " doesn't exist!");
        }

        ClientDAO clientdao = new ClientDAO();
        Client cl = clientdao.findById(t.getClientID());
        if(cl == null){
            throw new IllegalArgumentException("Client with id = " + t.getProductID() + " doesn't exist!");
        }

    }

}