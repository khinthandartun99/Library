package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp.Api.ApiUtils;
import com.example.myapp.Api.Apiinterface;
import com.example.myapp.BookAdapter.Bookadapter;
import com.example.myapp.Model.Book;
import com.example.myapp.Model.Bookdata;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthorDetailActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Book> bookdataList;
    Apiinterface apiinterface;
    Bookadapter bookadapter;
    int position,id;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.author_detail);
        recyclerView=findViewById(R.id.recyclerview_author_book);
        apiinterface= ApiUtils.getApi();

        Intent intent=getIntent();
        int id=Integer.parseInt(intent.getStringExtra("Id"));

        Call<List<Book>> getBook=apiinterface.getAllAuthorBook(id);


        getBook.enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {

                LoadBookList(response.body());
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_LONG).show();
            }
        });

   }

    public void LoadBookList(List<Book> bookdataList){
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        bookadapter=new Bookadapter(getApplicationContext(),bookdataList);
        recyclerView.setAdapter(bookadapter);
    }
}
