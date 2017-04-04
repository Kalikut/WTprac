package logic;

import java.util.Set;
import java.util.HashSet;

public class Cover {

    private long id;
    private String cover_view;
    private Set book = new HashSet();

    public Cover() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCover_view() {
        return cover_view;
    }

    public void setCover_view(String cover_view) {
        this.cover_view = cover_view;
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
