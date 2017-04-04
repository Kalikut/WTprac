package DAOImpl;

import DAO.ClientDAO;
import DAO.OrderDAO;
import logic.Client;

import java.sql.SQLException;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import logic.Order;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;
import org.hibernate.Session;

public class ClientDAOImpl implements ClientDAO {

    public void addClient(Client client) throws SQLException {
        Session session = null;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(client);
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
            session.close();
        }
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

    public Client getClientById(long id_client) throws SQLException {
        Session session = null;
        Client client = null;
        session = HibernateUtil.getSessionFactory().openSession();
        client = (Client) session.get(Client.class, id_client);
        if (session != null && session.isOpen()) {
            session.close();
        }
        return client;
    }

    public Client getClientByEmail(String e_mail) throws SQLException {
        Session session = null;
        Client client = null;
        session = HibernateUtil.getSessionFactory().openSession();
        Criteria userCriteria = session.createCriteria(Client.class);
        userCriteria.add(Restrictions.eq("e_mail", e_mail));
        client = (Client) userCriteria.uniqueResult();
        if (session != null && session.isOpen()) {
            session.close();
        }
        return client;
    }

    public Collection getAllClients() throws SQLException {
        Session session = null;
        List clients = new ArrayList<Client>();
        session = HibernateUtil.getSessionFactory().openSession();
        clients = session.createCriteria(Client.class).list();
        if (session != null && session.isOpen()) {
            session.close();
        }
        return clients;
    }

    public void deleteClient(Client client) throws SQLException {
        OrderDAO od = new OrderDAOImpl();
        Collection orders = od.getOrdersByClient(client);
        Iterator iterator = orders.iterator();
        while (iterator.hasNext()) {
            Order cur_order = (Order) iterator.next();
            client.removeOrder(cur_order);
            od.deleteOrder(cur_order);
        }
        Session session = null;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(client);
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
            session.close();
        }
    }

}
