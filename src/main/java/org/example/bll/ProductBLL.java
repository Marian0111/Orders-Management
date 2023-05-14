package org.example.bll;

import java.util.*;

import org.example.dao.*;
import org.example.model.Orders;
import org.example.model.Product;

import javax.swing.table.DefaultTableModel;

public class ProductBLL {
    private ProductDAO productdao;
    public ProductBLL() {
        productdao = new ProductDAO();
    }
    /**
     * Metoda cauta un produs dupa un ID primit ca si parametru.
     * Verifica pentru inceput daca este un produs valid dupa care il va cauta
     * @param id
     * @return Product
     * @throws NoSuchElementException
     */
    public Product findProductById(int id) {
        Product pr = productdao.findById(id);
        if (pr == null) {
            throw new NoSuchElementException("The product with id =" + id + " was not found!");
        }
        return pr;
    }
    /**
     * Metoda pentru inserarea unui produs.
     * @param product
     * @return Product
     */
    public int insertProduct(Product product) {
        return productdao.insert(product).getId();
    }
    /**
     * Metoda pentru inserarea unui produs.
     * @param product
     * @param id
     */
    public void updateProduct(Product product, int id) {
        productdao.update(product, id);
    }
    /**
     * Metoda pentru a sterge un produs.
     * Dupa ce sterge produsul respectiv va sterge automat si comenzile facute pe baza acestuia
     * @param id
     */
    public void deleteProduct(int id) {
        OrderDAO orderdao = new OrderDAO();
        List<Orders> orders = orderdao.findByOrderID(id);
        for(Orders o : orders){
            orderdao.delete(o.getId());
        }
        productdao.delete(id);
    }
    public DefaultTableModel findAll() {
        return productdao.findAll();
    }
}
