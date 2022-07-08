package fa.training.A201;

import fa.training.A201.Config.HibernateConfig;
import fa.training.A201.dao.MovieDao;
import fa.training.A201.dao.MovieTypeDao;
import fa.training.A201.dao.impl.MovieDaoImpl;
import fa.training.A201.entities.Movie;
import fa.training.A201.entities.MovieType;
import fa.training.A201.entities.MovieTypePk;
import fa.training.A201.entities.Type;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {

    public static void main(String[] args) {
        Session session = HibernateConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();





        // get all types
//      typeDao.findAll().forEach(t -> {
//          System.out.println(t);
//      });
        // get type by id
//      System.out.println(typeDao.findById(1).getMovieTypes());
        // update type by id
//      Type type = typeDao.findById(5);
//      type.setTypeDescription("updated");
//      typeDao.save(type);
        // delete type and its relative
//      typeDao.delete(1);
/**
 * Movie and MovieType CRUD is below (checked)
 */
//        MovieDao movieDao = new MovieDaoImpl();
        // add new movie
//      Movie movie = new Movie();
//        movie.setMovieId("movie00004");
//        movie.setActor("Tom Holand");
//        movie.setContent("spriderman lost everything");
//        movie.setDirector("Ninh Hoang");
//        movie.setDuration(new BigDecimal(2.5));
//        movie.setFromDate(DateUtils.convertStringToUtilDate("05/01/2022"));
//        movie.setToDate(DateUtils.convertStringToUtilDate("07/01/2022"));
//        movie.setMovieProductionCompany("Marvel");
//        movie.setVersion("vietsub");
//        movie.setMovieNameEng("this is a test record");
//        movie.setMovieNameVn("cai nay de thu thoi");
//        movie.setLargeImage("this is url to large image");
//        movie.setSmallImage("this is url to small image");
//        movieDao.save(movie);
        // add types to the movie
//        movieTypeDao.save(new MovieType(new MovieTypeKey(movieDao.findById("movie00004"), typeDao.findById(4)),"description movie00004"));
//        movieTypeDao.save(new MovieType(new MovieTypeKey(movieDao.findById("movie00004"), typeDao.findById(2)), "description movie00004"));
//        movieTypeDao.save(new MovieType(new MovieTypeKey(movieDao.findById("movie00004"), typeDao.findById(3)), "description movie00004"));
        // this is another way to add type to the movie
//      MovieType movieType = new MovieType();
//      MovieTypeKey key = new MovieTypeKey();
//      key.setMovie(movieDao.findById("movie00002"));
//      key.setType(typeDao.findById(1));
//      movieType.setMovieTypeKey(key);
//      movieType.setMTDescription("description movie00002");
//      movieTypeDao.save(movieType);
        // get movie by id
//      Movie movie = movieDao.findById("movie00004");
//      System.out.println(movie.getMovieTypes());
        // get all movies without type
//      movieDao.findAll().forEach(m -> {
//          System.out.println(m.getMovieTypes());
//      });
        // delete movie by id and its relative
//      movieDao.delete("movie00003");


        transaction.commit();
        session.close();
    }
}