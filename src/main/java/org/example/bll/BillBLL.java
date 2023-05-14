package org.example.bll;

import java.util.*;

import org.example.dao.*;
import org.example.model.*;
import org.example.start.*;
public class BillBLL {
    private BillDAO billdao;
    public BillBLL() {
        billdao = new BillDAO();
    }
    /**
     * Metoda cauta un bon dupa un ID primit ca si parametru.
     * Verifica pentru inceput daca este un bon valid dupa care il va cauta
     * @param id
     * @return Bill
     * @throws NoSuchElementException
     */
    public Bill findBillById(int id) {
        Bill bill = billdao.findById(id);
        if (bill == null) {
            throw new NoSuchElementException("The bill with id =" + id + " was not found!");
        }
        return bill;
    }
    /**
     * Metoda pentru inserarea unui bon pe baza unei comenzi primite ca si parametru.
     * @param order
     * @return Bill
     */
    public Bill insertBill(Orders order) {
        Bill bill = billdao.insert(order);
        ReflectionExample.retrieveProperties(bill);
        return bill;
    }
}