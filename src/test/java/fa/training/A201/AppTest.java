package fa.training.A201;

import static org.junit.Assert.assertTrue;

import fa.training.A201.Config.HibernateConfig;
import fa.training.A201.dao.MovieDao;
import fa.training.A201.dao.MovieTypeDao;
import fa.training.A201.dao.TypeDao;
import fa.training.A201.dao.impl.MovieDaoImpl;
import fa.training.A201.dao.impl.MovieTypeDaoImpl;
import fa.training.A201.dao.impl.TypeDaoImpl;
import fa.training.A201.entities.Movie;
import fa.training.A201.entities.MovieType;
import fa.training.A201.entities.MovieTypePk;
import fa.training.A201.entities.Type;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class AppTest {
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
    private Session session;

    @Before
    public void setup() {
        session = HibernateConfig.getSessionFactory().openSession();
    }

    @After
    public void tearDown() {
        session.close();
    }

    @Test
    public void saveData() {
        session.beginTransaction();
        MovieDao movieDao = new MovieDaoImpl();
        TypeDao typeDao = new TypeDaoImpl();
        MovieTypeDao movieTypeDao = new MovieTypeDaoImpl();
        Type type1 = new Type("Adventure", "Adventure movie type");
        Type type2 = new Type("Comedy", "Comedy movie type");
        Type type3 = new Type("Drama", "Drama movie type");
        Type type4 = new Type("Horror", "Horror movie type");
        Type type5 = new Type("Science fiction", "Science fiction movie type");

        typeDao.save(type1);
        typeDao.save(type2);
        typeDao.save(type3);
        typeDao.save(type4);
        typeDao.save(type5);

        Movie movie = new Movie();
        movie.setMovieId("movie00004");
        movie.setDirector("Tom Holand");
        movie.setContent("spriderman lost everything");
        movie.setDirector("Ha Huy");
        movie.setDuration(new BigDecimal(2.5));
        movie.setFromDate(LocalDate.parse("05/01/2022", formatter));
        movie.setFromDate(LocalDate.parse("07/01/2022", formatter));
        movie.setCompany("Marvel");
        movie.setVersion("vietsub");
        movie.setMovieNameEng("this is a test record");
        movie.setMovieNameVn("cai nay de thu thoi");
        movie.setLargeImg("this is url to large image");
        movie.setSmallImg("this is url to small image");
        movieDao.save(movie);

        session.getTransaction().commit();
    }

    @Test
    public void addTypeForMovie() {
        session.beginTransaction();
        MovieDao movieDao = new MovieDaoImpl();
        TypeDao typeDao = new TypeDaoImpl();
        MovieTypeDao movieTypeDao = new MovieTypeDaoImpl();

        Movie movie = movieDao.get("MOVIE00001");
        Type type1 = typeDao.get(1);
        Type type2 = typeDao.get(2);
        Type type3 = typeDao.get(3);

        MovieType movieType1 = new MovieType(movie, type1);
        MovieType movieType2 = new MovieType(movie, type2);
        MovieType movieType3 = new MovieType(movie, type3);

        movieType1.setMovie(movie);
        movieType1.setType(type1);

        movieType2.setMovie(movie);
        movieType2.setType(type2);

        movieType3.setMovie(movie);
        movieType3.setType(type3);

        movieTypeDao.save(movieType1);
        movieTypeDao.save(movieType2);
        movieTypeDao.save(movieType3);

        session.getTransaction().commit();
    }

    @Test
    public void updateData() {
        session.beginTransaction();
        MovieDao movieDao = new MovieDaoImpl();
        TypeDao typeDao = new TypeDaoImpl();
        MovieTypeDao movieTypeDao = new MovieTypeDaoImpl();

        Movie movie = movieDao.get("MOVIE00001");
        Type type1 = typeDao.get(1);
        MovieType movieType1 = movieTypeDao.get(new MovieTypePk(movie, type1));

        movieType1.setMtDescription("new des");
        movie.setContent("this is new content");
        movie.setDirector("bui doi cho lon");
        type1.setTypeDescription("this is new description");

        movieDao.edit(movie);
        typeDao.edit(type1);
        movieTypeDao.edit(movieType1);


        session.getTransaction().commit();
    }

    @Test
    public void deleteData() {
        session.beginTransaction();
        MovieDao movieDao = new MovieDaoImpl();
        TypeDao typeDao = new TypeDaoImpl();
        MovieTypeDao movieTypeDao = new MovieTypeDaoImpl();

        // detele 1 type cua movie
        Movie movie = movieDao.get("MOVIE00001");
        Type type3 = typeDao.get(3);

//        movieTypeDao.delete(new MovieTypePk(movie, type3));

//        movieDao.delete("MOVIE00001");

        typeDao.delete(3);



        session.getTransaction().commit();
    }

}
