package org.example.dao;

import java.beans.*;
import java.lang.reflect.*;
import java.sql.*;
import java.sql.Statement;
import java.util.*;
import java.util.logging.*;

import org.example.connection.ConnectionFactory;
import javax.swing.table.DefaultTableModel;

/**
 * Clasa AbstractDAO este clasa in care se fac principalele operatii pe baza de date (INSERT, SELECT, UPDATE, DELETE)
 * Ea implementeaza metode generice pentru fiecare metoda de lucru cu BD
 * @param <T>
 */
public class AbstractDAO<T> {
    protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());
    private final Class<T> type;
    @SuppressWarnings("unchecked")
    public AbstractDAO() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
    /**
     * Metoda privata care creaza String-ul de SELECT pentru baza de date
     * @param field
     * @return String
     */
    private String createSelectQuery(String field) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT  *  FROM ");
        sb.append(type.getSimpleName().toLowerCase());
        sb.append(" WHERE " + field + " =?");
        return sb.toString();
    }
    /**
     * Metoda privata care creaza String-ul de INSERT pentru baza de date
     * @return String
     */
    private String createInsertQuery() {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO ");
        sb.append(type.getSimpleName().toLowerCase());
        sb.append(" (");
        int k = 0;
        for (Field f : type.getDeclaredFields()) {
            if (!f.equals(type.getDeclaredFields()[0])) {
                sb.append(f.getName() + ",");
                k++;
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(")");
        if(k != 0){
            sb.append(" VALUES (");
            for(int i = 0; i < k; i++){
                sb.append("?, ");
            }
            sb.deleteCharAt(sb.length() - 2);
            sb.append(")");
        }
        return sb.toString();
    }
    /**
     * Metoda privata care creaza String-ul de DELETE pentru baza de date
     * @return String
     */
    private String createDeleteQuery() {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM ");
        sb.append(type.getSimpleName().toLowerCase());
        sb.append(" WHERE id = ?");
        return sb.toString();
    }
    /**
     * Metoda privata care creaza String-ul de UPDATE pentru baza de date
     * @return String
     */
    private String createUpdateQuery() {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE ");
        sb.append(type.getSimpleName().toLowerCase());
        sb.append(" SET ");
        for (Field f : type.getDeclaredFields()) {
            if (!f.equals(type.getDeclaredFields()[0])) {
                sb.append(f.getName());
                sb.append("=?, ");
            }
        }
        sb.deleteCharAt(sb.length() - 2);
        sb.append(" WHERE id =?");
        return sb.toString();
    }
    /**
     * Metoda publica care efectueaza operatia de INSERT in baza de date
     * @param t (Tipul - Class T - ofera posibilitatea apelarii metodei cu orice obiect)
     * @return t - obiectul care apare modificat cu id-ul autogenerat
     */
    public T insert(T t) {
        Connection connection = null;
        PreparedStatement insertStatement = null;
        ResultSet resultSet = null;
        String query = createInsertQuery();
        try {
            connection = ConnectionFactory.getConnection();
            insertStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            int i = 1;
            for (Field f : type.getDeclaredFields()) {
                if (!f.equals(type.getDeclaredFields()[0])) {
                    f.setAccessible(true);
                    insertStatement.setString(i, f.get(t).toString());
                    i++;
                }
            }
            insertStatement.executeUpdate();
            resultSet = insertStatement.getGeneratedKeys();
            if (resultSet.next()) {
                int insertedId = resultSet.getInt(1);
                Field f = type.getDeclaredField("id");
                f.setAccessible(true);
                f.set(t, insertedId);
            }
            return t;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "DAO:insert " + e.getMessage());
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(connection);
        }
        return null;
    }
    /**
     * Metoda publica care efectueaza operatia de UPDATE in baza de date
     * @param t (noul obiect cu care se face update in baza de date)
     * @param id (id-ul obiectului care se inlocuieste)
     */
    public void update(T t, int id) {
        Connection connection = null;
        PreparedStatement updateStatement = null;
        String query = createUpdateQuery();
        try {
            connection = ConnectionFactory.getConnection();
            updateStatement = connection.prepareStatement(query);
            int i = 1;
            for (Field f : type.getDeclaredFields()) {
                if (!f.equals(type.getDeclaredFields()[0])) {
                    f.setAccessible(true);
                    updateStatement.setString(i, f.get(t).toString());
                    i++;
                }
            }
            updateStatement.setString(i, String.valueOf(id));
            updateStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "DAO:update " + e.getMessage());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.close(updateStatement);
            ConnectionFactory.close(connection);
        }
    }
    /**
     * Metoda publica care efectueaza operatia de DELETE in baza de date
     * @param id (id-ul obiectului care se va sterge)
     */
    public void delete(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectQuery(type.getDeclaredFields()[0].getName());
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                query = createDeleteQuery();
                statement = connection.prepareStatement(query);
                statement.setInt(1, id);
                statement.executeUpdate();
            }else{
                throw new NoSuchElementException("The client with id =" + id + " was not found!");
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "DAO:insert " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }
    private List<T> createObjects(ResultSet resultSet) {
        List<T> list = new ArrayList<T>();
        Constructor[] ctors = type.getDeclaredConstructors();
        Constructor ctor = null;
        for (int i = 0; i < ctors.length; i++) {
            ctor = ctors[i];
            if (ctor.getGenericParameterTypes().length == 0)
                break;
        }
        try {
            while (resultSet.next()) {
                ctor.setAccessible(true);
                T instance = (T) ctor.newInstance();
                for (Field field : type.getDeclaredFields()) {
                    String fieldName = field.getName();
                    Object value = resultSet.getObject(fieldName);
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, type);
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(instance, value);
                }
                list.add(instance);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return list;
    }

    public T findById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectQuery(type.getDeclaredFields()[0].getName());
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            return createObjects(resultSet).get(0);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }
    private static DefaultTableModel buildTableModel(ResultSet rs)
            throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();

        Vector<String> columnNames = new Vector<>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        Vector<Vector<Object>> data = new Vector<>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }

        return new DefaultTableModel(data, columnNames);

    }
    public DefaultTableModel findAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = "SELECT * FROM " + type.getSimpleName();

        try {
            connection = ConnectionFactory.getConnection();
            statement = ConnectionFactory.getConnection().prepareStatement(query);
            resultSet = statement.executeQuery();

            return buildTableModel(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

}
