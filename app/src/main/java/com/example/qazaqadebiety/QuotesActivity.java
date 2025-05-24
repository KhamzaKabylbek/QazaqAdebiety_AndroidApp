package com.example.qazaqadebiety;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.qazaqadebiety.adapter.QuoteAdapter;
import com.example.qazaqadebiety.data.AuthorRepository;
import com.example.qazaqadebiety.model.Author;

import java.util.ArrayList;
import java.util.List;

public class QuotesActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private QuoteAdapter adapter;
    private AuthorRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes);

        initializeViews();
        loadQuotes();
    }

    private void initializeViews() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Даналық сөздер");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        recyclerView = findViewById(R.id.recycler_quotes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        
        repository = AuthorRepository.getInstance();
    }

    private void loadQuotes() {
        List<String[]> allQuotes = new ArrayList<>();
        List<Author> authors = repository.getAllAuthors();
        
        for (Author author : authors) {
            for (String quote : author.getQuotes()) {
                allQuotes.add(new String[]{quote, author.getName()});
            }
        }
        
        adapter = new QuoteAdapter(this, allQuotes);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
} 