package com.example.recyclerform.book.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerform.R;
import com.example.recyclerform.book.model.Book;

import java.util.List;

public class RecyclerBookAdapter extends RecyclerView.Adapter<RecyclerBookAdapter.RecyclerBookViewHolder> {

    List<Book> bookList;

    public RecyclerBookAdapter(List<Book> bookList) {
        this.bookList = bookList;
    }

    @NonNull
    @Override
    public RecyclerBookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyler_item,parent,false);
        return new RecyclerBookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerBookViewHolder holder, int position) {
        Book book = bookList.get(position);
        holder.tvTitle.setText(book.getTitle());
        holder.tvPages.setText(String.valueOf(book.getPages()));
    }

    @Override
    public int getItemCount() {
        return  bookList == null ? 0 : bookList.size();
    }

    public class RecyclerBookViewHolder extends RecyclerView.ViewHolder {

        public TextView tvTitle, tvPages;

        public RecyclerBookViewHolder(@NonNull View view) {
            super(view);
            tvTitle = view.findViewById(R.id.tv_book_title);
            tvPages = view.findViewById(R.id.tv_book_pages);
        }
    }
}
