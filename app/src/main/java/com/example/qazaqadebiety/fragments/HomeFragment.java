package com.example.qazaqadebiety.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.google.android.material.card.MaterialCardView;
import com.example.qazaqadebiety.R;
import com.example.qazaqadebiety.AuthorsActivity;
import com.example.qazaqadebiety.LiteraryWorksActivity;
import com.example.qazaqadebiety.QuotesActivity;
import com.example.qazaqadebiety.AboutActivity;

public class HomeFragment extends Fragment {

    private MaterialCardView cardAuthors;
    private MaterialCardView cardWorks;
    private MaterialCardView cardQuotes;
    private MaterialCardView cardAbout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        
        initializeViews(view);
        setupClickListeners();
        
        return view;
    }

    private void initializeViews(View view) {
        cardAuthors = view.findViewById(R.id.card_authors);
        cardWorks = view.findViewById(R.id.card_works);
        cardQuotes = view.findViewById(R.id.card_quotes);
        cardAbout = view.findViewById(R.id.card_about);
    }

    private void setupClickListeners() {
        cardAuthors.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), AuthorsActivity.class);
            startActivity(intent);
        });

        cardWorks.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), LiteraryWorksActivity.class);
            startActivity(intent);
        });

        cardQuotes.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), QuotesActivity.class);
            startActivity(intent);
        });

        cardAbout.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), AboutActivity.class);
            startActivity(intent);
        });
    }
} 