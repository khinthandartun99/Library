package com.example.myapp.CategoriesAdapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapp.AuthorDetailActivity;
import com.example.myapp.CategoryDetailActivity;
import com.example.myapp.DetailActivity;
import com.example.myapp.Model.CategoriesData;
import com.example.myapp.Model.Category;
import com.example.myapp.R;
import com.example.myapp.Utils.FontEmbedder;

import java.util.List;
import java.util.Locale;
public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder> {
    private Context context;
    TextView name;
    private List<Category> categoriesDataList;


    public CategoriesAdapter(Context context, List<Category> categoriesDataList) {
        this.context = context;
        this.categoriesDataList = categoriesDataList;
    }


    @NonNull
    @Override
    public CategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.categorieslayout,parent,false);

        return new CategoriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesViewHolder holder, final int position) {
        FontEmbedder.force(holder.name,categoriesDataList.get(position).getCategoryName());
        //holder.name.setText(categoriesDataList.get(position).getCategoryName());
        //holder.quantity.setText(categoriesDataList.get(position).getQuantity());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, CategoryDetailActivity.class);

                intent.putExtra("Id",categoriesDataList.get(position).getId()+"");

                //Toast.makeText(context,"String",Toast.LENGTH_LONG).show();

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                context.startActivity(intent);

            }
        });



    }

    @Override
    public int getItemCount() {
        return categoriesDataList.size();
    }
    class CategoriesViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        CardView cardView;

        public CategoriesViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.category);
            cardView=itemView.findViewById(R.id.category_cardView);

        }
    }


}

