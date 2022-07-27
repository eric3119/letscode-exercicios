package org.example.models;

import java.util.List;

public class Filme {
    private String rank;
    private String title;
    private String genre;
    private String description;
    private String director;
    private String actors;
    private String year;
    private String runtime;
    private String rating;
    private String votes;
    private String revenue;
    private String metascore;

    @Override
    public int hashCode() {
        return this.getTitle().hashCode() + this.getDirector().hashCode() + this.getYear().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Filme)) return false;
        Filme f = (Filme) obj;
        return f.getTitle().compareTo(this.getTitle()) == 0 &&
                f.getDirector().compareTo(this.getDirector()) == 0 &&
                f.getYear().compareTo(this.getYear()) == 0;
    }

    public static Filme of(List<String> dados) {
        return new Filme()
                .setRank(dados.get(0))
                .setTitle(dados.get(1))
                .setGenre(dados.get(2))
                .setDescription(dados.get(3))
                .setDirector(dados.get(4))
                .setActors(dados.get(5))
                .setYear(dados.get(6))
                .setRuntime(dados.get(7))
                .setRating(dados.get(8))
                .setVotes(dados.get(9))
                .setRevenue(dados.get(10))
                .setMetascore(dados.get(11));
    }

    public String getRank() {
        return rank;
    }

    public Filme setRank(String rank) {
        this.rank = rank;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Filme setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getGenre() {
        return genre;
    }

    public Filme setGenre(String genre) {
        this.genre = genre;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Filme setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getDirector() {
        return director;
    }

    public Filme setDirector(String director) {
        this.director = director;
        return this;
    }

    public String getActors() {
        return actors;
    }

    public Filme setActors(String actors) {
        this.actors = actors;
        return this;
    }

    public String getYear() {
        return year;
    }

    public Filme setYear(String year) {
        this.year = year;
        return this;
    }

    public String getRuntime() {
        return runtime;
    }

    public Filme setRuntime(String runtime) {
        this.runtime = runtime;
        return this;
    }

    public String getRating() {
        return rating;
    }

    public Filme setRating(String rating) {
        this.rating = rating;
        return this;
    }

    public String getVotes() {
        return votes;
    }

    public Filme setVotes(String votes) {
        this.votes = votes;
        return this;
    }

    public String getRevenue() {
        return revenue;
    }

    public Filme setRevenue(String revenue) {
        this.revenue = revenue;
        return this;
    }

    public String getMetascore() {
        return metascore;
    }

    public Filme setMetascore(String metascore) {
        this.metascore = metascore;
        return this;
    }

    @Override
    public String toString() {
        return "Filme [actors=" + actors + ", description=" + description + ", director=" + director + ", genre="
                + genre + ", metascore=" + metascore + ", rank=" + rank + ", rating=" + rating + ", revenue=" + revenue
                + ", runtime=" + runtime + ", title=" + title + ", votes=" + votes + ", year=" + year + "]";
    }

    
}
