package com.example.myapp.BookAdapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapp.DetailActivity;
import com.example.myapp.Model.Book;
import com.example.myapp.R;
import com.example.myapp.Utils.FontEmbedder;

import java.util.List;

public class Bookadapter extends RecyclerView.Adapter<Bookadapter.BookViewHolder> {
    private Context context;
    private List<Book> bookdatalist;

    ImageView imageView;

    public Bookadapter(Context context, List<Book> bookdatalist) {
        this.context = context;
        this.bookdatalist = bookdatalist;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.booklayout, parent, false);
        return new BookViewHolder(view);
    }


    public void onBindViewHolder(@NonNull final BookViewHolder holder, final int position) {
        FontEmbedder.force(holder.txttitle,bookdatalist.get(position).getTitle().toString());
        FontEmbedder.force(holder.txtauthor,bookdatalist.get(position).getAuthor().getName().toString());
        Glide.with(context)
                .load("http://192.168.43.99/CULibrary/"+bookdatalist.get(position).getImage())
                .into(holder.imageView);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(context,"String"+bookdatalist.get(position).getTitle()+bookdatalist.get(position).getCategory().getCategoryName()+bookdatalist.get(position).getRecommand()+bookdatalist.get(position).getAuthor().getName()+bookdatalist.get(position).getEdition()+bookdatalist.get(position).getImage().toString(),Toast.LENGTH_LONG).show();

                Intent intent=new Intent(context, DetailActivity.class);
                intent.putExtra("Image",bookdatalist.get(position).getImage().toString());
                intent.putExtra("Title",bookdatalist.get(position).getTitle().toString());
                intent.putExtra("CategoryName",bookdatalist.get(position).getCategory().getCategoryName().toString());
                intent.putExtra("Author",bookdatalist.get(position).getAuthor().getName().toString());
                intent.putExtra("Publisher",bookdatalist.get(position).getPublisher().toString());
                intent.putExtra("Edition",bookdatalist.get(position).getEdition().toString());
                intent.putExtra("Recommand",bookdatalist.get(position).getRecommand().toString());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

            }
        });



    }

    @Override
    public int getItemCount() {

        return bookdatalist.size();
    }

    class BookViewHolder extends RecyclerView.ViewHolder {
        Button btnall, btnavailable;
        ImageView imageView;
        TextView txtauthor,txttitle;
        LinearLayout linearLayout;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            btnall = itemView.findViewById(R.id.btnAll);
            btnavailable = itemView.findViewById(R.id.btnAvailable);
            imageView = itemView.findViewById(R.id.bookimage);
            txtauthor=itemView.findViewById(R.id.txtauthor);
            txttitle=itemView.findViewById(R.id.txttitle);

            linearLayout=itemView.findViewById(R.id.book_detail);
        }
    }
}