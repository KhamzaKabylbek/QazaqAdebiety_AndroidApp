package com.example.qazaqadebiety;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.qazaqadebiety.adapter.LiteraryWorkAdapter;
import com.example.qazaqadebiety.data.AuthorRepository;
import com.example.qazaqadebiety.model.LiteraryWork;

import java.util.List;

public class LiteraryWorksActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private LiteraryWorkAdapter adapter;
    private AuthorRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_literary_works);

        initializeViews();
        loadWorks();
    }

    private void initializeViews() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Әдеби шығармалар");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        recyclerView = findViewById(R.id.recycler_works);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        
        repository = AuthorRepository.getInstance();
    }

    private void loadWorks() {
        List<LiteraryWork> works = repository.getAllLiteraryWorks();
        adapter = new LiteraryWorkAdapter(this, works);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
} 