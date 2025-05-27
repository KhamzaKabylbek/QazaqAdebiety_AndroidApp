package com.example.qazaqadebiety.data;

import com.example.qazaqadebiety.model.Book;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private static BookRepository instance;
    private List<Book> books;

    private BookRepository() {
        books = new ArrayList<>();
        initializeBooks();
    }

    public static BookRepository getInstance() {
        if (instance == null) {
            instance = new BookRepository();
        }
        return instance;
    }

    private void initializeBooks() {
        // Пример книги - замените на ваши реальные данные
        books.add(new Book(
            "1",
            "Абай жолы",
            "Абай жолы",
            "Мұхтар Омарханұлы Әуезов",
            "Абай Құнанбаевтың өмірі мен шығармашылығы туралы эпопея. Бірінші том.",
            "",
            "books/pdf/abai_zholy_book1.pdf",
            "books/audio/abai_zholy_book1_chapter1.mp3",
            Book.BookType.BOTH,
            "12:30:00", // длительность аудио
            450, // количество страниц
            "Эпопея",
            "1942"
        ));

        books.add(new Book(
            "2",
            "Қан мен тер",
            "Қан мен тер",
            "Әбдіжәміл Нұрпейісов",
            "Арал теңізі жағалауындағы балықшылардың өмірі туралы роман",
            "",
            "books/pdf/qan_men_ter.pdf",
            "",
            Book.BookType.PDF,
            "",
            320,
            "Роман",
            "1961"
        ));

        books.add(new Book(
            "3",
            "Махаббат, қызық мол жылдар",
            "Махаббат, қызық мол жылдар",
            "Әзілхан Нұршайықов",
            "Жастық шақтағы махаббат пен достық туралы повесть",
            "",
            "",
            "books/audio/mahabbat_qyziq.mp3",
            Book.BookType.AUDIO,
            "8:45:00",
            0,
            "Повесть",
            "1970"
        ));
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    public List<Book> getPdfBooks() {
        List<Book> pdfBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.hasPdf()) {
                pdfBooks.add(book);
            }
        }
        return pdfBooks;
    }

    public List<Book> getAudioBooks() {
        List<Book> audioBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.hasAudio()) {
                audioBooks.add(book);
            }
        }
        return audioBooks;
    }

    public Book getBookById(String id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(String id) {
        books.removeIf(book -> book.getId().equals(id));
    }
} 