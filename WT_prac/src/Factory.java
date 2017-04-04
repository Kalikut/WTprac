import DAO.*;
import DAOImpl.*;

public class Factory {

    private static AdminDAO adminDAO = null;
    private static AuthorDAO authorDAO = null;
    private static BookDAO bookDAO = null;
    private static ClientDAO clientDAO = null;
    private static CoverDAO coverDAO = null;
    private static GenreDAO genreDAO = null;
    private static OrderDAO orderDAO = null;
    private static OrderJournalDAO orderJournalDAO = null;
    private static StatusDAO statusDAO = null;
    private static Factory instance = null;

    public static synchronized Factory getInstance(){
        if (instance == null){
            instance = new Factory();
        }
        return instance;
    }

    public AdminDAO getAdminDAO(){
        if (adminDAO == null){
            adminDAO = new AdminDAOImpl();
        }
        return adminDAO;
    }

    public AuthorDAO getAuthorDAO(){
        if (authorDAO == null){
            authorDAO = new AuthorDAOImpl();
        }
        return authorDAO;
    }

    public BookDAO getBookDAO(){
        if (bookDAO == null){
            bookDAO = new BookDAOImpl();
        }
        return bookDAO;
    }

    public ClientDAO getClientDAO(){
        if (clientDAO == null){
            clientDAO = new ClientDAOImpl();
        }
        return clientDAO;
    }

    public CoverDAO getCoverDAO(){
        if (coverDAO == null){
            coverDAO = new CoverDAOImpl();
        }
        return coverDAO;
    }

    public GenreDAO getGenreDAO(){
        if (genreDAO == null){
            genreDAO = new GenreDAOImpl();
        }
        return genreDAO;
    }

    public OrderDAO getOrderDAO(){
        if (orderDAO == null){
            orderDAO = new OrderDAOImpl();
        }
        return orderDAO;
    }

    public OrderJournalDAO getOrderJournalDAO(){
        if (orderJournalDAO == null){
            orderJournalDAO = new OrderJournalDAOImpl();
        }
        return orderJournalDAO;
    }

    public StatusDAO getStatusDAO(){
        if (statusDAO == null){
            statusDAO = new StatusDAOImpl();
        }
        return statusDAO;
    }

}
