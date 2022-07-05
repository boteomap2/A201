package fa.training.A201;

import fa.training.A201.Config.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        Session session = HibernateConfig.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();



        transaction.commit();

    }
}
