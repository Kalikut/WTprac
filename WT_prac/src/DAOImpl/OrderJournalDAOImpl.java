package DAOImpl;

import DAO.BookDAO;
import DAO.OrderDAO;
import DAO.OrderJournalDAO;
import logic.Book;
import logic.OrderJournal;
import logic.Order;

import java.sql.SQLException;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;

import util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Query;

public class OrderJournalDAOImpl implements OrderJournalDAO {

    public void addOrderJournal(OrderJournal order_journal) throws SQLException {
        Session session = null;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(order_journal);
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
            session.close();
        }
    }

    public void updateOrderJournal(long id_order_journal, OrderJournal order_journal) throws SQLException {
        Session session = null;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(order_journal);
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
            session.close();
        }
    }

    public OrderJournal getOrderJournalById(long id_order_journal) throws SQLException {
        Session session = null;
        OrderJournal order_journal = null;
        session = HibernateUtil.getSessionFactory().openSession();
        order_journal = (OrderJournal) session.get(OrderJournal.class, id_order_journal);
        if (session != null && session.isOpen()) {
            session.close();
        }
        return order_journal;
    }

    public Collection getAllOrderJournals() throws SQLException {
        Session session = null;
        List order_journals = new ArrayList<OrderJournal>();
        session = HibernateUtil.getSessionFactory().openSession();
        order_journals = session.createCriteria(OrderJournal.class).list();
        if (session != null && session.isOpen()) {
            session.close();
        }
        return order_journals;
    }

    public void deleteOrderJournal(OrderJournal order_journal) throws SQLException {
        OrderDAO od = new OrderDAOImpl();
        Order order = od.getOrderById(order_journal.getOrder_id());
        order.removeOrder_journal(order_journal);
        od.updateOrder(order.getId(), order);
        BookDAO bk = new BookDAOImpl();
        Book book = bk.getBookById(order_journal.getBook_id());
        book.removeOrder_journal(order_journal);
        od.updateOrder(order.getId(), order);
        Session session = null;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(order_journal);
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
            session.close();
        }
    }

    public Collection getOrderJournalsByOrder(Order order){
        Session session = null;
        List order_journals = new ArrayList<OrderJournal>();
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        long id_order = order.getId();
        Query query = session.createQuery("from OrderJournal where order_id = :orderId") .setLong("orderId", id_order);
        order_journals = (List<OrderJournal>) query.list();
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
            session.close();
        }
        return order_journals;
    }

}
