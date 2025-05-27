package com.example.qazaqadebiety.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.example.qazaqadebiety.R;

public class ARFragment extends Fragment {

    private MaterialButton buttonStartAR;
    private MaterialButton buttonARGallery;
    private MaterialButton buttonARQuotes;
    private TextView textViewARDescription;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ar, container, false);
        
        initializeViews(view);
        setupClickListeners();
        
        return view;
    }

    private void initializeViews(View view) {
        buttonStartAR = view.findViewById(R.id.buttonStartAR);
        buttonARGallery = view.findViewById(R.id.buttonARGallery);
        buttonARQuotes = view.findViewById(R.id.buttonARQuotes);
        textViewARDescription = view.findViewById(R.id.textViewARDescription);
    }

    private void setupClickListeners() {
        buttonStartAR.setOnClickListener(v -> {
            // В будущем здесь будет запуск AR камеры
            Toast.makeText(getContext(), "AR камерасы жақында қосылады!", Toast.LENGTH_SHORT).show();
        });

        buttonARGallery.setOnClickListener(v -> {
            // AR галерея
            Toast.makeText(getContext(), "AR галереясы дамуда", Toast.LENGTH_SHORT).show();
        });

        buttonARQuotes.setOnClickListener(v -> {
            // AR цитаты
            Toast.makeText(getContext(), "AR дәйексөздері дамуда", Toast.LENGTH_SHORT).show();
        });
    }
} 