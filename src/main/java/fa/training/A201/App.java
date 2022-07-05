package fa.training.A201;

import fa.training.A201.Config.HibernateConfig;
import fa.training.A201.entities.Movie;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        Session session = HibernateConfig.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Movie movie = new Movie("asva", "asd", "asd", BigDecimal.valueOf(10.2), LocalDate.now(), LocalDate.now(), "a",
                "a", "a", "a", "a", "a");
        Movie movie2 = new Movie("asva", "asd", "asd", BigDecimal.valueOf(10.2), LocalDate.now(), LocalDate.now(), "a",
                "a", "a", "a", "a", "a");
        session.save(movie);
//        session.save(movie2);

        transaction.commit();

    }
}
