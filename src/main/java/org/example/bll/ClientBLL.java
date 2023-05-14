package org.example.bll;

import java.util.*;

import org.example.bll.validators.*;
import org.example.dao.*;
import org.example.model.*;

import javax.swing.table.DefaultTableModel;

public class ClientBLL {
    private List<Validator<Client>> validators;
    private ClientDAO clientdao;
    public ClientBLL() {
        validators = new ArrayList<Validator<Client>>();
        validators.add(new EmailValidator());
        clientdao = new ClientDAO();
    }
    /**
     * Metoda cauta un client dupa un ID primit ca si parametru.
     * @param id
     * @return Client
     * @throws NoSuchElementException
     */
    public Client findClientById(int id) {
        Client cl = clientdao.findById(id);
        if (cl == null) {
            throw new NoSuchElementException("The client with id =" + id + " was not found!");
        }
        return cl;
    }
    /**
     * Metoda pentru inserarea unui client.
     * Verifica pentru inceput daca este un client valid dupa care face insert
     * @param client
     * @return Client
     */
    public int insertClient(Client client) {
        for (Validator<Client> v : validators) {
            v.validate(client);
        }
        return clientdao.insert(client).getId();
    }
    /**
     * Metoda pentru a edita un client.
     * Verifica pentru inceput daca este un client valid dupa care face update
     * @param client
     * @param id
     */
    public void updateClient(Client client, int id) {
        for (Validator<Client> v : validators) {
            v.validate(client);
        }
        clientdao.update(client, id);
    }
    /**
     * Metoda pentru a sterge un client.
     * Dupa ce sterge clientul respectiv va sterge automat si comenzile pe care le-a facut
     * @param id
     */
    public void deleteClient(int id) {
        OrderDAO orderdao = new OrderDAO();
        List<Orders> orders = orderdao.findByClientID(id);
        for(Orders o : orders){
            orderdao.delete(o.getId());
        }
        clientdao.delete(id);
    }
    public DefaultTableModel findAll() {
        return clientdao.findAll();
    }
}
