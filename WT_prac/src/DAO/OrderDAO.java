package DAO;

import logic.Order;
import logic.Client;

import java.util.Collection;
import java.sql.SQLException;

public interface OrderDAO {
    public void addOrder(Order order) throws SQLException;
    public void updateOrder(long id_order, Order order) throws SQLException;
    public Order getOrderById(long id_order) throws SQLException;
    public Collection getAllOrders() throws SQLException;
    public void deleteOrder(Order order) throws SQLException;
    public Collection getOrdersByClient(Client client) throws SQLException;
}
