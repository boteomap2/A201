package fa.training.A201.entities;

import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MovieTypePK implements Serializable {

    private static final long serialVersionUID = 2057177818188253536L;
    @ManyToOne
    @JoinColumn(name = "MOVIE_ID")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "TYPE_ID")
    private Type type;

    public MovieTypePK() {
    }

    public MovieTypePK(Movie movie, Type type) {
        this.movie = movie;
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        MovieTypePK that = (MovieTypePK) o;
        return movie != null && Objects.equals(movie, that.movie)
                && type != null && Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movie, type);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "movie = " + movie + ", " +
                "type = " + type + ")";
    }
}



