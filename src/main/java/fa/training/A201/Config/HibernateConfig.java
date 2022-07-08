package fa.training.A201.Config;


import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.reflections.Reflections;

import javax.persistence.Entity;
import java.util.Properties;
import java.util.Set;

public class HibernateConfig {
    private enum DB {
        DB_DRIVER("com.microsoft.sqlserver.jdbc.SQLServerDriver"),
        SERVER_ADDRESS("localhost"),
        DB_NAME("hibernateA201"),
        SERVER_PORT("1434"),
        DIALECT("org.hibernate.dialect.SQLServerDialect"),
        BASE_ENTITES_PACKAGE("fa.training.A201.entities");

        private final String value;

        DB(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    private HibernateConfig() {
    }

    public static final String URL = "jdbc:sqlserver://" + HibernateConfig.DB.SERVER_ADDRESS.getValue() + ":"
            + HibernateConfig.DB.SERVER_PORT.getValue() + ";database=" + HibernateConfig.DB.DB_NAME.getValue()
            + ";encrypt=true;trustServerCertificate=true;integratedSecurity=true;";

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration hibernateConfiguration = new Configuration();

                Properties hibernateProperties = new Properties();
                hibernateProperties.put(Environment.DRIVER, HibernateConfig.DB.DB_DRIVER.getValue());
                hibernateProperties.put(Environment.URL, URL);
                hibernateProperties.put(Environment.DIALECT, HibernateConfig.DB.DIALECT.getValue());
                hibernateProperties.put(Environment.SHOW_SQL, "true");
                hibernateProperties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                hibernateProperties.put(Environment.HBM2DDL_AUTO, "update");
                hibernateProperties.put(Environment.C3P0_MIN_SIZE, "5");
                hibernateProperties.put(Environment.C3P0_MAX_SIZE, "20");
                hibernateProperties.put(Environment.C3P0_TIMEOUT, "300");
                hibernateProperties.put(Environment.C3P0_MAX_STATEMENTS, "50");
                hibernateProperties.put(Environment.C3P0_IDLE_TEST_PERIOD, "3000");

                hibernateConfiguration.setProperties(hibernateProperties);

                Set<Class<?>> classes = new Reflections(HibernateConfig.DB.BASE_ENTITES_PACKAGE.getValue())
                        .getTypesAnnotatedWith(Entity.class);

                if (classes.isEmpty()) {
                    System.out.println("Fail to scan Entities.");
                    return null;
                }

                for (Class<?> class1 : classes) {
                    hibernateConfiguration.addAnnotatedClass(class1);
                }

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(hibernateConfiguration.getProperties()).build();

                sessionFactory = hibernateConfiguration.buildSessionFactory(serviceRegistry);

                if (sessionFactory != null) {
                    System.out.println("Create Session factory successfully.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
