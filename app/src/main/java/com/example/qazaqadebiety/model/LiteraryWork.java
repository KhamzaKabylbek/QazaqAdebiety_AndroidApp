package com.example.qazaqadebiety.model;

public class LiteraryWork {
    private String title;
    private String titleKazakh;
    private String author;
    private String genre;
    private String year;
    private String description;
    private String summary;
    private boolean isClassic;

    public LiteraryWork(String title, String titleKazakh, String author, String genre, 
                       String year, String description, String summary, boolean isClassic) {
        this.title = title;
        this.titleKazakh = titleKazakh;
        this.author = author;
        this.genre = genre;
        this.year = year;
        this.description = description;
        this.summary = summary;
        this.isClassic = isClassic;
    }

    // Getters
    public String getTitle() { return title; }
    public String getTitleKazakh() { return titleKazakh; }
    public String getAuthor() { return author; }
    public String getGenre() { return genre; }
    public String getYear() { return year; }
    public String getDescription() { return description; }
    public String getSummary() { return summary; }
    public boolean isClassic() { return isClassic; }

    // Setters
    public void setTitle(String title) { this.title = title; }
    public void setTitleKazakh(String titleKazakh) { this.titleKazakh = titleKazakh; }
    public void setAuthor(String author) { this.author = author; }
    public void setGenre(String genre) { this.genre = genre; }
    public void setYear(String year) { this.year = year; }
    public void setDescription(String description) { this.description = description; }
    public void setSummary(String summary) { this.summary = summary; }
    public void setClassic(boolean classic) { isClassic = classic; }
} 