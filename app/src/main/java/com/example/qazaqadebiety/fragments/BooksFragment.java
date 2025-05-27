package com.example.qazaqadebiety.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.qazaqadebiety.R;
import com.example.qazaqadebiety.adapter.BookAdapter;
import com.example.qazaqadebiety.data.BookRepository;
import com.example.qazaqadebiety.model.Book;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

public class BooksFragment extends Fragment {
    private RecyclerView recyclerView;
    private BookAdapter adapter;
    private BookRepository repository;
    private TabLayout tabLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_books, container, false);
        
        initializeViews(view);
        setupTabLayout();
        loadAllBooks();
        
        return view;
    }

    private void initializeViews(View view) {
        tabLayout = view.findViewById(R.id.books_tab_layout);
        recyclerView = view.findViewById(R.id.recycler_books);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        
        repository = BookRepository.getInstance();
    }

    private void setupTabLayout() {
        tabLayout.addTab(tabLayout.newTab().setText("Барлығы"));
        tabLayout.addTab(tabLayout.newTab().setText("PDF кітаптар"));
        tabLayout.addTab(tabLayout.newTab().setText("Аудиокітаптар"));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        loadAllBooks();
                        break;
                    case 1:
                        loadPdfBooks();
                        break;
                    case 2:
                        loadAudioBooks();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}

            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });
    }

    private void loadAllBooks() {
        List<Book> books = repository.getAllBooks();
        adapter = new BookAdapter(getContext(), books);
        recyclerView.setAdapter(adapter);
    }

    private void loadPdfBooks() {
        List<Book> books = repository.getPdfBooks();
        adapter = new BookAdapter(getContext(), books);
        recyclerView.setAdapter(adapter);
    }

    private void loadAudioBooks() {
        List<Book> books = repository.getAudioBooks();
        adapter = new BookAdapter(getContext(), books);
        recyclerView.setAdapter(adapter);
    }
} 