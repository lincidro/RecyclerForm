package com.example.recyclerform;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.recyclerform.book.adapter.RecyclerBookAdapter;
import com.example.recyclerform.book.model.Book;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Book> bookList;
    private RecyclerView rvBooks;
    private RecyclerBookAdapter recyclerBookAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initVars();
    }

    private void initView(){
        rvBooks = findViewById(R.id.rv_books);
    }

    private void initVars(){
        populateBookList();
        setupRecycler();
    }

    private void setupRecycler(){
        recyclerBookAdapter = new RecyclerBookAdapter(bookList);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        rvBooks.setLayoutManager(manager);
        rvBooks.setAdapter(recyclerBookAdapter);
    }

    private void populateBookList() {
        bookList = new ArrayList<>();
        bookList.add(new Book("Harry Potter 1", 100));
        bookList.add(new Book("Harry Potter 2", 200));
        bookList.add(new Book("Harry Potter 3", 300));
        bookList.add(new Book("Harry Potter 4", 400));
        bookList.add(new Book("Harry Potter 5", 500));
    }
}
