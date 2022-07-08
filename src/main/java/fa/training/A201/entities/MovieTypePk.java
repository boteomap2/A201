package fa.training.A201.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Embeddable
public class MovieTypePk implements Serializable {
    private String movieId;

    private Integer typeId;

    public MovieTypePk(Movie movie, Type type) {
        this(movie.getMovieId(), type.getTypeId());
    }
}