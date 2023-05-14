package org.example.dao;
import java.sql.*;
import java.util.logging.*;

import org.example.connection.ConnectionFactory;
import org.example.model.Client;

public class ClientDAO extends AbstractDAO<Client>{

    protected static final Logger LOGGER = Logger.getLogger(ClientDAO.class.getName());
    private final static String findStatementString = "SELECT * FROM client where id = ?";

    /**
     * Metoda publica care cauta un client dupa id-ul acestuia
     * @param clientID
     * @return
     */
    public Client findById(int clientID) {
        Client toReturn = null;

        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            findStatement = dbConnection.prepareStatement(findStatementString);
            findStatement.setLong(1, clientID);
            rs = findStatement.executeQuery();
            rs.next();

            String firstName = rs.getString("firstName");
            String lastName = rs.getString("lastName");
            String address = rs.getString("address");
            String email = rs.getString("email");
            toReturn = new Client(clientID, firstName, lastName, address, email);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING,"ClientDAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }
        return toReturn;
    }
}