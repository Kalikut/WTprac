package logic;

import java.util.Set;
import java.util.HashSet;

public class Genre {

    private long id;
    private String genre_name;
    private Set book = new HashSet();

    public Genre() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGenre_name() {
        return genre_name;
    }

    public void setGenre_name(String genre_name) {
        this.genre_name = genre_name;
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
