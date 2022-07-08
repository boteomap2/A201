package fa.training.A201.entities;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "MOVIE_TYPE")
public class MovieType {
    @EmbeddedId
    private MovieTypePk movieTypePk;

    @ManyToOne
    @MapsId(value = "movieId")
    @JoinColumn(name = "MOVIE_ID", columnDefinition = "varchar(10)")
    private Movie movie;

    @ManyToOne
    @MapsId(value = "typeId")
    @JoinColumn(name = "TYPE_ID")
    private Type type;

    @Column(name = "MT_DESCRIPTION")
    private String mtDescription;

    public MovieType(Movie movie, Type type) {
        this.movie = movie;
        this.type = type;
        this.movieTypePk = new MovieTypePk(movie.getMovieId(), type.getTypeId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MovieType)) {
            return false;
        }
        MovieType movieType = (MovieType) o;
        return Objects.equals(movie, movieType.movie) && Objects.equals(type, movieType.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieTypePk);
    }
}