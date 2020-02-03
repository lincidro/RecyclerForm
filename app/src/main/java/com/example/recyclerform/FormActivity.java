package com.example.recyclerform;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.recyclerform.book.model.Book;
import com.example.recyclerform.util.Constants;

public class FormActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnAccept;
    EditText etTitle, etPages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        initView();
    }

    private void initView() {
        etTitle = findViewById(R.id.et_title);
        etPages = findViewById(R.id.et_pages);
        btnAccept = findViewById(R.id.btn_accept);

        btnAccept.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_accept:
                String title = etTitle.getText().toString();
                int pages = Integer.parseInt(etPages.getText().toString());

                Book book = new Book(title,pages);
                sendData(book);
                break;
            default:
                break;
        }
    }

    private void sendData(Book book) {
        Intent intent = new Intent();
        intent.putExtra(Constants.BOOK_OBJECT, book);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}
