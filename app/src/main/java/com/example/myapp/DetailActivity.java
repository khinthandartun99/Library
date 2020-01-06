package com.example.myapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.myapp.Model.Book;
import com.example.myapp.Utils.FontEmbedder;

import java.util.List;

public class DetailActivity extends AppCompatActivity {

    TextView txttitle,txtauthor,txtpublisher,txtedition,txtrecommend,txtcname;
    ImageView imageView;
    List<Book> bookdatalist;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imageView=findViewById(R.id.book_image);
        txttitle=findViewById(R.id.book_title);

        txtauthor=findViewById(R.id.author_name);
        txtpublisher=findViewById(R.id.publisher);
        txtedition=findViewById(R.id.edition);
        txtrecommend=findViewById(R.id.recommend);
        txtcname=findViewById(R.id.category_name);

        Intent intent=getIntent();
        String image=intent.getStringExtra("Image");
        String title=intent.getStringExtra("Title");
        String cname=intent.getStringExtra("CategoryName");
        String author=intent.getStringExtra("Author");
        String publiser=intent.getStringExtra("Publisher");
        String edition=intent.getStringExtra("Edition");
        String recommend=intent.getStringExtra("Recommand");

        Glide.with(getApplicationContext())
                .load("http://192.168.43.99/CULibrary/"+image)
                .into(imageView);

        //Toast.makeText(getApplicationContext(),"String",Toast.LENGTH_LONG).show();

        FontEmbedder.force(txttitle,title);
        FontEmbedder.force(txtcname,cname);
        FontEmbedder.force(txtauthor,author);
        FontEmbedder.force(txtpublisher,publiser);
        FontEmbedder.force(txtedition,edition);
        FontEmbedder.force(txtrecommend,recommend);

    }
}
