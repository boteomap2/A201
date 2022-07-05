package fa.training.A201.entities;


import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "MOVIE")
public class Movie {
    @Id
    @GenericGenerator(name = "movie_id_gennerator", strategy = "fa.training.A201.utils.MovieIdGenerator")
    @GeneratedValue(generator = "movie_id_gennerator")
    @Column(name = "MOVIE_ID", length = 10)
    private String id;

    @Column(name = "ACTOR")
    private String actor;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "DIRECTOR")
    private String director;

    @Column(name = "DURATION", columnDefinition="Decimal(5,2)")
    private BigDecimal duration;

    @Column(name = "FROM_DATE", columnDefinition = "date")
    private LocalDate fromDate;

    @Column(name = "TO_DATE", columnDefinition = "date")
    private LocalDate toDate;

    @Column(name = "MOVIE_PRODUCTION_COMPANY")
    private String movieProductionCompany;

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

    @OneToMany(mappedBy = "id.movie")
    private List<MovieType> movieTypeList;

    public Movie() {
    }

    public Movie(String actor, String content, String director, BigDecimal duration, LocalDate fromDate,
                 LocalDate toDate,
                 String movieProductionCompany, String version, String movieNameEng, String movieNameVn,
                 String largeImg,
                 String smallImg) {
        this.actor = actor;
        this.content = content;
        this.director = director;
        this.duration = duration;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.movieProductionCompany = movieProductionCompany;
        this.version = version;
        this.movieNameEng = movieNameEng;
        this.movieNameVn = movieNameVn;
        this.largeImg = largeImg;
        this.smallImg = smallImg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public BigDecimal getDuration() {
        return duration;
    }

    public void setDuration(BigDecimal duration) {
        this.duration = duration;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public String getMovieProductionCompany() {
        return movieProductionCompany;
    }

    public void setMovieProductionCompany(String movieProductionCompany) {
        this.movieProductionCompany = movieProductionCompany;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getMovieNameEng() {
        return movieNameEng;
    }

    public void setMovieNameEng(String movieNameEng) {
        this.movieNameEng = movieNameEng;
    }

    public String getMovieNameVn() {
        return movieNameVn;
    }

    public void setMovieNameVn(String movieNameVn) {
        this.movieNameVn = movieNameVn;
    }

    public String getLargeImg() {
        return largeImg;
    }

    public void setLargeImg(String largeImg) {
        this.largeImg = largeImg;
    }

    public String getSmallImg() {
        return smallImg;
    }

    public void setSmallImg(String smallImg) {
        this.smallImg = smallImg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Movie movie = (Movie) o;
        return id != null && Objects.equals(id, movie.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "actor = " + actor + ", " +
                "content = " + content + ", " +
                "director = " + director + ", " +
                "duration = " + duration + ", " +
                "fromDate = " + fromDate + ", " +
                "toDate = " + toDate + ", " +
                "movieProductionCompany = " + movieProductionCompany + ", " +
                "version = " + version + ", " +
                "movieNameEng = " + movieNameEng + ", " +
                "movieNameVn = " + movieNameVn + ", " +
                "largeImg = " + largeImg + ", " +
                "smallImg = " + smallImg + ")";
    }


}
