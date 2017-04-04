package DAO;

import logic.Genre;

import java.util.Collection;
import java.sql.SQLException;

public interface GenreDAO {
    public Genre getGenreById(long id_genre) throws SQLException;
    public Collection getAllGenres() throws SQLException;
    public void updateGenre(long id_genre, Genre genre) throws SQLException;
    public void addGenre(Genre author) throws SQLException;
    public void deleteGenre(Genre author) throws SQLException;
}
