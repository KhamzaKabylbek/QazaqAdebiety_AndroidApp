package com.example.qazaqadebiety;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.qazaqadebiety.data.AuthorRepository;
import com.example.qazaqadebiety.model.Author;

public class AuthorDetailActivity extends AppCompatActivity {
    private TextView nameTextView;
    private TextView nameKazakhTextView;
    private TextView yearsTextView;
    private TextView biographyTextView;
    private TextView worksTextView;
    private TextView quotesTextView;

    private AuthorRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author_detail);

        initializeViews();
        loadAuthorData();
    }

    private void initializeViews() {
        nameTextView = findViewById(R.id.text_author_name);
        nameKazakhTextView = findViewById(R.id.text_author_name_kazakh);
        yearsTextView = findViewById(R.id.text_author_years);
        biographyTextView = findViewById(R.id.text_author_biography);
        worksTextView = findViewById(R.id.text_author_works);
        quotesTextView = findViewById(R.id.text_author_quotes);

        repository = AuthorRepository.getInstance();
    }

    private void loadAuthorData() {
        String authorName = getIntent().getStringExtra("author_name");
        if (authorName != null) {
            Author author = repository.getAuthorByName(authorName);
            if (author != null) {
                displayAuthorInfo(author);
            }
        }
    }

    private void displayAuthorInfo(Author author) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(author.getName());
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        nameTextView.setText(author.getName());
        nameKazakhTextView.setText(author.getNameKazakh());
        yearsTextView.setText(author.getLifeYears());
        biographyTextView.setText(author.getBiography());

        // Отображение произведений
        StringBuilder works = new StringBuilder();
        for (int i = 0; i < author.getFamousWorks().size(); i++) {
            works.append("• ").append(author.getFamousWorks().get(i));
            if (i < author.getFamousWorks().size() - 1) {
                works.append("\n");
            }
        }
        worksTextView.setText(works.toString());

        // Отображение цитат
        StringBuilder quotes = new StringBuilder();
        for (int i = 0; i < author.getQuotes().size(); i++) {
            quotes.append("\"").append(author.getQuotes().get(i)).append("\"");
            if (i < author.getQuotes().size() - 1) {
                quotes.append("\n\n");
            }
        }
        quotesTextView.setText(quotes.toString());
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
} 