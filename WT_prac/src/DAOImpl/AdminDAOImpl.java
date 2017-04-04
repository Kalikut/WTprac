package DAOImpl;

import DAO.AdminDAO;
import logic.Admin;

import java.sql.SQLException;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;
import org.hibernate.Session;

public class AdminDAOImpl implements AdminDAO {

    public Admin getAdminByLogin(String login) throws SQLException {
        Session session = null;
        Admin admin = null;
        session = HibernateUtil.getSessionFactory().openSession();
        Criteria userCriteria = session.createCriteria(Admin.class);
        userCriteria.add(Restrictions.eq("login", login));
        admin = (Admin) userCriteria.uniqueResult();
        if (session != null && session.isOpen()) {
            session.close();
        }
        return admin;
    }

}
