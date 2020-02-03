package com.example.recyclerform;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.recyclerform.book.adapter.RecyclerBookAdapter;
import com.example.recyclerform.book.model.Book;
import com.example.recyclerform.util.Constants;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private List<Book> bookList;
    private RecyclerView rvBooks;
    private RecyclerBookAdapter recyclerBookAdapter;
    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initVars();
    }

    private void initView(){
        rvBooks = findViewById(R.id.rv_books);
        floatingActionButton = findViewById(R.id.fab_add_book);

        floatingActionButton.setOnClickListener(this);
    }

    private void initVars(){
        initBookList();
        setupRecycler();
    }

    private void setupRecycler(){
        recyclerBookAdapter = new RecyclerBookAdapter(bookList);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        rvBooks.setLayoutManager(manager);
        rvBooks.setAdapter(recyclerBookAdapter);
    }

    private void initBookList() {
        bookList = new ArrayList<>();
//      bookList.add(new Book("Harry Potter 1", 100));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab_add_book:
                startFormActivity();
                break;
            default:
                Toast.makeText(this, "default", Toast.LENGTH_SHORT).show();
        }
    }

    public void updateAdapterList(){
        recyclerBookAdapter.notifyDataSetChanged();
    }

    private void startFormActivity() {
        Intent intent = new Intent(this, FormActivity.class);
        startActivityForResult(intent, Constants.START_FORM_ACTIVITY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == Constants.START_FORM_ACTIVITY) {
            if(resultCode == Activity.RESULT_OK) {
                Book book = data.getParcelableExtra(Constants.BOOK_OBJECT);
                if(book != null) {
                    Book bookToAdd = new Book(book.getTitle(), book.getPages());
                    bookList.add(bookToAdd);
                    updateAdapterList();
                }
            }
            if(resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
