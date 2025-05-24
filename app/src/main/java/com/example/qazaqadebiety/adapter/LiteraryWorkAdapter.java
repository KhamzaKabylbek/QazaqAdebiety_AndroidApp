package com.example.qazaqadebiety.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.qazaqadebiety.R;
import com.example.qazaqadebiety.model.LiteraryWork;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.chip.Chip;

import java.util.List;

public class LiteraryWorkAdapter extends RecyclerView.Adapter<LiteraryWorkAdapter.WorkViewHolder> {
    private List<LiteraryWork> works;
    private Context context;

    public LiteraryWorkAdapter(Context context, List<LiteraryWork> works) {
        this.context = context;
        this.works = works;
    }

    @NonNull
    @Override
    public WorkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_literary_work, parent, false);
        return new WorkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkViewHolder holder, int position) {
        LiteraryWork work = works.get(position);
        
        holder.titleText.setText(work.getTitleKazakh());
        holder.authorText.setText("Автор: " + work.getAuthor());
        holder.genreText.setText("Жанр: " + work.getGenre());
        holder.yearText.setText("Жыл: " + work.getYear());
        
        // Ограничиваем длину описания
        String description = work.getDescription();
        if (description.length() > 100) {
            description = description.substring(0, 100) + "...";
        }
        holder.descriptionText.setText(description);
        
        // Показываем индикатор классики
        if (work.isClassic()) {
            holder.classicIndicator.setVisibility(View.VISIBLE);
            holder.classicIndicator.setText("📚 Классикалық");
        } else {
            holder.classicIndicator.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return works.size();
    }

    static class WorkViewHolder extends RecyclerView.ViewHolder {
        TextView titleText, authorText, genreText, yearText, descriptionText, classicIndicator;

        public WorkViewHolder(@NonNull View itemView) {
            super(itemView);
            titleText = itemView.findViewById(R.id.work_title);
            authorText = itemView.findViewById(R.id.work_author);
            genreText = itemView.findViewById(R.id.work_genre);
            yearText = itemView.findViewById(R.id.work_year);
            descriptionText = itemView.findViewById(R.id.work_description);
            classicIndicator = itemView.findViewById(R.id.classic_indicator);
        }
    }
} 