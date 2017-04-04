package DAO;

import logic.Author;
import logic.Book;

import java.util.Collection;
import java.sql.SQLException;

public interface AuthorDAO {
    public void addAuthor(Author author) throws SQLException;
    public void updateAuthor(long id_author, Author author) throws SQLException;
    public Author getAuthorById(long id_author) throws SQLException;
    public Collection getAuthorsByName(String author_name) throws SQLException;
    public Collection getAllAuthors() throws SQLException;
    public Collection getAuthorsByBook(Book book) throws SQLException;
    public void deleteAuthor(Author author) throws SQLException;
}