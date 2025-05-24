package com.example.qazaqadebiety;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.google.android.material.card.MaterialCardView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Настройка статус бара
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.background));
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        initializeViews();
    }

    private void initializeViews() {
        MaterialCardView cardAuthors = findViewById(R.id.card_authors);
        MaterialCardView cardWorks = findViewById(R.id.card_works);
        MaterialCardView cardQuotes = findViewById(R.id.card_quotes);
        MaterialCardView cardAbout = findViewById(R.id.card_about);

        cardAuthors.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AuthorsActivity.class);
            startActivity(intent);
        });

        cardWorks.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, LiteraryWorksActivity.class);
            startActivity(intent);
        });

        cardQuotes.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, QuotesActivity.class);
            startActivity(intent);
        });

        cardAbout.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(intent);
        });
    }
} 