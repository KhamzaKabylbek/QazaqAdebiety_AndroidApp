package com.example.qazaqadebiety;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonLogin;
    private TextView textViewRegister;
    private TextView textViewTitle;
    private boolean isLoginMode = true;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Настройка статус бара
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.primary));
        window.getDecorView().setSystemUiVisibility(0);

        sharedPreferences = getSharedPreferences("QazaqAdebietyPrefs", MODE_PRIVATE);

        // Проверяем, авторизован ли пользователь
        if (isUserLoggedIn()) {
            navigateToMainActivity();
            return;
        }

        initializeViews();
        setupClickListeners();
    }

    private void initializeViews() {
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        textViewRegister = findViewById(R.id.textViewRegister);
        textViewTitle = findViewById(R.id.textViewTitle);
    }

    private void setupClickListeners() {
        buttonLogin.setOnClickListener(v -> {
            if (isLoginMode) {
                performLogin();
            } else {
                performRegistration();
            }
        });

        textViewRegister.setOnClickListener(v -> toggleMode());
    }

    private void performLogin() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Барлық өрістерді толтырыңыз", Toast.LENGTH_SHORT).show();
            return;
        }

        // Простая проверка для демонстрации
        if (email.equals("admin@qazaq.kz") && password.equals("123456")) {
            saveUserSession(email);
            navigateToMainActivity();
        } else {
            Toast.makeText(this, "Қате email немесе құпия сөз", Toast.LENGTH_SHORT).show();
        }
    }

    private void performRegistration() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Барлық өрістерді толтырыңыз", Toast.LENGTH_SHORT).show();
            return;
        }

        if (password.length() < 6) {
            Toast.makeText(this, "Құпия сөз кемінде 6 таңбадан тұруы керек", Toast.LENGTH_SHORT).show();
            return;
        }

        // Сохраняем пользователя (в реальном приложении это будет API запрос)
        saveUserSession(email);
        Toast.makeText(this, "Тіркелу сәтті аяқталды!", Toast.LENGTH_SHORT).show();
        navigateToMainActivity();
    }

    private void toggleMode() {
        isLoginMode = !isLoginMode;
        if (isLoginMode) {
            textViewTitle.setText("Кіру");
            buttonLogin.setText("Кіру");
            textViewRegister.setText("Тіркелгіңіз жоқ па? Тіркелу");
        } else {
            textViewTitle.setText("Тіркелу");
            buttonLogin.setText("Тіркелу");
            textViewRegister.setText("Тіркелгіңіз бар ма? Кіру");
        }
    }

    private void saveUserSession(String email) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isLoggedIn", true);
        editor.putString("userEmail", email);
        editor.apply();
    }

    private boolean isUserLoggedIn() {
        return sharedPreferences.getBoolean("isLoggedIn", false);
    }

    private void navigateToMainActivity() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
} 