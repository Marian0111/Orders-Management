package org.example.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;

import org.example.bll.BillBLL;
import org.example.connection.ConnectionFactory;
import org.example.model.Orders;

public class OrderDAO extends AbstractDAO<Orders>{
    protected static final Logger LOGGER = Logger.getLogger(OrderDAO.class.getName());
    private final static String findStatementString = "SELECT * FROM orders where id = ?";
    private final static String findStatementStringByClient = "SELECT * FROM orders where clientID = ?";
    private final static String findStatementStringByProduct = "SELECT * FROM orders where productID = ?";

    /**
     * Metoda publica care cauta o comanda dupa id-ul acesteia
     * @param orderId
     * @return
     */
    public Orders findById(int orderId) {
        Orders toReturn = null;

        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            findStatement = dbConnection.prepareStatement(findStatementString);
            findStatement.setLong(1, orderId);
            rs = findStatement.executeQuery();
            rs.next();
            int clientID = rs.getInt("clientID");
            int productID = rs.getInt("productID");
            int quantity = rs.getInt("quantity");

            toReturn = new Orders(orderId, clientID, productID, quantity);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING,"OrderDAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }
        return toReturn;
    }
    /**
     * Metoda publica care returneaza lista comenzilor dupa un id de client
     * @param clientID
     * @return
     */
    public List<Orders> findByClientID(int clientID)
    {
        List<Orders> orders = new ArrayList<>();
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            findStatement = dbConnection.prepareStatement(findStatementStringByClient);
            findStatement.setLong(1, clientID);
            rs = findStatement.executeQuery();
            while(rs.next()){
                int orderId = rs.getInt("id");
                int productID = rs.getInt("productID");
                int quantity = rs.getInt("quantity");
                Orders order = new Orders(orderId, clientID, productID, quantity);
                orders.add(order);
            }
            return orders;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING,"OrderDAO:findByClientID " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }
        return null;
    }
    /**
     * Metoda publica care returneaza lista comenzilor dupa un id de produs
     * @param productID
     * @return
     */
    public List<Orders> findByOrderID(int productID)
    {
        List<Orders> orders = new ArrayList<>();
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            findStatement = dbConnection.prepareStatement(findStatementStringByProduct);
            findStatement.setLong(1, productID);
            rs = findStatement.executeQuery();
            while(rs.next()){
                int orderId = rs.getInt("id");
                int clientID = rs.getInt("clientID");
                int quantity = rs.getInt("quantity");
                Orders order = new Orders(orderId, clientID, productID, quantity);
                orders.add(order);
            }
            return orders;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING,"OrderDAO:findByProductID " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }
        return null;
    }

    /**
     * Metoda care apeleaza metoda din clasa din care mosteneste care adauga o comanda noua si creaza
     * o factura pentru comanda respectiva
     * @param order
     * @return
     */
    public Orders insert(Orders order){
        Orders returnOrder = super.insert(order);
        BillBLL billBLL = new BillBLL();
        billBLL.insertBill(returnOrder);
        return  returnOrder;
    }
}