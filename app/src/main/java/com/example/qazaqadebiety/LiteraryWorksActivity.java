package com.example.qazaqadebiety;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.qazaqadebiety.adapter.LiteraryWorkAdapter;
import com.example.qazaqadebiety.data.AuthorRepository;
import com.example.qazaqadebiety.model.Author;
import com.example.qazaqadebiety.model.LiteraryWork;

import java.util.ArrayList;
import java.util.List;

public class LiteraryWorksActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private LiteraryWorkAdapter adapter;
    private AuthorRepository repository;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_literary_works);

        initializeViews();
        setupToolbar();
        loadWorks();
    }

    private void initializeViews() {
        toolbar = findViewById(R.id.toolbar);
        recyclerView = findViewById(R.id.recycler_works);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        
        repository = AuthorRepository.getInstance();
    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Әдеби шығармалар");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    private void loadWorks() {
        List<LiteraryWork> allWorks = new ArrayList<>();
        List<Author> authors = repository.getAllAuthors();
        
        for (Author author : authors) {
            for (String workTitle : author.getFamousWorks()) {
                LiteraryWork work = new LiteraryWork(
                    workTitle,
                    workTitle,
                    author.getName(),
                    "Әдеби шығарма",
                    "Белгісіз",
                    "Қазақ әдебиетінің классикалық шығармасы",
                    "Қысқаша мазмұны",
                    true
                );
                allWorks.add(work);
            }
        }
        
        adapter = new LiteraryWorkAdapter(this, allWorks);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
} 