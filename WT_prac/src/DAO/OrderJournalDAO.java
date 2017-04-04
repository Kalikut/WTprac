package DAO;

import logic.OrderJournal;
import logic.Order;

import java.util.Collection;
import java.sql.SQLException;

public interface OrderJournalDAO {
    public void addOrderJournal(OrderJournal order_journal) throws SQLException;
    public void updateOrderJournal(long id_order_journal, OrderJournal order_journal) throws SQLException;
    public OrderJournal getOrderJournalById(long id_order_journal) throws SQLException;
    public Collection getAllOrderJournals() throws SQLException;
    public void deleteOrderJournal(OrderJournal order_journal) throws SQLException;
    public Collection getOrderJournalsByOrder(Order order) throws SQLException;
}
