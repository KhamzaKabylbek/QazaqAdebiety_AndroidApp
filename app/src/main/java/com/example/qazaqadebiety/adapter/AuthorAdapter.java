package com.example.qazaqadebiety.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.qazaqadebiety.R;
import com.example.qazaqadebiety.AuthorDetailActivity;
import com.example.qazaqadebiety.model.Author;
import com.google.android.material.card.MaterialCardView;

import java.util.List;

public class AuthorAdapter extends RecyclerView.Adapter<AuthorAdapter.AuthorViewHolder> {
    private List<Author> authors;
    private Context context;

    public AuthorAdapter(Context context, List<Author> authors) {
        this.context = context;
        this.authors = authors;
    }

    @NonNull
    @Override
    public AuthorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_author, parent, false);
        return new AuthorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AuthorViewHolder holder, int position) {
        Author author = authors.get(position);
        holder.nameText.setText(author.getNameKazakh());
        
        // Форматируем годы жизни на казахском
        String years = author.getBirthYear() + " - " + 
                      (author.getDeathYear().isEmpty() ? "қазіргі заман" : author.getDeathYear()) + 
                      " жж.";
        holder.yearsText.setText(years);
        
        // Ограничиваем длину биографии
        String biography = author.getBiography();
        if (biography.length() > 120) {
            biography = biography.substring(0, 120) + "...";
        }
        holder.biographyText.setText(biography);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, AuthorDetailActivity.class);
            intent.putExtra("author_name", author.getName());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return authors.size();
    }

    static class AuthorViewHolder extends RecyclerView.ViewHolder {
        TextView nameText, yearsText, biographyText;

        public AuthorViewHolder(@NonNull View itemView) {
            super(itemView);
            nameText = itemView.findViewById(R.id.author_name);
            yearsText = itemView.findViewById(R.id.author_years);
            biographyText = itemView.findViewById(R.id.author_biography);
        }
    }
} 