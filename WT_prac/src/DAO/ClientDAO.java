package DAO;

import logic.Client;

import java.util.Collection;
import java.sql.SQLException;

public interface ClientDAO {
    public void addClient(Client client) throws SQLException;
    public void updateClient(long id_client, Client client) throws SQLException;
    public Client getClientById(long id_client) throws SQLException;
    public Client getClientByEmail(String e_mail) throws SQLException;
    public Collection getAllClients() throws SQLException;
    public void deleteClient(Client client) throws SQLException;
}
