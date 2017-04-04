package logic;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Set;
import java.util.HashSet;

public class OrderJournal {

    private long id;
    private long order_id;
    private long book_id;
    private long amount;

    public OrderJournal() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order) {
        this.order_id = order;
    }

    public long getBook_id() {
        return book_id;
    }

    public void setBook_id(long book) {
        this.book_id = book;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

}
