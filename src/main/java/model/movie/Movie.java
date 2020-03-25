package model.movie;

import model.actor.Actor;
import model.director.Director;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "director_id")
    private Director director;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Actors_in_Movies",
            joinColumns = @JoinColumn(name ="id_movie"),
            inverseJoinColumns = @JoinColumn(name="id_actor"))
    private List<Actor> actors;

    @Column(name = "genre")
    private String genre;

    @Column(name = "country")
    private String country;

    @Column(name = "year")
    private int year;

    @Column(name = "budget")
    private String budget;

    @Column(name = "description")
    private String description;

    @Column(name = "poster")
    private String posterURL;

    @Column(name = "inRent")
    private boolean inRent;


    public Movie() {
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

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPosterURL() {
        return posterURL;
    }

    public void setPosterURL(String posterURL) {
        this.posterURL = posterURL;
    }

    public boolean isInRent() {
        return inRent;
    }

    public void setInRent(boolean inRent) {
        this.inRent = inRent;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }
}
