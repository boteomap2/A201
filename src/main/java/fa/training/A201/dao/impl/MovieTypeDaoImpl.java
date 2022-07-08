package fa.training.A201.dao.impl;

import fa.training.A201.Config.HibernateConfig;
import fa.training.A201.dao.MovieTypeDao;
import fa.training.A201.entities.MovieType;
import fa.training.A201.entities.MovieTypePk;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MovieTypeDaoImpl implements MovieTypeDao {

    @Override
    public boolean save(MovieType movieType) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(movieType);
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
    public boolean edit(MovieType movieType) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(movieType);
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
    public boolean delete(MovieTypePk movieTypePk) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            MovieType movieType = session.get(MovieType.class, movieTypePk);
            if (movieType != null) {
                session.delete(movieType);
                movieType.getMovie().getTypes().remove(movieType);
                movieType.getType().getMovies().remove(movieType);
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
    public MovieType get(MovieTypePk movieTypePk) {
        Transaction transaction = null;
        MovieType movieType = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            movieType = session.get(MovieType.class, movieTypePk);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return movieType;
    }
}
