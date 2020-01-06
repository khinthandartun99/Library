package com.example.myapp.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp.Api.ApiUtils;
import com.example.myapp.Api.Apiinterface;
import com.example.myapp.AuthorAdapter.AuthorAdapter;
import com.example.myapp.BookAdapter.Bookadapter;
import com.example.myapp.Model.Author;
import com.example.myapp.Model.Book;
import com.example.myapp.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    List<Book> bookdataList;
    Apiinterface apiinterface;
    Bookadapter bookadapter;
    RecyclerView recyclerView;
    View rootview;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootview= inflater.inflate(R.layout.home_layout,container,false);
        // return super.onCreateView(inflater, container, savedInstanceState);
        recyclerView=rootview.findViewById(R.id.home_recycler);

        apiinterface= ApiUtils.getApi();
        getAllBookList();
        return rootview;


    }
    public void getAllBookList(){

        Call<List<Book>> getBook=apiinterface.getAllBook();

        getBook.enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                //Toast.makeText(getContext(),"String",Toast.LENGTH_LONG).show();
                LoadBookList(response.body());
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                Toast.makeText(getContext(),t.toString(),Toast.LENGTH_LONG).show();
            }
        });
    }
    public void LoadBookList(List<Book> bookList){
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        bookadapter=new Bookadapter(getContext(),bookList);
        recyclerView.setAdapter(bookadapter);
    }
}
