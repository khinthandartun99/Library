package com.example.myapp.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp.Api.ApiUtils;
import com.example.myapp.Api.Apiinterface;
import com.example.myapp.BookAdapter.Bookadapter;
import com.example.myapp.MainActivity;
import com.example.myapp.Model.Book;
import com.example.myapp.Model.Bookdata;
import com.example.myapp.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.myapp.Api.ApiUtils.getApi;

public class BookkFragment extends Fragment {
    RecyclerView recyclerView;
    View rootview;
    Bookdata bookdata;
    List<Book> bookdataList;
    Apiinterface apiinterface;
    Bookadapter bookadapter;
    Button btnall,btnavailable;
    TextView textView;
    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootview= inflater.inflate(R.layout.viewbookfragment,container,false);
       // return super.onCreateView(inflater, container, savedInstanceState);
        recyclerView=rootview.findViewById(R.id.recyclerview_book);
        btnall=rootview.findViewById(R.id.btnAll);
        btnavailable=rootview.findViewById(R.id.btnAvailable);
        textView=rootview.findViewById(R.id.book_list_title);

        apiinterface= ApiUtils.getApi();
        //getAllBookList();

        btnall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("All Book List");
                //Toast.makeText(getContext(),"String",Toast.LENGTH_LONG).show();

                getAllBookList();
            }

        });
        btnavailable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("Avaliable Book List");

                Call<List<Book>> getBook=apiinterface.getAvailableBook(0);
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
        });

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
    public void LoadBookList(List<Book> bookdataList){
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        bookadapter=new Bookadapter(getContext(),bookdataList);
        recyclerView.setAdapter(bookadapter);
    }
}
