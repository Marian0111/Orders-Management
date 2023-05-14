package org.example.bll.validators;

import org.example.dao.ProductDAO;
import org.example.model.Orders;

/**
 * Clasa StockValidator implementeaza interfata Validator
 * Metoda validate() primeste o comanda ca si parametru si verifica ca stock-ul sa fie suficient pentru cantitatea comandata.
 */
public class StockValidator implements Validator<Orders> {
    public void validate(Orders t) {
        ProductDAO productdao = new ProductDAO();
        int stock = productdao.findById(t.getProductID()).getStock();
        if(stock < t.getQuantity())
            throw new IllegalArgumentException("Stock not enough!");
    }

}