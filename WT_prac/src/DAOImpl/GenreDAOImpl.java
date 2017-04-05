package DAOImpl;

import DAO.GenreDAO;
import logic.Genre;

import java.sql.SQLException;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;

import util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Query;

public class GenreDAOImpl implements GenreDAO {

    public Genre getGenreById(long id_genre) throws SQLException {
        Session session = null;
        Genre genre = null;
        session = HibernateUtil.getSessionFactory().openSession();
        genre = (Genre) session.get(Genre.class, id_genre);
        if (session != null && session.isOpen()) {
            session.close();
        }
        return genre;
    }

    public Collection getAllGenres() throws SQLException {
        Session session = null;
        List genres = new ArrayList<Genre>();
        session = HibernateUtil.getSessionFactory().openSession();
        genres = session.createCriteria(Genre.class).list();
        if (session != null && session.isOpen()) {
            session.close();
        }
        return genres;
    }

    public Collection getGenreByName(String genre_name) throws SQLException {
        Session session = null;
        List genres = new ArrayList<Genre>();
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery(
                " from Genre g where g.genre_name like :name "
        ).setString("name", '%' + genre_name + '%');
        genres = (List<Genre>) query.list();
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
            session.close();
        }
        return genres;
    }

    public void updateGenre(long id_genre, Genre genre) throws SQLException {
        Session session = null;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(genre);
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
            session.close();
        }
    }

    public void addGenre(Genre genre) throws SQLException {
        Session session = null;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(genre);
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
            session.close();
        }
    }

    public void deleteGenre(Genre genre) throws SQLException {
        Session session = null;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(genre);
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
            session.close();
        }
    }

}
