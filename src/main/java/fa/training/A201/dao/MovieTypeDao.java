package fa.training.A201.dao;

import fa.training.A201.entities.Movie;
import fa.training.A201.entities.MovieType;
import fa.training.A201.entities.MovieTypePk;

public interface MovieTypeDao {

    boolean save(MovieType movieType);

    boolean edit(MovieType movieType);

    boolean delete(MovieTypePk movieTypePk);

    MovieType get(MovieTypePk movieTypePk);

}
