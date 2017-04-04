package logic;

import java.util.Set;
import java.util.HashSet;

public class Author {

    private long id;
    private String name;
    private Set book = new HashSet();

    public Author() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set getBook() {
        return book;
    }

    public void setBook(Set book) {
        this.book = book;
    }

    public void addBook(Book book) {
        this.book.add(book);
    }

    public void removeBook(Book book) {
        this.book.remove(book);
    }

}
