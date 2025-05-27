package com.example.qazaqadebiety;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.example.qazaqadebiety.model.Book;

public class AudioPlayerActivity extends AppCompatActivity {
    private TextView titleText, authorText, currentTimeText, totalTimeText;
    private Button playPauseButton, stopButton;
    private SeekBar seekBar;
    private Toolbar toolbar;
    private Book book;
    
    private MediaPlayer mediaPlayer;
    private Handler handler = new Handler();
    private boolean isPlaying = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_player);

        initializeViews();
        setupToolbar();
        loadBook();
        setupAudioPlayer();
    }

    private void initializeViews() {
        toolbar = findViewById(R.id.toolbar);
        titleText = findViewById(R.id.audio_title);
        authorText = findViewById(R.id.audio_author);
        currentTimeText = findViewById(R.id.current_time);
        totalTimeText = findViewById(R.id.total_time);
        playPauseButton = findViewById(R.id.btn_play_pause);
        stopButton = findViewById(R.id.btn_stop);
        seekBar = findViewById(R.id.seek_bar);
    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Аудиокітап");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    private void loadBook() {
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("book")) {
            book = (Book) intent.getSerializableExtra("book");
            if (book != null && book.hasAudio()) {
                titleText.setText(book.getTitleKazakh());
                authorText.setText(book.getAuthor());
                totalTimeText.setText(book.getDuration());
            } else {
                Toast.makeText(this, "Аудио файл табылмады", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }

    private void setupAudioPlayer() {
        try {
            // Инициализация MediaPlayer с файлом из assets
            mediaPlayer = new MediaPlayer();
            String audioPath = book.getAudioPath();
            
            // Загружаем файл из assets
            android.content.res.AssetFileDescriptor afd = getAssets().openFd(audioPath);
            mediaPlayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            afd.close();
            
            mediaPlayer.prepare();
            
            // Настройка SeekBar с реальной длительностью
            int duration = mediaPlayer.getDuration();
            seekBar.setMax(duration);
            totalTimeText.setText(formatTime(duration));
            
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Аудио файл жүктелмеді: " + e.getMessage(), Toast.LENGTH_LONG).show();
            // Fallback к демонстрационному режиму
            seekBar.setMax(100);
        }
        
        playPauseButton.setOnClickListener(v -> {
            if (isPlaying) {
                pauseAudio();
            } else {
                playAudio();
            }
        });

        stopButton.setOnClickListener(v -> stopAudio());

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser && mediaPlayer != null) {
                    mediaPlayer.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        currentTimeText.setText("00:00:00");
    }

    private void playAudio() {
        try {
            if (mediaPlayer != null) {
                mediaPlayer.start();
                isPlaying = true;
                playPauseButton.setText("⏸️ Тоқтату");
                
                Toast.makeText(this, "Аудио ойнатылуда: " + book.getTitleKazakh(), Toast.LENGTH_SHORT).show();
                
                startProgressUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Аудио ойнату қатесі: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void pauseAudio() {
        isPlaying = false;
        playPauseButton.setText("▶️ Ойнату");
        
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }

    private void stopAudio() {
        isPlaying = false;
        playPauseButton.setText("▶️ Ойнату");
        seekBar.setProgress(0);
        currentTimeText.setText("00:00:00");
        
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.reset();
        }
    }

    private void startProgressUpdate() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (isPlaying && mediaPlayer != null && mediaPlayer.isPlaying()) {
                    try {
                        int currentPosition = mediaPlayer.getCurrentPosition();
                        seekBar.setProgress(currentPosition);
                        currentTimeText.setText(formatTime(currentPosition));
                        
                        handler.postDelayed(this, 1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (isPlaying && mediaPlayer != null && !mediaPlayer.isPlaying()) {
                    // Аудио закончилось
                    stopAudio();
                }
            }
        }, 1000);
    }
    
    private String formatTime(int milliseconds) {
        int seconds = milliseconds / 1000;
        int minutes = seconds / 60;
        int hours = minutes / 60;
        
        seconds = seconds % 60;
        minutes = minutes % 60;
        
        if (hours > 0) {
            return String.format("%02d:%02d:%02d", hours, minutes, seconds);
        } else {
            return String.format("%02d:%02d", minutes, seconds);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
        handler.removeCallbacksAndMessages(null);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
} 