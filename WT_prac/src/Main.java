import logic.*;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws SQLException {

        //OrderJournal order_journal = Factory.getInstance().getOrderJournalDAO().getOrderJournalById(1);
        //Factory.getInstance().getOrderJournalDAO().deleteOrderJournal(order_journal);

        //Book book = Factory.getInstance().getBookDAO().getBookById(1);
        //Factory.getInstance().getBookDAO().deleteBook(book);

        //Order order = Factory.getInstance().getOrderDAO().getOrderById(1);
        //Factory.getInstance().getOrderDAO().deleteOrder(order);
        Client client = Factory.getInstance().getClientDAO().getClientById(1);
        Factory.getInstance().getClientDAO().deleteClient(client);
/*
        Book book = Factory.getInstance().getBookDAO().getBookById(1);
        Author author = Factory.getInstance().getAuthorDAO().getAuthorById(3);
        //author.addBook(book);
        //Factory.getInstance().getAuthorDAO().updateAuthor(author.getId(), author);
        Collection authors = Factory.getInstance().getAuthorDAO().getAuthorsByBook(book);
        Iterator iterator = authors.iterator();
        System.out.println("========Все книги=========");
        while (iterator.hasNext()) {
            Author cur_author = (Author) iterator.next();
            System.out.println("Id : " + cur_author.getId());
        }
*/
        //author.addBook(book);

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
