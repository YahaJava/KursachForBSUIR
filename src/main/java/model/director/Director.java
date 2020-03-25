package model.director;

import model.movie.Movie;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Directors")
public class Director{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "career")
    private String career;

    @Column(name = "birthDate")
    private String birthDate;

    @Column(name = "birthPlace")
    private String birthPlace;

    @Column(name = "photo")
    private String photo;

    @OneToMany(mappedBy = "director", cascade = {CascadeType.DETACH, CascadeType.PERSIST,
            CascadeType.REFRESH}, fetch = FetchType.EAGER)
    private Set<Movie> movies;

    public Director() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

}
