package fa.training.A201.entities;

import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "MOVIE_TYPE")
public class MovieType {
    @EmbeddedId
    private MovieTypePK id;

    @Column(name = "MT_DESCRIPTION")
    private String mtDescription;

    public MovieType() {
    }

    public MovieType(MovieTypePK id, String mtDescription) {
        this.id = id;
        this.mtDescription = mtDescription;
    }

    public MovieTypePK getId() {
        return id;
    }

    public void setId(MovieTypePK id) {
        this.id = id;
    }

    public String getMtDescription() {
        return mtDescription;
    }

    public void setMtDescription(String mtDescription) {
        this.mtDescription = mtDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        MovieType movieType = (MovieType) o;
        return id != null && Objects.equals(id, movieType.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "EmbeddedId = " + id + ", " +
                "mtDescription = " + mtDescription + ")";
    }
}
