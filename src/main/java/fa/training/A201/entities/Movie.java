package fa.training.A201.entities;


import org.hibernate.Hibernate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "MOVIE")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MOVIE_ID", nullable = false)
    private Integer id;

    @Column(name = "ACTOR")
    private String actor;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "DIRECTOR")
    private String director;

    @Column(name = "DURATION", columnDefinition = "decimal", scale = 2, precision = 5)
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
