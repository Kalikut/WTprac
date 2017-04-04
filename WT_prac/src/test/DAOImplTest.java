package test;

import DAO.*;
import DAOImpl.*;
import logic.*;
import org.joda.time.DateTime;
import org.joda.time.DateTimeComparator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.sql.Date;
import java.util.Collection;
import java.util.Iterator;

public class DAOImplTest {

    @Test(dataProvider = "adminTestData")
    public void adminTest(String s1, String s2, boolean err) throws SQLException {

        AdminDAO adm = new AdminDAOImpl();

        Admin tmp = null;
        tmp = adm.getAdminByLogin(s1);

        if (err) {
            Assert.assertNotNull(tmp);
            Assert.assertEquals(tmp.getLogin(), s1);
            Assert.assertEquals(tmp.getPassword(), s2);
        } else {
            Assert.assertNull(tmp);
        }

    }

    @DataProvider
    public Object[][] adminTestData() {
        return new Object[][] {
                new Object[] { "NedashkovskayaDomna264", "WEgRQ38Bt0Qm", true },
                new Object[] { "TEST1", "TEST2", false }
        };
    }

    @Test(dataProvider = "statusTestData")
    public void statusTest(long l1, String s1, boolean err) throws SQLException {

        StatusDAO st = new StatusDAOImpl();

        Integer rows = null;
        rows = st.getAllStatuses().size();

        Assert.assertNotNull(rows);

        Status tmp = null;
        tmp = st.getStatusById(l1);

        if (err) {
            Assert.assertNotNull(tmp);
            Assert.assertEquals(tmp.getStatus(), s1);
        } else {
            Assert.assertNull(tmp);
        }

    }

    @DataProvider
    public Object[][] statusTestData() {
        return new Object[][] {
                new Object[] { 1, "Waiting for confirmation.", true },
                new Object[] { 2, "Formation of the order.", true },
                new Object[] { 3, "Transferred to the delivery service.", true },
                new Object[] { 4, "Delivered.", true },
                new Object[] { 5, "TEST", false }
        };
    }

    @Test(dataProvider = "coverTestData")
    public void coverTest(long l1, String s1, boolean err) throws SQLException {

        CoverDAO cv = new CoverDAOImpl();

        Integer rows = null;
        rows = cv.getAllCovers().size();

        Assert.assertNotNull(rows);

        Cover tmp = null;
        tmp = cv.getCoverById(l1);

        if (err) {
            Assert.assertNotNull(tmp);
            Assert.assertEquals(tmp.getCover_view(), s1);
        } else {
            Assert.assertNull(tmp);
        }

    }

    @DataProvider
    public Object[][] coverTestData() {
        return new Object[][] {
                new Object[] { 1, "Soft", true },
                new Object[] { 2, "Hard", true },
                new Object[] { 3, "TEST", false }
        };
    }

    @Test(dataProvider = "genreTestData")
    public void genreTest(long l1, String s1, boolean err) throws SQLException {

        GenreDAO gn = new GenreDAOImpl();

        Integer rows = null;
        rows = gn.getAllGenres().size();

        Assert.assertNotNull(rows);

        Genre tmp = null;
        tmp = gn.getGenreById(l1);

        if (err) {
            Assert.assertNotNull(tmp);
            Assert.assertEquals(tmp.getGenre_name(), s1);
        } else {
            Assert.assertNull(tmp);
        }

    }

    @DataProvider
    public Object[][] genreTestData() {
        return new Object[][] {
                new Object[] { 1, "Fantastic novel", true },
                new Object[] { 2, "Science fiction novel", true },
                new Object[] { 3, "Romance epic", true },
                new Object[] { 4, "TEST", false }
        };
    }

    @Test(dataProvider = "clientTestData")
    public void clientTest(String s1, String s2, String s3,
                           String adr, String phone, String mail, String pswd) throws SQLException {

        ClientDAO cn = new ClientDAOImpl();

        Integer rows = null;
        rows = cn.getAllClients().size();

        Assert.assertNotNull(rows);

        Client client = new Client();
        client.setFirst_name(s1);
        client.setMiddle_name(s2);
        client.setLast_name(s3);
        client.setAdress(adr);
        client.setPhone_number(phone);
        client.setE_mail(mail);
        client.setPassword(pswd);
        cn.addClient(client);

        client = cn.getClientByEmail(mail);

        Assert.assertNotNull(client);
        Assert.assertEquals(client.getFirst_name(), s1);
        Assert.assertEquals(client.getMiddle_name(), s2);
        Assert.assertEquals(client.getLast_name(), s3);
        Assert.assertEquals(client.getAdress(), adr);
        Assert.assertEquals(client.getPhone_number(), phone);
        Assert.assertEquals(client.getE_mail(), mail);
        Assert.assertEquals(client.getPassword(), pswd);

        long id = client.getId();
        client.setE_mail("MAIL");
        cn.updateClient(id, client);

        client = cn.getClientById(id);

        Assert.assertNotNull(client);
        Assert.assertEquals(client.getE_mail(), "MAIL");

        cn.deleteClient(client);

        client = cn.getClientById(id);

        Assert.assertNull(client);

    }

    @DataProvider
    public Object[][] clientTestData() {
        return new Object[][] {
                new Object[] { "TEST", "TEST", "TEST", "TEST", "TEST", "TEST", "TEST" }
        };
    }

    @Test(dataProvider = "authorTestData")
    public void authorTest(String s1) throws SQLException {

        AuthorDAO aut = new AuthorDAOImpl();

        Integer rows = null;
        rows = aut.getAllAuthors().size();

        Assert.assertNotNull(rows);

        Author author = new Author();
        author.setName(s1);
        aut.addAuthor(author);
        Collection authors = aut.getAuthorsByName(s1);
        Iterator iterator = authors.iterator();
        author = (Author) iterator.next();

        Assert.assertNotNull(author);
        Assert.assertEquals(author.getName(), s1);

        long id = author.getId();
        author.setName("UPDATE");
        aut.updateAuthor(id, author);

        author = aut.getAuthorById(id);

        Assert.assertNotNull(author);
        Assert.assertEquals(author.getName(), "UPDATE");

        aut.deleteAuthor(author);

        author = aut.getAuthorById(id);

        Assert.assertNull(author);

        BookDAO boo = new BookDAOImpl();
        Book book = boo.getBookById(1);
        authors = aut.getAuthorsByBook(book);
        iterator = authors.iterator();

        while (iterator.hasNext()) {
            Author cur_author = (Author) iterator.next();
            //System.out.print(author.getName() + "\t");
        }
        //System.out.println("\nExpected:\nA. Strugatsky\tB. Strugatsky");

    }

    @DataProvider
    public Object[][] authorTestData() {
        return new Object[][] {
                new Object[] { "Dominic"}
        };
    }

    @Test(dataProvider = "orderTestData")
    public void orderTest() throws SQLException {

        OrderDAO ord = new OrderDAOImpl();

        Integer rows = null;
        rows = ord.getAllOrders().size();

        Assert.assertNotNull(rows);

        Order order = new Order();
        order.setClient_id(1);
        order.setStatus_id(1);
        order.setBooks_cost(0);
        order.setDelivery_cost(0);
        order.setDelivery_adress("TEST");
        order.setOrder_date(new Date(117,03,10));
        order.setDelivery_date(new Date(117,03,15));
        ord.addOrder(order);

        order = ord.getOrderById(4);
        Assert.assertNotNull(rows);
        order.setStatus_id(2);
        ord.updateOrder(4, order);

        order = ord.getOrderById(4);
        Assert.assertNotNull(rows);
        Assert.assertEquals(order.getStatus_id(), 2);

        ord.deleteOrder(order);

        order = ord.getOrderById(4);

        Assert.assertNull(order);

        ClientDAO cl = new ClientDAOImpl();
        Client client = cl.getClientById(1);
        Collection orders = ord.getOrdersByClient(client);
        Iterator iterator = orders.iterator();

        while (iterator.hasNext()) {
            Order cur_order = (Order) iterator.next();
            //System.out.println("Id: " + order.getId() + "\tBooks cost: " + order.getBooks_cost());
        }
        //System.out.println("\nExpected:\nId: 1\tBooks cost: 450\nId: 2\tBooks cost: 700");

    }

    @DataProvider
    public Object[][] orderTestData() {
        return new Object[][] {
                new Object[] {}
        };
    }

    @Test(dataProvider = "orderJournalTestData")
    public void orderJournalTest() throws SQLException {

        OrderJournalDAO oj = new OrderJournalDAOImpl();

        Integer rows = null;
        rows = oj.getAllOrderJournals().size();

        Assert.assertNotNull(rows);

        OrderJournal order_journal = new OrderJournal();
        order_journal.setAmount(2);
        order_journal.setBook_id(3);
        order_journal.setOrder_id(1);
        oj.addOrderJournal(order_journal);

        order_journal = oj.getOrderJournalById(6);
        Assert.assertNotNull(rows);
        order_journal.setAmount(3);
        oj.updateOrderJournal(order_journal.getId(), order_journal);

        order_journal = oj.getOrderJournalById(order_journal.getId());
        Assert.assertNotNull(rows);
        Assert.assertEquals(order_journal.getAmount(), 3);

        oj.deleteOrderJournal(order_journal);

        order_journal = oj.getOrderJournalById(6);

        Assert.assertNull(order_journal);

    }

    @DataProvider
    public Object[][] orderJournalTestData() {
        return new Object[][] {
                new Object[] {}
        };
    }

    @Test(dataProvider = "bookTestData")
    public void bookTest(String s1, String s2, String s3,
                         int l1, int l2, long l3, long l4, long l5) throws SQLException {

        GenreDAO gn = new GenreDAOImpl();
        Genre genre = new Genre();
        genre.setGenre_name(s2);
        gn.addGenre(genre);

        genre = gn.getGenreById(4);

        Assert.assertNotNull(genre);
        Assert.assertEquals(genre.getGenre_name(), s2);

        BookDAO bk = new BookDAOImpl();
        Book book = new Book();
        book.setTitle(s1);
        book.setGenre_id(genre.getId());
        book.setPublishing_house(s3);
        book.setPublishing_year(l1);
        book.setPages_number(l2);
        book.setCover_id(l3);
        book.setPrice(l4);
        book.setAmount(l5);
        bk.addBook(book);

        Collection books = bk.getBooksByTitle(s1);
        Iterator iterator = books.iterator();
        Book cur_book = (Book) iterator.next();

        Assert.assertNotNull(cur_book);
        Assert.assertEquals(cur_book.getId(), book.getId());

        Integer rows = null;
        rows = bk.getAllBooks().size();

        Assert.assertNotNull(rows);

        books = bk.getBooksByGenre(genre);
        iterator = books.iterator();
        cur_book = (Book) iterator.next();

        Assert.assertNotNull(cur_book);
        Assert.assertEquals(cur_book.getId(), book.getId());

        bk.deleteBook(book);
        cur_book = bk.getBookById(book.getId());

        Assert.assertNull(cur_book);

        gn.deleteGenre(genre);

    }

    @DataProvider
    public Object[][] bookTestData() {
        return new Object[][]{
                new Object[]{"The demons", "NOVEL", "TEST", 2014, 234, 2, 400, 2}
        };
    }

}
