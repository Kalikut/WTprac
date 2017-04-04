package DAO;

import logic.Cover;

import java.util.Collection;
import java.sql.SQLException;

public interface CoverDAO {
    public Cover getCoverById(long id_cover) throws SQLException;
    public Collection getAllCovers() throws SQLException;
    public void updateCover(long id_cover, Cover cover) throws SQLException;
    public void addCover(Cover cover) throws SQLException;
    public void deleteCover(Cover cover) throws SQLException;
}
