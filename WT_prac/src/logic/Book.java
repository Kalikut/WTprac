package logic;

import java.util.Set;
import java.util.HashSet;

public class Book {

    private long id;
    private String title;
    private long genre_id;
    private String publishing_house;
    private int publishing_year;
    private int pages_number;
    private long amount;
    private long price;
    private long cover_id;
    private Set order_journal = new HashSet();
    private Set author = new HashSet();

    public Book() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(long genre_id) {
        this.genre_id = genre_id;
    }

    public String getPublishing_house() {
        return publishing_house;
    }

    public void setPublishing_house(String publishing_house) {
        this.publishing_house = publishing_house;
    }

    public int getPublishing_year() {
        return publishing_year;
    }

    public void setPublishing_year(int publishing_year) {
        this.publishing_year = publishing_year;
    }

    public int getPages_number() {
        return pages_number;
    }

    public void setPages_number(int pages_number) {
        this.pages_number = pages_number;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getCover_id() {
        return cover_id;
    }

    public void setCover_id(long cover_id) {
        this.cover_id = cover_id;
    }

    public Set getOrder_journal() {
        return order_journal;
    }

    public void setOrder_journal(Set order_journal) {
        this.order_journal = order_journal;
    }

    public void addOrder_journal(OrderJournal orderJournal) {
        this.order_journal.add(orderJournal);
    }

    public void removeOrder_journal(OrderJournal orderJournal) {
        this.order_journal.remove(orderJournal);
    }

    public Set getAuthor() {
        return author;
    }

    public void setAuthor(Set author) {
        this.author = author;
    }

    public void addAuthor(Author author) {
        this.author.add(author);
    }

    public void removeAuthor(Author author) {
        this.author.remove(author);
    }

}
