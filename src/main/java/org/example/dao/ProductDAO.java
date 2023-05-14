package org.example.dao;
import java.sql.*;
import java.util.logging.*;

import org.example.connection.ConnectionFactory;
import org.example.model.Product;

public class ProductDAO extends AbstractDAO<Product>{
    protected static final Logger LOGGER = Logger.getLogger(ProductDAO.class.getName());
    private final static String findStatementString = "SELECT * FROM product where id = ?";

    /**
     * Metoda publica care cauta un produs dupa id-ul acestuia
     * @param productId
     * @return
     */
    public Product findById(int productId) {
        Product toReturn = null;

        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            findStatement = dbConnection.prepareStatement(findStatementString);
            findStatement.setLong(1, productId);
            rs = findStatement.executeQuery();
            rs.next();

            String name = rs.getString("name");
            double price = rs.getDouble("price");
            int stock = rs.getInt("stock");
            toReturn = new Product(productId, name, price, stock);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING,"ProductDAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }
        return toReturn;
    }
}