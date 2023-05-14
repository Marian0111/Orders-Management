package org.example.presentation;

import org.example.bll.*;
import org.example.model.*;

import java.awt.event.*;

/**
 * Clasa Controller este folosita pentru a gestiona actiunile pentru fiecare button a aplicatiei.
 */
public class Controller {
    private ProductView productView;
    private ClientView clientView;
    private OrderView orderView;
    private
    ClientBLL clientBLL;
    ProductBLL productBLL;
    OrderBLL orderBLL;

    public Controller(ClientView clientView, ProductView productView, OrderView orderview) {
        this.clientView = clientView;
        clientBLL = new ClientBLL();
        clientView.insertClientListener(new InsertClientListener());
        clientView.editClientListener(new UpdateClientListener());
        clientView.deleteClientListener(new DeleteClientListener());
        clientView.showAllClientListener(new ShowAllClientListener());
        clientView.insertListener(new InsertCListener());
        clientView.backListener(new BackCListener());
        clientView.editListener(new EditCListener());
        clientView.selectListener(new SelectCListener());
        clientView.deleteListener(new DeleteCListener());
        this.productView = productView;
        productBLL = new ProductBLL();
        productView.insertProductListener(new InsertProductListener());
        productView.editProductListener(new UpdateProductListener());
        productView.deleteProductListener(new DeleteProductListener());
        productView.showAllProductListener(new ShowAllProductListener());
        productView.insertListener(new InsertPListener());
        productView.backListener(new BackPListener());
        productView.editListener(new EditPListener());
        productView.selectListener(new SelectPListener());
        productView.deleteListener(new DeletePListener());
        this.orderView = orderview;
        orderBLL = new OrderBLL();
        orderView.insertOrderListener(new InsertOrderListener());
        orderView.showAllOrderListener(new ShowAllOrderListener());
        orderView.insertListener(new InsertOListener());
        orderView.backListener(new BackOListener());
    }

    class InsertClientListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            clientView.changePanel(1);
        }
    }
    class UpdateClientListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            clientView.createTable(clientBLL.findAll());
            clientView.changeScrollPanel(1);
            clientView.changePanel(2);
        }
    }
    class DeleteClientListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            clientView.createTable(clientBLL.findAll());
            clientView.changeScrollPanel(2);
            clientView.changePanel(3);
        }
    }
    class ShowAllClientListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            clientView.createTable(clientBLL.findAll());
            clientView.changeScrollPanel(3);
            clientView.changePanel(4);
        }
    }
    class BackCListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            clientView.changePanel(0);
        }
    }
    class InsertCListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (clientView.getFirstNameTXT().equals("")) {
                clientView.showMessage("First Name invalid!");
            } else if (clientView.getLastNameTXT().equals("")) {
                clientView.showMessage("Last Name invalid!");
            } else if (clientView.getAddressTXT().equals("")) {
                clientView.showMessage("Address invalid!");
            }else if (clientView.getEmailTXT().equals("")) {
                clientView.showMessage("Email invalid!");
            } else {
                String firstName = clientView.getFirstNameTXT();
                String lastName = clientView.getLastNameTXT();
                String address = clientView.getAddressTXT();
                String email = clientView.getEmailTXT();
                Client client = new Client(firstName, lastName, address, email);
                try {
                    int newId = clientBLL.insertClient(client);
                    if (newId != -1) {
                        clientView.showMessage("Inserare produsa cu succes!");
                        orderView.createTable1(clientBLL.findAll());
                    }
                    client.setId(newId);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        }
    }
    class SelectCListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int id = clientView.returnID();
            if(id != -1) {
                Client client = clientBLL.findClientById(id);
                clientView.setFirstNameTXT1(client.getFirstName());
                clientView.setLastNameTXT1(client.getLastName());
                clientView.setAddressTXT1(client.getAddress());
                clientView.setEmailTXT1(client.getEmail());
            }else{
                clientView.showMessage("Select a row from table!");
            }
        }
    }
    class EditCListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int id = clientView.returnID();
            if(id != -1) {
                if (clientView.getFirstNameTXT1().equals("")) {
                    clientView.showMessage("First Name invalid!");
                } else if (clientView.getLastNameTXT1().equals("")) {
                    clientView.showMessage("Last Name invalid!");
                } else if (clientView.getAddressTXT1().equals("")) {
                    clientView.showMessage("Address invalid!");
                }else if (clientView.getEmailTXT1().equals("")) {
                    clientView.showMessage("Email invalid!");
                } else {
                    String firstName = clientView.getFirstNameTXT1();
                    String lastName = clientView.getLastNameTXT1();
                    String address = clientView.getAddressTXT1();
                    String email = clientView.getEmailTXT1();
                    Client client = new Client(id, firstName, lastName, address, email);
                    clientBLL.updateClient(client, id);
                    clientView.createTable(clientBLL.findAll());
                    clientView.changeScrollPanel(1);
                    orderView.createTable1(clientBLL.findAll());
                }
            }else{
                clientView.showMessage("Select a row from table!");
            }
        }
    }
    class DeleteCListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int id = clientView.returnID();
            if(id != -1) {
                clientBLL.deleteClient(id);
                clientView.createTable(clientBLL.findAll());
                clientView.changeScrollPanel(2);
                orderView.createTable1(clientBLL.findAll());
                orderView.createTable3(orderBLL.findAll());
            }else{
                clientView.showMessage("Select a row from table!");
            }
        }
    }

    class InsertProductListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            productView.changePanel(1);
        }
    }
    class UpdateProductListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            productView.createTable(productBLL.findAll());
            productView.changeScrollPanel(1);
            productView.changePanel(2);
        }
    }
    class DeleteProductListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            productView.createTable(productBLL.findAll());
            productView.changeScrollPanel(2);
            productView.changePanel(3);
        }
    }
    class ShowAllProductListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            productView.createTable(productBLL.findAll());
            productView.changeScrollPanel(3);
            productView.changePanel(4);
        }
    }
    class BackPListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            productView.changePanel(0);
        }
    }
    class InsertPListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (productView.getNameTXT().equals("")) {
                productView.showMessage("Product Name invalid!");
            } else if (productView.getPriceTXT().equals("")) {
                productView.showMessage("Price invalid!");
            } else if (productView.getStockTXT().equals("")) {
                productView.showMessage("Stock invalid!");
            }else {
                String name = productView.getNameTXT();
                double price = Double.valueOf(productView.getPriceTXT());
                int stock = Integer.parseInt(productView.getStockTXT());
                Product product = new Product(name, price, stock);
                try {
                    int newId = productBLL.insertProduct(product);
                    if (newId != -1) {
                        productView.showMessage("Inserare produs cu succes!");
                        orderView.createTable2(productBLL.findAll());
                    }
                    product.setId(newId);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        }
    }
    class SelectPListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int id = productView.returnID();
            if(id != -1) {
                Product product = productBLL.findProductById(id);
                productView.setNameTXT1(product.getName());
                productView.setPriceTXT1(String.valueOf(product.getPrice()));
                productView.setStockTXT1(String.valueOf(product.getStock()));
            }else{
                productView.showMessage("Select a row from table!");
            }
        }
    }
    class EditPListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int id = productView.returnID();
            if(id != -1) {
                if (productView.getNameTXT1().equals("")) {
                    productView.showMessage("Product Name invalid!");
                } else if (productView.getPriceTXT1().equals("")) {
                    productView.showMessage("Price invalid!");
                } else if (productView.getStockTXT1().equals("")) {
                    productView.showMessage("Stock invalid!");
                } else {
                    String name = productView.getNameTXT1();
                    double price = Double.valueOf(productView.getPriceTXT1());
                    int stock = Integer.parseInt(productView.getStockTXT1());
                    Product product = new Product(name, price, stock);
                    productBLL.updateProduct(product, id);
                    productView.createTable(productBLL.findAll());
                    productView.changeScrollPanel(1);
                    orderView.createTable2(productBLL.findAll());
                }
            }else{
                productView.showMessage("Select a row from table!");
            }
        }
    }
    class DeletePListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int id = productView.returnID();
            if(id != -1) {
                productBLL.deleteProduct(id);
                productView.createTable(productBLL.findAll());
                productView.changeScrollPanel(2);
                orderView.createTable2(productBLL.findAll());
                orderView.createTable3(orderBLL.findAll());
            }else{
                productView.showMessage("Select a row from table!");
            }
        }
    }

    class InsertOrderListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            orderView.createTable1(clientBLL.findAll());
            orderView.createTable2(productBLL.findAll());
            orderView.changePanel(1);
        }
    }
    class ShowAllOrderListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            orderView.createTable3(orderBLL.findAll());
            orderView.changePanel(2);
        }
    }
    class BackOListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            orderView.changePanel(0);
        }
    }
    class InsertOListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (orderView.getQuantityTXT().equals("")) {
                orderView.showMessage("Quantity invalid!");
            } else {
                int clientID = orderView.returnClientID();
                int productID = orderView.returnProductID();
                if(clientID != -1){
                    if(productID != -1){
                        int quantity = Integer.parseInt(orderView.getQuantityTXT());
                        Orders order = new Orders(clientID, productID, quantity);
                        try {
                            int newId = orderBLL.insertOrder(order);
                            if (newId != -1) {
                                orderView.showMessage("Inserare comanda cu succes!");
                                orderView.createTable1(clientBLL.findAll());
                                orderView.createTable2(productBLL.findAll());
                            }
                            order.setId(newId);
                        } catch (Exception ex) {
                            orderView.showMessage("Stock insuficient!");
                        }
                    } else {
                        orderView.showMessage("Select one product!");
                    }
                } else {
                    orderView.showMessage("Select one client!");
                }
            }
        }
    }

}