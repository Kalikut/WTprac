package DAOImpl;

import DAO.ClientDAO;
import DAO.OrderDAO;
import DAO.OrderJournalDAO;
import DAO.StatusDAO;
import logic.Order;
import logic.Client;

import java.sql.SQLException;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import logic.OrderJournal;
import logic.Status;
import util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Query;

public class OrderDAOImpl implements OrderDAO {

    public void addOrder(Order order) throws SQLException {
        Session session = null;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(order);
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
            session.close();
        }
    }

    public void updateOrder(long id_order, Order order) throws SQLException {
        Session session = null;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(order);
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
            session.close();
        }
    }

    public Order getOrderById(long id_order) throws SQLException {
        Session session = null;
        Order order = null;
        session = HibernateUtil.getSessionFactory().openSession();
        order = (Order) session.get(Order.class, id_order);
        if (session != null && session.isOpen()) {
            session.close();
        }
        return order;
    }

    public Collection getAllOrders() throws SQLException {
        Session session = null;
        List order = new ArrayList<Order>();
        session = HibernateUtil.getSessionFactory().openSession();
        order = session.createCriteria(Order.class).list();
        if (session != null && session.isOpen()) {
            session.close();
        }
        return order;
    }

    public void updateClient(long id_client, Client client) throws SQLException {
        Session session = null;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(client);
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
            session.close();
        }
    }

    public void deleteOrder(Order order) throws SQLException {
        OrderJournalDAO oj = new OrderJournalDAOImpl();
        Collection order_journals = oj.getOrderJournalsByOrder(order);
        Iterator iterator = order_journals.iterator();
        while (iterator.hasNext()) {
            OrderJournal cur_oj = (OrderJournal) iterator.next();
            order.removeOrder_journal(cur_oj);
            oj.deleteOrderJournal(cur_oj);
        }
        ClientDAO cn = new ClientDAOImpl();
        Client client = cn.getClientById(order.getClient_id());
        client.removeOrder(order);
        cn.updateClient(client.getId(), client);
        StatusDAO st = new StatusDAOImpl();
        Status status = st.getStatusById(order.getStatus_id());
        status.removeOrder(order);
        st.updateStatus(status.getId(), status);
        Session session = null;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(order);
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
            session.close();
        }
    }

    public Collection getOrdersByClient(Client client){
        Session session = null;
        List orders = new ArrayList<Order>();
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        long id_client = client.getId();
        Query query = session.createQuery("from Order where client_id = :clientId").setLong("clientId", id_client);
        orders = (List<Order>) query.list();
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
            session.close();
        }
        return orders;
    }

}
