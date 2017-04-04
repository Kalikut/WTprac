package logic;

import java.util.Set;
import java.util.HashSet;

public class Status {

    private long id;
    private String status;
    private Set order = new HashSet();

    public Status() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set getOrder() {
        return order;
    }

    public void setOrder(Set order) {
        this.order = order;
    }

    public void addOrder(Order order) {
        this.order.add(order);
    }

    public void removeOrder(Order order) {
        this.order.remove(order);
    }

}
