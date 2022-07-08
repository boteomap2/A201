package fa.training.A201.dao;

import fa.training.A201.entities.Type;
import java.util.List;

public interface TypeDao {
    boolean save(Type type);

    boolean edit(Type type);

    boolean delete(Integer typeId);

    Type get(Integer typeId);

}
