package com.example.myapp.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp.Api.ApiUtils;
import com.example.myapp.Api.Apiinterface;
import com.example.myapp.AuthorAdapter.AuthorAdapter;
import com.example.myapp.BookAdapter.Bookadapter;
import com.example.myapp.Model.Author;
import com.example.myapp.Model.AuthorData;
import com.example.myapp.Model.Book;
import com.example.myapp.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthorFragment extends Fragment {
    AuthorAdapter authorAdapter;
    RecyclerView recyclerView;
    View rootview;
    AuthorData authorData;
    List<AuthorData> authorDataList;
    Apiinterface apiinterface;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootview= inflater.inflate(R.layout.authorfragmentlayout,container,false);
        // return super.onCreateView(inflater, container, savedInstanceState);
        recyclerView=rootview.findViewById(R.id.recyclerview_author);
        apiinterface= ApiUtils.getApi();

        Call<List<Author>> getAuthor=apiinterface.getAllAuthor();
        getAuthor.enqueue(new Callback<List<Author>>() {
            @Override
            public void onResponse(Call<List<Author>> call, Response<List<Author>> response) {
                //Toast.makeText(getContext(),"String",Toast.LENGTH_LONG).show();
                LoadAuthorList(response.body());
            }

            @Override
            public void onFailure(Call<List<Author>> call, Throwable t) {
                Toast.makeText(getContext(),t.toString(),Toast.LENGTH_LONG).show();
            }
        });

         return rootview;
    }
    public void LoadAuthorList(List<Author> authorDataList){
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        authorAdapter=new AuthorAdapter(getContext(),authorDataList);
        recyclerView.setAdapter(authorAdapter);
    }

}
