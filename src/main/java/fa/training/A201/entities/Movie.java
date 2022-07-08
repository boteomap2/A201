package fa.training.A201.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.bytebuddy.description.type.TypeList;
import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@ToString
@Entity
@Table(name = "MOVIE")
public class Movie {
    @Id
    @GenericGenerator(name = "movieIdGenerator", strategy = "fa.training.A201.utils.MovieIdGenerator")
    @GeneratedValue(generator = "movieIdGenerator")
    @Column(name = "MOVIE_ID", length = 10)
    private String movieId;

    @Column(name = "CONTENT", length = 1000)
    private String content;

    @Column(name = "DIRECTOR")
    private String director;

    @Column(name = "DURATION", columnDefinition = "decimal(5, 2)")
    private BigDecimal duration;

    @Column(name = "FROM_DATE", columnDefinition = "date")
    private LocalDate fromDate;

    @Column(name = "TO_DATE", columnDefinition = "date")
    private LocalDate toDate;

    @Column(name = "COMPANY")
    private String company;

    @Column(name = "VERSION")
    private String version;

    @Column(name = "MOVIE_NAME_ENG")
    private String movieNameEng;

    @Column(name = "MOVIE_NAME_VN")
    private String movieNameVn;

    @Column(name = "LARGE_IMG")
    private String largeImg;

    @Column(name = "SMALL_IMG")
    private String smallImg;

    @ToString.Exclude
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "movie", fetch = FetchType.EAGER)
    private Set<MovieType> types = new HashSet<>();

    public Movie() {
    }

    public Movie(String content, String director, BigDecimal duration, LocalDate fromDate,
                 LocalDate toDate, String company, String version, String movieNameEng,
                 String movieNameVn, String largeImg, String smallImg) {
        this.content = content;
        this.director = director;
        this.duration = duration;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.company = company;
        this.version = version;
        this.movieNameEng = movieNameEng;
        this.movieNameVn = movieNameVn;
        this.largeImg = largeImg;
        this.smallImg = smallImg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        Movie movie = (Movie) o;
        return movieId != null && Objects.equals(movieId, movie.movieId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

//    public void addType(Type type) {
//        if (typeList == null) {
//            typeList = new ArrayList<>();
//        }
//        MovieType movieType = new MovieType(this, type);
//        if (!typeList.contains(movieType)) {
//            typeList.add(movieType);
//            type.getMovieList().add(movieType);
//        }
//    }

//    public void removeType(Type type) {
//        if (typeList == null || typeList.size() == 0) {
//            return;
//        }
//        Iterator<MovieType> iterator = typeList.iterator();
//        while (iterator.hasNext()) {
//            MovieType movieType = iterator.next();
//
//            if (movieType.getType().equals(type) &&
//                movieType.getMovie().equals(this))
//            {
//                iterator.remove();
//                movieType.getType().getMovieList().remove(movieType);
//                movieType.setMovie(null);
//                movieType.setType(null);
//            }
//        }
//
//    }
}