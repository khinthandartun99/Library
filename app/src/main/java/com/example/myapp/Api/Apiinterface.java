package com.example.myapp.Api;

import com.example.myapp.Model.Author;
import com.example.myapp.Model.Book;
import com.example.myapp.Model.Book;
import com.example.myapp.Model.Category;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Apiinterface {

    @GET("book")
    Call<List<Book>> getAllBook();

    @POST("book/status/{status}")
    Call<List<Book>> getAvailableBook(@Path("status")int status);

    @POST("author/detail/{id}")
    Call<List<Book>> getAllAuthorBook(@Path("id") int id);

    @GET("author")
    Call<List<Author>> getAllAuthor();



    @GET("category")
    Call<List<Category>> getAllCategory();

    @POST("category/detail/{id}")
    Call<List<Book>> getAllCategoryBook(@Path("id") int id);



}
