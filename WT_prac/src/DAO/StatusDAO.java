package DAO;

import logic.Status;

import java.util.Collection;
import java.sql.SQLException;

public interface StatusDAO {
    public Status getStatusById(long id_status) throws SQLException;
    public Collection getAllStatuses() throws SQLException;
    public void updateStatus(long id_status, Status status) throws SQLException;
}
