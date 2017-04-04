package DAOImpl;

import DAO.*;
import logic.Book;
import logic.Author;
import logic.Cover;
import logic.Genre;

import java.sql.SQLException;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Query;

public class BookDAOImpl implements BookDAO {

    public void addBook(Book book) throws SQLException {
        Session session = null;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(book);
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
            session.close();
        }
    }

    public void updateBook(long id_book, Book book) throws SQLException {
        Session session = null;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(book);
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
            session.close();
        }
    }

    public Book getBookById(long id_book) throws SQLException {
        Session session = null;
        Book book = null;
        session = HibernateUtil.getSessionFactory().openSession();
        book = (Book) session.get(Book.class, id_book);
        if (session != null && session.isOpen()) {
            session.close();
        }
        return book;
    }

    public Collection getBooksByTitle(String book_title) throws SQLException {
        Session session = null;
        List books = new ArrayList<Book>();
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery(
                " from Book b where b.title like :title "
        ).setString("title", '%' + book_title + '%');
        books = (List<Book>) query.list();
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
            session.close();
        }
        return books;
    }

    public Collection getAllBooks() throws SQLException {
        Session session = null;
        List books = new ArrayList<Book>();
        session = HibernateUtil.getSessionFactory().openSession();
        books = session.createCriteria(Book.class).list();
        if (session != null && session.isOpen()) {
            session.close();
        }
        return books;
    }

    public void deleteBook(Book book) throws SQLException {
        GenreDAO gn = new GenreDAOImpl();
        Genre genre = gn.getGenreById(book.getGenre_id());
        genre.removeBook(book);
        gn.updateGenre(genre.getId(), genre);
        CoverDAO cv = new CoverDAOImpl();
        Cover cover = cv.getCoverById(book.getCover_id());
        cover.removeBook(book);
        cv.updateCover(cover.getId(), cover);
        AuthorDAO at = new AuthorDAOImpl();
        Collection authors = at.getAuthorsByBook(book);
        Iterator iterator = authors.iterator();
        while (iterator.hasNext()) {
            Author cur_author = (Author) iterator.next();
            cur_author.removeBook(book);
            at.updateAuthor(cur_author.getId(), cur_author);
        }
        Session session = null;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(book);
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
            session.close();
        }
    }

    public Collection getBooksByAuthor(Author author) throws SQLException {
        Session session = null;
        List books = new ArrayList<Book>();
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        long id_author = author.getId();
        Query query = session.createQuery(
                " select b "
                        + " from Book b INNER JOIN b.author a"
                        + " where a.id = :authorId "
        ).setLong("authorId", id_author);
        books = (List<Book>) query.list();
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
            session.close();
        }
        return books;
    }

    public Collection getBooksByGenre(Genre genre){
        Session session = null;
        List books = new ArrayList<Book>();
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        long id_genre = genre.getId();
        Query query = session.createQuery("from Book where genre_id = :genreId").setLong("genreId", id_genre);
        books = (List<Book>) query.list();
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
            session.close();
        }
        return books;
    }

}
