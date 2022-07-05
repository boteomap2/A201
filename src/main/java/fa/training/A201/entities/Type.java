package fa.training.A201.entities;

import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "TYPE")
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "TYPE_NAME")
    private String name;

    @Column(name = "TYPE_DESCRIPTON")
    private String description;

    @OneToMany(mappedBy = "id.type")
    private List<MovieType> movieTypes;

    public Type() {
    }

    public Type(String name, String description, List<MovieType> movieTypes) {
        this.name = name;
        this.description = description;
        this.movieTypes = movieTypes;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "description = " + description + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Type type = (Type) o;
        return id != null && Objects.equals(id, type.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
