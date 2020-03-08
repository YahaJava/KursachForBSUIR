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
/*
    private Director director;

    private List<Actor> actors;*/

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

    public Movie(String name, Director director, List<Actor> actors, String genre, String country, int year, String budget, String description, String posterURL, boolean inRent) {
        this.name = name;
       /* this.director = director;
        this.actors = actors;*/
        this.genre = genre;
        this.country = country;
        this.year = year;
        this.budget = budget;
        this.description = description;
        this.posterURL = posterURL;
        this.inRent = inRent;
    }

    public Movie() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

   /* public Director getDirector() {
        return director;
    }

    public List<Actor> getActors() {
        return actors;
    }*/

    public String getGenre() {
        return genre;
    }

    public String getCountry() {
        return country;
    }

    public int getYear() {
        return year;
    }

    public String getBudget() {
        return budget;
    }

    public String getDescription() {
        return description;
    }

    public String getPosterURL() {
        return posterURL;
    }

    public boolean isInRent() {
        return inRent;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

   /* public void setDirector(Director director) {
        this.director = director;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }*/

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPosterURL(String posterURL) {
        this.posterURL = posterURL;
    }

    public void setInRent(boolean inRent) {
        this.inRent = inRent;
    }
}
