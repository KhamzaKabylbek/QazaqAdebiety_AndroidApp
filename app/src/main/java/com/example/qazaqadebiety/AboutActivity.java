package com.example.qazaqadebiety;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        initializeViews();
    }

    private void initializeViews() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Қолданба туралы");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        TextView aboutTextView = findViewById(R.id.about_content);
        
        String aboutText = "🇰🇿 Ұлы Әдебиет\n\n" +
                "📚 Міндеті:\n" +
                "Бұл қолданба қазақ әдебиетінің байлығын таратуға және ұлы жазушыларымыздың шығармашылығын жастарға жақындатуға арналған.\n\n" +
                "✨ Мүмкіндіктері:\n" +
                "• Ұлы қазақ жазушыларының өмірбаяны\n" +
                "• Классикалық әдеби шығармалар\n" +
                "• Даналық сөздер мен ұлағатты ойлар\n" +
                "• Қазақ әдебиетінің дәстүрлері\n\n" +
                "📖 Мазмұн:\n" +
                "Қолданбада Абай, Мұхтар Әуезов, Жамбыл, Сәкен Сейфуллин, Ілияс Есенберлин, Ғабит Мүсірепов сияқты ұлы тұлғалардың шығармашылығы жинақталған.\n\n" +
                "🎯 Мақсат:\n" +
                "Қазақ әдебиетін сүю, құрметтеу және келешек ұрпаққа жеткізу арқылы ұлттық рухани мұраны сақтау.\n\n" +
                "👥 Аудитория:\n" +
                "Әдебиет сүйер барлық адамдарға, студенттерге, оқушыларға және қазақ мәдениетін зерттеушілерге арналған.\n\n" +
                "💝 Дамыту тобы\n" +
                "Қазақ әдебиетін насихаттау миссиясымен жасалған.\n\n" +
                "© 2024 - Ұлы Әдебиет";
        
        aboutTextView.setText(aboutText);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}