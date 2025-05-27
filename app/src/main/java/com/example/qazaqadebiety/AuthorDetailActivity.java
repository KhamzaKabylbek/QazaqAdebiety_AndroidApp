package com.example.qazaqadebiety;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.example.qazaqadebiety.data.AuthorRepository;
import com.example.qazaqadebiety.model.Author;

public class AuthorDetailActivity extends AppCompatActivity {
    private TextView authorName, authorNameKazakh, authorYears, authorBiography, authorWorks, authorQuotes;
    private Toolbar toolbar;

    private AuthorRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author_detail);

        initializeViews();
        setupToolbar();
        loadAuthorData();
    }

    private void initializeViews() {
        toolbar = findViewById(R.id.toolbar);
        authorName = findViewById(R.id.text_author_name);
        authorNameKazakh = findViewById(R.id.text_author_name_kazakh);
        authorYears = findViewById(R.id.text_author_years);
        authorBiography = findViewById(R.id.text_author_biography);
        authorWorks = findViewById(R.id.text_author_works);
        authorQuotes = findViewById(R.id.text_author_quotes);

        repository = AuthorRepository.getInstance();
    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Жазушы туралы");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    private void loadAuthorData() {
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("author")) {
            Author author = (Author) intent.getSerializableExtra("author");
            if (author != null) {
                displayAuthorInfo(author);
            }
        }
    }

    private void displayAuthorInfo(Author author) {
        authorName.setText(author.getName());
        authorNameKazakh.setText(author.getNameKazakh());
        authorYears.setText(author.getLifeYears());
        authorBiography.setText(author.getBiography());
        
        StringBuilder worksText = new StringBuilder();
        for (String work : author.getFamousWorks()) {
            worksText.append("• ").append(work).append("\n");
        }
        authorWorks.setText(worksText.toString());
        
        StringBuilder quotesText = new StringBuilder();
        for (String quote : author.getQuotes()) {
            quotesText.append("\"").append(quote).append("\"\n\n");
        }
        authorQuotes.setText(quotesText.toString());
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
} 