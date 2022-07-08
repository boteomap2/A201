package fa.training.A201.dao.impl;

import fa.training.A201.Config.HibernateConfig;
import fa.training.A201.dao.TypeDao;
import fa.training.A201.entities.Movie;
import fa.training.A201.entities.MovieType;
import fa.training.A201.entities.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TypeDaoImpl implements TypeDao {

    @Override
    public boolean save(Type type) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(type);
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
    public boolean edit(Type type) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(type);
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
    public boolean delete(Integer typeId) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Type type = session.get(Type.class, typeId);
            if (type != null) {
                session.delete(type);
                Iterator<MovieType> iterator = type.getMovies().iterator();
                while (iterator.hasNext()) {
                    MovieType movieType = iterator.next();
                    movieType.getMovie().getTypes().remove(movieType);
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
    public Type get(Integer typeId) {
        Transaction transaction = null;
        Type type = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            type = session.get(Type.class, typeId);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();

        }
        return type;
    }
}
