package com.example.qazaqadebiety.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.qazaqadebiety.R;
import com.google.android.material.card.MaterialCardView;

import java.util.List;

public class QuoteAdapter extends RecyclerView.Adapter<QuoteAdapter.QuoteViewHolder> {
    private List<String[]> quotes; // [quote, author]
    private Context context;

    public QuoteAdapter(Context context, List<String[]> quotes) {
        this.context = context;
        this.quotes = quotes;
    }

    @NonNull
    @Override
    public QuoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_quote, parent, false);
        return new QuoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuoteViewHolder holder, int position) {
        String[] quoteData = quotes.get(position);
        holder.bind(quoteData[0], quoteData[1]);
    }

    @Override
    public int getItemCount() {
        return quotes.size();
    }

    public class QuoteViewHolder extends RecyclerView.ViewHolder {
        private MaterialCardView cardView;
        private TextView quoteTextView;
        private TextView authorTextView;

        public QuoteViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.card_quote);
            quoteTextView = itemView.findViewById(R.id.text_quote);
            authorTextView = itemView.findViewById(R.id.text_quote_author);
        }

        public void bind(String quote, String author) {
            quoteTextView.setText("\"" + quote + "\"");
            authorTextView.setText("— " + author);
        }
    }
} 