package com.example.qazaqadebiety;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class AboutActivity extends AppCompatActivity {
    private TextView aboutContent;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        initializeViews();
        setupToolbar();
        setupContent();
    }

    private void initializeViews() {
        toolbar = findViewById(R.id.toolbar);
        aboutContent = findViewById(R.id.about_content);
    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Қолданба туралы");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    private void setupContent() {
        String aboutText = "\"Қазақ Әдебиеті\" қолданбасы\n\n" +
                "Бұл қолданба қазақ әдебиетінің байлығын жастарға жеткізу мақсатында жасалған.\n\n" +
                "Қолданбада:\n" +
                "• Қазақ жазушыларының өмірбаяны\n" +
                "• Әдеби шығармалар\n" +
                "• Даналық сөздер мен нақыл сөздер\n" +
                "• AR технологиясы арқылы интерактивті тәжірибе\n\n" +
                "Біздің мақсатымыз - қазақ әдебиетін заманауи технологиялар арқылы насихаттау.\n\n" +
                "Версия: 1.0\n" ;

        aboutContent.setText(aboutText);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}