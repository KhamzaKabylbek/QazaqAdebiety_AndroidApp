package com.example.qazaqadebiety.model;

import java.util.List;

public class Author {
    private String name;
    private String nameKazakh;
    private String biography;
    private String birthYear;
    private String deathYear;
    private String imageUrl;
    private List<String> famousWorks;
    private List<String> quotes;

    public Author(String name, String nameKazakh, String biography, String birthYear, 
                  String deathYear, String imageUrl, List<String> famousWorks, List<String> quotes) {
        this.name = name;
        this.nameKazakh = nameKazakh;
        this.biography = biography;
        this.birthYear = birthYear;
        this.deathYear = deathYear;
        this.imageUrl = imageUrl;
        this.famousWorks = famousWorks;
        this.quotes = quotes;
    }

    // Getters
    public String getName() { return name; }
    public String getNameKazakh() { return nameKazakh; }
    public String getBiography() { return biography; }
    public String getBirthYear() { return birthYear; }
    public String getDeathYear() { return deathYear; }
    public String getImageUrl() { return imageUrl; }
    public List<String> getFamousWorks() { return famousWorks; }
    public List<String> getQuotes() { return quotes; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setNameKazakh(String nameKazakh) { this.nameKazakh = nameKazakh; }
    public void setBiography(String biography) { this.biography = biography; }
    public void setBirthYear(String birthYear) { this.birthYear = birthYear; }
    public void setDeathYear(String deathYear) { this.deathYear = deathYear; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public void setFamousWorks(List<String> famousWorks) { this.famousWorks = famousWorks; }
    public void setQuotes(List<String> quotes) { this.quotes = quotes; }

    public String getLifeYears() {
        if (deathYear != null && !deathYear.isEmpty()) {
            return birthYear + " - " + deathYear;
        }
        return birthYear + " - наши дни";
    }
} 