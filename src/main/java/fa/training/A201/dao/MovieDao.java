package fa.training.A201.dao;

import fa.training.A201.entities.Movie;
import java.util.List;

public interface MovieDao {
    boolean save(Movie movie);

    boolean edit(Movie movie);

    boolean delete(String movieId);

    Movie get(String movieId);

}
