package com.example.myapp.Model;

import android.widget.Button;

import java.io.Serializable;

public class Bookdata implements Serializable {
    private int bookImage;
    private String bookName;
    private Button btnall;
    private Button btnavailable;

    public Bookdata(int bookImage, String bookName,Button btnall,Button btnavailable) {
        this.bookImage = bookImage;
        this.bookName = bookName;
        this.btnall = btnall;
        this.btnavailable = getBtnavailable();
    }


    public Button getBtnall() {
        return btnall;
    }

    public Button getBtnavailable() {
        return btnavailable;
    }

    public int getBookImage() {
        return bookImage;
    }

    public String getBookName() {

        return bookName;
    }
}
