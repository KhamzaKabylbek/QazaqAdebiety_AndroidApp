package com.example.qazaqadebiety.model;

import java.io.Serializable;

public class Book implements Serializable {
    private String id;
    private String title;
    private String titleKazakh;
    private String author;
    private String description;
    private String coverImageUrl;
    private String pdfPath;
    private String audioPath;
    private BookType type;
    private String duration; // для аудиокниг
    private int pages; // для PDF книг
    private String genre;
    private String publishYear;

    public enum BookType {
        PDF, AUDIO, BOTH
    }

    public Book(String id, String title, String titleKazakh, String author, 
                String description, String coverImageUrl, String pdfPath, 
                String audioPath, BookType type, String duration, int pages, 
                String genre, String publishYear) {
        this.id = id;
        this.title = title;
        this.titleKazakh = titleKazakh;
        this.author = author;
        this.description = description;
        this.coverImageUrl = coverImageUrl;
        this.pdfPath = pdfPath;
        this.audioPath = audioPath;
        this.type = type;
        this.duration = duration;
        this.pages = pages;
        this.genre = genre;
        this.publishYear = publishYear;
    }

    // Getters
    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getTitleKazakh() { return titleKazakh; }
    public String getAuthor() { return author; }
    public String getDescription() { return description; }
    public String getCoverImageUrl() { return coverImageUrl; }
    public String getPdfPath() { return pdfPath; }
    public String getAudioPath() { return audioPath; }
    public BookType getType() { return type; }
    public String getDuration() { return duration; }
    public int getPages() { return pages; }
    public String getGenre() { return genre; }
    public String getPublishYear() { return publishYear; }

    // Setters
    public void setId(String id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setTitleKazakh(String titleKazakh) { this.titleKazakh = titleKazakh; }
    public void setAuthor(String author) { this.author = author; }
    public void setDescription(String description) { this.description = description; }
    public void setCoverImageUrl(String coverImageUrl) { this.coverImageUrl = coverImageUrl; }
    public void setPdfPath(String pdfPath) { this.pdfPath = pdfPath; }
    public void setAudioPath(String audioPath) { this.audioPath = audioPath; }
    public void setType(BookType type) { this.type = type; }
    public void setDuration(String duration) { this.duration = duration; }
    public void setPages(int pages) { this.pages = pages; }
    public void setGenre(String genre) { this.genre = genre; }
    public void setPublishYear(String publishYear) { this.publishYear = publishYear; }

    public boolean hasPdf() {
        return pdfPath != null && !pdfPath.isEmpty();
    }

    public boolean hasAudio() {
        return audioPath != null && !audioPath.isEmpty();
    }
} 