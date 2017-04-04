package DAOImpl;

import DAO.AuthorDAO;
import DAO.BookDAO;
import logic.Author;
import logic.Book;

import java.sql.SQLException;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Query;

public class AuthorDAOImpl implements AuthorDAO {

    public void addAuthor(Author author) throws SQLException {
        Session session = null;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(author);
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
            session.close();
        }
    }

    public void updateAuthor(long id_author, Author author) throws SQLException {
        Session session = null;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(author);
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
            session.close();
        }
    }

    public Author getAuthorById(long id_author) throws SQLException {
        Session session = null;
        Author author = null;
        session = HibernateUtil.getSessionFactory().openSession();
        author = (Author) session.get(Author.class, id_author);
        if (session != null && session.isOpen()) {
            session.close();
        }
        return author;
    }

    public Collection getAuthorsByName(String author_name) throws SQLException {
        Session session = null;
        List authors = new ArrayList<Author>();
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery(
                " from Author a where a.name like :aut "
        ).setString("aut", '%' + author_name + '%');
        authors = (List<Author>) query.list();
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
            session.close();
        }
        return authors;
    }

    public Collection getAllAuthors() throws SQLException {
        Session session = null;
        List authors = new ArrayList<Author>();
        session = HibernateUtil.getSessionFactory().openSession();
        authors = session.createCriteria(Author.class).list();
        if (session != null && session.isOpen()) {
            session.close();
        }
        return authors;
    }

    public void deleteAuthor(Author author) throws SQLException {
        BookDAO bk = new BookDAOImpl();
        Collection books = bk.getBooksByAuthor(author);
        Iterator iterator = books.iterator();
        while (iterator.hasNext()) {
            Book cur_book = (Book) iterator.next();
            cur_book.removeAuthor(author);
            bk.updateBook(cur_book.getId(), cur_book);
        }
        Session session = null;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(author);
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
            session.close();
        }
    }

    public Collection getAuthorsByBook(Book book) throws SQLException {
        Session session = null;
        List books = new ArrayList<Book>();
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        long id_book = book.getId();
        Query query = session.createQuery(
                " select a "
                        + " from Author a INNER JOIN a.book b"
                        + " where b.id = :bookId "
        ).setLong("bookId", id_book);
        books = (List<Book>) query.list();
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
            session.close();
        }
        return books;
    }

}
