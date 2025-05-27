package com.example.qazaqadebiety.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.qazaqadebiety.R;
import com.example.qazaqadebiety.BookDetailActivity;
import com.example.qazaqadebiety.model.Book;
import com.google.android.material.card.MaterialCardView;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {
    private List<Book> books;
    private Context context;

    public BookAdapter(Context context, List<Book> books) {
        this.context = context;
        this.books = books;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        Book book = books.get(position);
        
        holder.titleText.setText(book.getTitleKazakh());
        holder.authorText.setText(book.getAuthor());
        holder.genreText.setText(book.getGenre());
        
        // Показываем тип книги
        if (book.getType() == Book.BookType.BOTH) {
            holder.typeIndicator.setText("📚 🎧");
            holder.typeIndicator.setVisibility(View.VISIBLE);
        } else if (book.getType() == Book.BookType.PDF) {
            holder.typeIndicator.setText("📚 PDF");
            holder.typeIndicator.setVisibility(View.VISIBLE);
        } else if (book.getType() == Book.BookType.AUDIO) {
            holder.typeIndicator.setText("🎧 Аудио");
            holder.typeIndicator.setVisibility(View.VISIBLE);
        }

        // Показываем дополнительную информацию
        if (book.hasPdf() && book.getPages() > 0) {
            holder.pagesText.setText(book.getPages() + " бет");
            holder.pagesText.setVisibility(View.VISIBLE);
        } else {
            holder.pagesText.setVisibility(View.GONE);
        }

        if (book.hasAudio() && !book.getDuration().isEmpty()) {
            holder.durationText.setText(book.getDuration());
            holder.durationText.setVisibility(View.VISIBLE);
        } else {
            holder.durationText.setVisibility(View.GONE);
        }

        // Обработка клика
        holder.cardView.setOnClickListener(v -> {
            Intent intent = new Intent(context, BookDetailActivity.class);
            intent.putExtra("book", book);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    static class BookViewHolder extends RecyclerView.ViewHolder {
        MaterialCardView cardView;
        ImageView coverImage;
        TextView titleText, authorText, genreText, typeIndicator, pagesText, durationText;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = (MaterialCardView) itemView;
            coverImage = itemView.findViewById(R.id.book_cover);
            titleText = itemView.findViewById(R.id.book_title);
            authorText = itemView.findViewById(R.id.book_author);
            genreText = itemView.findViewById(R.id.book_genre);
            typeIndicator = itemView.findViewById(R.id.book_type_indicator);
            pagesText = itemView.findViewById(R.id.book_pages);
            durationText = itemView.findViewById(R.id.book_duration);
        }
    }
} 