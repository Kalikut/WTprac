package DAO;

import logic.Admin;

import java.sql.SQLException;

public interface AdminDAO {
    public Admin getAdminByLogin(String login) throws SQLException;
}
