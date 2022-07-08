package fa.training.A201.dao.impl;

import fa.training.A201.Config.HibernateConfig;
import fa.training.A201.dao.MovieDao;
import fa.training.A201.entities.Movie;
import fa.training.A201.entities.MovieType;
import fa.training.A201.entities.Type;
import java.util.Iterator;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MovieDaoImpl implements MovieDao {

    @Override
    public boolean save(Movie movie) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(movie);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean edit(Movie movie) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(movie);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(String movieId) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Movie movie = session.get(Movie.class, movieId);
            if (movie != null) {
                session.delete(movie);
                Iterator<MovieType> iterator = movie.getTypes().iterator();
                while (iterator.hasNext()) {
                    MovieType movieType = iterator.next();
                    movieType.getType().getMovies().remove(movieType);
                }
            }

            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Movie get(String movieId) {
        Transaction transaction = null;
        Movie movie = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            movie = session.get(Movie.class, movieId);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();

        }
        return movie;
    }
}
