package DAOImpl;

import DAO.CoverDAO;
import logic.Cover;

import java.sql.SQLException;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;

import util.HibernateUtil;
import javax.swing.*;
import org.hibernate.Session;

public class CoverDAOImpl implements CoverDAO {

    public Cover getCoverById(long id_cover) throws SQLException {
        Session session = null;
        Cover cover = null;
        session = HibernateUtil.getSessionFactory().openSession();
        cover = (Cover) session.get(Cover.class, id_cover);
        if (session != null && session.isOpen()) {
            session.close();
        }
        return cover;
    }

    public Collection getAllCovers() throws SQLException {
        Session session = null;
        List covers = new ArrayList<Cover>();
        session = HibernateUtil.getSessionFactory().openSession();
        covers = session.createCriteria(Cover.class).list();
        if (session != null && session.isOpen()) {
            session.close();
        }
        return covers;
    }

    public void updateCover(long id_cover, Cover cover) throws SQLException {
        Session session = null;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(cover);
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
            session.close();
        }
    }

    public void addCover(Cover cover) throws SQLException {
        Session session = null;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(cover);
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
            session.close();
        }
    }

    public void deleteCover(Cover cover) throws SQLException {
        Session session = null;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(cover);
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
            session.close();
        }
    }

}
