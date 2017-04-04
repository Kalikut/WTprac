package logic;

import java.util.Set;
import java.util.HashSet;

public class Client {

    private long id;
    private String first_name;
    private String middle_name;
    private String last_name;
    private String adress;
    private String phone_number;
    private String e_mail;
    private String password;
    private Set order = new HashSet();

    public Client() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        this.order.add(order);
    }

}
