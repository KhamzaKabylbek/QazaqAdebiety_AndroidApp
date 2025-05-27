package com.example.qazaqadebiety;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.FileProvider;
import com.example.qazaqadebiety.model.Book;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class PdfReaderActivity extends AppCompatActivity {
    private WebView webView;
    private Toolbar toolbar;
    private Book book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_reader);

        initializeViews();
        setupToolbar();
        loadBook();
    }

    private void initializeViews() {
        toolbar = findViewById(R.id.toolbar);
        webView = findViewById(R.id.pdf_webview);
    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("PDF оқу");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    private void loadBook() {
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("book")) {
            book = (Book) intent.getSerializableExtra("book");
            if (book != null && book.hasPdf()) {
                setupWebView();
                loadPdf();
            } else {
                Toast.makeText(this, "PDF файл табылмады", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }

    private void setupWebView() {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setAllowContentAccess(true);
        
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                // PDF загружен
            }
            
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                super.onReceivedError(view, errorCode, description, failingUrl);
                Toast.makeText(PdfReaderActivity.this, "PDF жүктеу қатесі: " + description, Toast.LENGTH_LONG).show();
                // Попробуем открыть внешне
                openPdfExternally();
            }
        });
    }

    private void loadPdf() {
        try {
            String pdfPath = book.getPdfPath();
            
            // Попробуем загрузить PDF через Google Docs Viewer
            String googleDocsUrl = "https://docs.google.com/gview?embedded=true&url=file:///android_asset/" + pdfPath;
            
            // Сначала попробуем прямую загрузку
            String directUrl = "file:///android_asset/" + pdfPath;
            
            // Загружаем PDF
            webView.loadUrl(directUrl);
            
            // Если не загрузится, WebViewClient автоматически попробует внешнее приложение
            
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "PDF жүктеу қатесі: " + e.getMessage(), Toast.LENGTH_LONG).show();
            openPdfExternally();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.pdf_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_open_external) {
            openPdfExternally();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void openPdfExternally() {
        try {
            // Копируем PDF из assets во внутреннее хранилище
            File pdfFile = copyPdfFromAssets();
            if (pdfFile != null && pdfFile.exists()) {
                // Создаем URI через FileProvider
                Uri pdfUri = FileProvider.getUriForFile(this, 
                    getPackageName() + ".fileprovider", pdfFile);
                
                // Создаем Intent для открытия PDF
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setDataAndType(pdfUri, "application/pdf");
                intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                
                // Проверяем, есть ли приложения для открытия PDF
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                    Toast.makeText(this, "PDF сыртқы қолданбада ашылды", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "PDF ашатын қолданба табылмады. Google PDF Viewer немесе Adobe Reader орнатыңыз.", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(this, "PDF файлын көшіру мүмкін болмады", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "PDF ашу қатесі: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private File copyPdfFromAssets() {
        try {
            InputStream inputStream = getAssets().open(book.getPdfPath());
            File outputDir = new File(getFilesDir(), "pdfs");
            if (!outputDir.exists()) {
                outputDir.mkdirs();
            }
            
            File outputFile = new File(outputDir, "temp_" + book.getId() + ".pdf");
            FileOutputStream outputStream = new FileOutputStream(outputFile);
            
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
            
            outputStream.close();
            inputStream.close();
            
            return outputFile;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
} 