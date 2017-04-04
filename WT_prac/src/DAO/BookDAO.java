package DAO;

import logic.Book;
import logic.Author;
import logic.Genre;

import java.util.Collection;
import java.sql.SQLException;

public interface BookDAO {
    public void addBook(Book book) throws SQLException;
    public void updateBook(long id_book, Book book) throws SQLException;
    public Book getBookById(long id_book) throws SQLException;
    public Collection getBooksByTitle(String book_title) throws SQLException;
    public Collection getAllBooks() throws SQLException;
    public Collection getBooksByAuthor(Author author) throws SQLException;
    public Collection getBooksByGenre(Genre genre) throws SQLException;
    public void deleteBook(Book book) throws SQLException;
}
