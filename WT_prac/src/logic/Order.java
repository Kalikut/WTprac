package logic;

import java.sql.Date;
import java.util.Set;
import java.util.HashSet;

public class Order {

    private long id;
    private long client_id;
    private Date order_date;
    private Date delivery_date;
    private String delivery_adress;
    private long delivery_cost;
    private long status_id;
    private long books_cost;
    private Set order_journal = new HashSet();

    public Order() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getClient_id() {
        return client_id;
    }

    public void setClient_id(long client_id) {
        this.client_id = client_id;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public Date getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(Date delivery_date) {
        this.delivery_date = delivery_date;
    }

    public String getDelivery_adress() {
        return delivery_adress;
    }

    public void setDelivery_adress(String delivery_adress) {
        this.delivery_adress = delivery_adress;
    }

    public long getDelivery_cost() {
        return delivery_cost;
    }

    public void setDelivery_cost(long delivery_cost) {
        this.delivery_cost = delivery_cost;
    }

    public long getStatus_id() {
        return status_id;
    }

    public void setStatus_id(long status_id) {
        this.status_id = status_id;
    }

    public long getBooks_cost() {
        return books_cost;
    }

    public void setBooks_cost(long books_cost) {
        this.books_cost = books_cost;
    }

    public Set getOrder_journal() {
        return order_journal;
    }

    public void setOrder_journal(Set order_journal) {
        this.order_journal = order_journal;
    }

    public void addOrder_journal(OrderJournal order_journal) {
        this.order_journal.add(order_journal);
    }

    public void removeOrder_journal(OrderJournal order_journal) {
        this.order_journal.remove(order_journal);
    }

}
