import logic.*;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) throws SQLException {

        //OrderJournal order_journal = Factory.getInstance().getOrderJournalDAO().getOrderJournalById(1);
        //Factory.getInstance().getOrderJournalDAO().deleteOrderJournal(order_journal);

        //Book book = Factory.getInstance().getBookDAO().getBookById(1);
        //Factory.getInstance().getBookDAO().deleteBook(book);

        //Order order = Factory.getInstance().getOrderDAO().getOrderById(1);
        //Factory.getInstance().getOrderDAO().deleteOrder(order);
        /*
        Collection clients = Factory.getInstance().getOrderJournalDAO().getAllOrderJournals();
        Iterator iterator = clients.iterator();
        System.out.println("========Все клиенты=========");
        while (iterator.hasNext()) {
            OrderJournal order_journal = (OrderJournal) iterator.next();
            System.out.println("Id : " + order_journal.getId() + "\tamount : " + order_journal.getAmount());
        }
        */
    }
}
