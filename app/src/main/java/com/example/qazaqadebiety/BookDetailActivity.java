package com.example.qazaqadebiety;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.example.qazaqadebiety.model.Book;

public class BookDetailActivity extends AppCompatActivity {
    private TextView titleText, authorText, descriptionText, genreText, yearText, pagesText, durationText;
    private Button readPdfButton, playAudioButton;
    private Toolbar toolbar;
    private Book book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        initializeViews();
        setupToolbar();
        loadBookData();
        setupButtons();
    }

    private void initializeViews() {
        toolbar = findViewById(R.id.toolbar);
        titleText = findViewById(R.id.book_detail_title);
        authorText = findViewById(R.id.book_detail_author);
        descriptionText = findViewById(R.id.book_detail_description);
        genreText = findViewById(R.id.book_detail_genre);
        yearText = findViewById(R.id.book_detail_year);
        pagesText = findViewById(R.id.book_detail_pages);
        durationText = findViewById(R.id.book_detail_duration);
        readPdfButton = findViewById(R.id.btn_read_pdf);
        playAudioButton = findViewById(R.id.btn_play_audio);
    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Кітап туралы");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    private void loadBookData() {
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("book")) {
            book = (Book) intent.getSerializableExtra("book");
            if (book != null) {
                displayBookInfo();
            }
        }
    }

    private void displayBookInfo() {
        titleText.setText(book.getTitleKazakh());
        authorText.setText("Автор: " + book.getAuthor());
        descriptionText.setText(book.getDescription());
        genreText.setText("Жанр: " + book.getGenre());
        yearText.setText("Жыл: " + book.getPublishYear());

        if (book.hasPdf() && book.getPages() > 0) {
            pagesText.setText("Беттер саны: " + book.getPages());
            pagesText.setVisibility(View.VISIBLE);
        } else {
            pagesText.setVisibility(View.GONE);
        }

        if (book.hasAudio() && !book.getDuration().isEmpty()) {
            durationText.setText("Ұзақтығы: " + book.getDuration());
            durationText.setVisibility(View.VISIBLE);
        } else {
            durationText.setVisibility(View.GONE);
        }
    }

    private void setupButtons() {
        // Настройка кнопки чтения PDF
        if (book != null && book.hasPdf()) {
            readPdfButton.setVisibility(View.VISIBLE);
            readPdfButton.setOnClickListener(v -> openPdfReader());
        } else {
            readPdfButton.setVisibility(View.GONE);
        }

        // Настройка кнопки воспроизведения аудио
        if (book != null && book.hasAudio()) {
            playAudioButton.setVisibility(View.VISIBLE);
            playAudioButton.setOnClickListener(v -> openAudioPlayer());
        } else {
            playAudioButton.setVisibility(View.GONE);
        }
    }

    private void openPdfReader() {
        Intent intent = new Intent(this, PdfReaderActivity.class);
        intent.putExtra("book", book);
        startActivity(intent);
    }

    private void openAudioPlayer() {
        Intent intent = new Intent(this, AudioPlayerActivity.class);
        intent.putExtra("book", book);
        startActivity(intent);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
} 