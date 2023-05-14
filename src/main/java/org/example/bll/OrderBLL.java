package org.example.bll;

import java.util.*;

import org.example.bll.validators.*;
import org.example.dao.*;
import org.example.model.Orders;
import org.example.model.Product;

import javax.swing.table.DefaultTableModel;

public class OrderBLL {
    private List<Validator<Orders>> validators;
    private OrderDAO orderdao;
    public OrderBLL() {
        validators = new ArrayList<Validator<Orders>>();
        validators.add(new IdValidator());
        validators.add(new StockValidator());
        orderdao = new OrderDAO();
    }
    /**
     * Metoda pentru inserarea unei comenzi.
     * Verifica pentru inceput daca este o comanda valida dupa care face insert
     * Dupa ce va face insert va decrementa stock-ul produsului cu cantitatea comenzii
     * @param orders
     * @return Orders
     */
    public int insertOrder(Orders orders) {
        for (Validator<Orders> v : validators) {
            v.validate(orders);
        }
        ProductDAO productdao = new ProductDAO();
        Product pr = productdao.findById(orders.getProductID());
        pr.setStock(pr.getStock() - orders.getQuantity());
        productdao.update(pr,pr.getId());
        return orderdao.insert(orders).getId();
    }
    public DefaultTableModel findAll() {
        return orderdao.findAll();
    }
}
