package fa.training.A201.utils;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.jdbc.Work;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.atomic.AtomicReference;

public class MovieIdGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        String prefix = "MOVIE";
        AtomicReference<String> generatedId = new AtomicReference<>("");

        session.doWork(connection -> {
            try {

                Statement statement=connection.createStatement();

                ResultSet rs=statement.executeQuery("select max(MOVIE_ID) as Id from dbo.MOVIE");

                if(rs.next())
                {
                    String idString=rs.getString(1);
                    int id;
                    if (idString == null) {
                        id = 1;
                    } else {
                        id = Integer.parseInt(idString.substring(prefix.length())) + 1;
                    }

                    generatedId.set(String.format(prefix+"%05d", id));

                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
        return generatedId.get();
    }
}
