package DAOImpl;

import DAO.StatusDAO;
import logic.Status;

import java.sql.SQLException;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;

import util.HibernateUtil;
import org.hibernate.Session;

public class StatusDAOImpl implements StatusDAO {

    public Status getStatusById(long id_status) throws SQLException {
        Session session = null;
        Status status = null;
        session = HibernateUtil.getSessionFactory().openSession();
        status = (Status) session.get(Status.class, id_status);
        if (session != null && session.isOpen()) {
            session.close();
        }
        return status;
    }

    public Collection getAllStatuses() throws SQLException {
        Session session = null;
        List statuses = new ArrayList<Status>();
        session = HibernateUtil.getSessionFactory().openSession();
        statuses = session.createCriteria(Status.class).list();
        if (session != null && session.isOpen()) {
            session.close();
        }
        return statuses;
    }

    public void updateStatus(long id_status, Status status) throws SQLException {
        Session session = null;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(status);
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
            session.close();
        }
    }

}
