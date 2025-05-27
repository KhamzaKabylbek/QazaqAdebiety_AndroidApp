package com.example.qazaqadebiety;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.qazaqadebiety.adapter.AuthorAdapter;
import com.example.qazaqadebiety.data.AuthorRepository;
import com.example.qazaqadebiety.model.Author;

import java.util.List;

public class AuthorsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AuthorAdapter adapter;
    private AuthorRepository repository;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authors);

        initializeViews();
        setupToolbar();
        loadAuthors();
    }

    private void initializeViews() {
        toolbar = findViewById(R.id.toolbar);
        recyclerView = findViewById(R.id.recycler_authors);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        
        repository = AuthorRepository.getInstance();
    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Қазақ жазушылары");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    private void loadAuthors() {
        List<Author> authors = repository.getAllAuthors();
        adapter = new AuthorAdapter(this, authors);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
} 