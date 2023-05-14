package org.example.dao;

import java.sql.*;
import java.sql.Statement;
import java.util.logging.*;

import org.example.connection.ConnectionFactory;
import org.example.model.*;

public class BillDAO {
    protected static final Logger LOGGER = Logger.getLogger(ClientDAO.class.getName());
    private static final String insertStatementString = "INSERT INTO bill (orderID, firstName, lastName, productName, quantity, price)" + " VALUES (?,?,?,?,?,?)";
    private final static String findStatementString = "SELECT * FROM bill where id = ?";

    /**
     * Metoda publica care citeste factura
     * @param billID id-ul facturii
     * @return toReturn
     */
    public Bill findById(int billID) {
        Bill toReturn = null;
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            findStatement = dbConnection.prepareStatement(findStatementString);
            findStatement.setLong(1, billID);
            rs = findStatement.executeQuery();
            rs.next();
            int orderID = rs.getInt("orderID");
            String firstName = rs.getString("firstName");
            String lastName = rs.getString("lastName");
            String productName = rs.getString("productName");
            int quantity = rs.getInt("quantity");
            double price = rs.getDouble("price");
            toReturn = new Bill(billID, orderID, firstName, lastName, productName, quantity, price);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING,"ClientDAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }
        return toReturn;
    }
    /**
     * Metoda publica care insereaza o noua factura
     * @param order comanda pentru care se creaza factura
     * @return toReturn
     */
    public Bill insert(Orders order){
        Bill toReturn = null;
        Connection connection = null;
        PreparedStatement insertStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionFactory.getConnection();
            ProductDAO productdao = new ProductDAO();
            ClientDAO clientdao = new ClientDAO();
            Product product = productdao.findById(order.getProductID());
            Client client = clientdao.findById(order.getClientID());
            int orderID = order.getId();
            String firstName = client.getFirstName();
            String lastName = client.getLastName();
            String productName = product.getName();
            int quantity = order.getQuantity();
            double price = product.getPrice();
            insertStatement = connection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setString(1, String.valueOf(orderID));
            insertStatement.setString(2, firstName);
            insertStatement.setString(3, lastName);
            insertStatement.setString(4, productName);
            insertStatement.setString(5, String.valueOf(quantity));
            insertStatement.setString(6, String.valueOf(price));
            insertStatement.executeUpdate();
            resultSet = insertStatement.getGeneratedKeys();
            if (resultSet.next()) {
                int insertedID = resultSet.getInt(1);
                toReturn = new Bill(insertedID, orderID, firstName, lastName, productName, quantity, price);
            }
            return toReturn;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "DAO:insert " + e.getMessage());
        }finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(connection);
        }
        return null;
    }
}
