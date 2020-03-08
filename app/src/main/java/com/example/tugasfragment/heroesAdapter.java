package com.example.tugasfragment;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class heroesAdapter extends RecyclerView.Adapter<heroesAdapter.ViewHolder> {

    private Context context;
    private ArrayList<heroesModel> tvList = new ArrayList<>();

    public heroesAdapter(Context context){
        this.context = context;
    }

    public ArrayList<heroesModel> getTvList(){
        return tvList;
    }

    public void setTvList(ArrayList<heroesModel> tvList){
        this.tvList = tvList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.item_heroes,viewGroup,false);
        return new ViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        Glide.with(context).load(getTvList().get(i).getThumbnail()).into(viewHolder.ivThumbail);
        viewHolder.tvTitle.setText(getTvList().get(i).getTitle());
        viewHolder.btnTonton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,detailHeroes.class);
                intent.putExtra("img_url", getTvList().get(i).getThumbnail());
                intent.putExtra("title",getTvList().get(i).getTitle());
                intent.putExtra("detail",getTvList().get(i).getDetail());
                context.startActivity(intent);
            }
        });

        viewHolder.btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String teamName = " Pahlawan favoritku adalah "+getTvList().get(i).getTitle();
                intent.putExtra(Intent.EXTRA_TEXT,teamName);
                context.startActivity(Intent.createChooser(intent,"Share Using"));
            }
        });
    }

    @Override
    public int getItemCount() {
        return getTvList().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivThumbail;
        TextView tvTitle;
        Button btnTonton,btnShare;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivThumbail = itemView.findViewById(R.id.team_thumbnail);
            tvTitle = itemView.findViewById(R.id.team_name);
            btnTonton = itemView.findViewById(R.id.btn_tonton);
            btnShare = itemView.findViewById(R.id.btn_share);
        }
    }
}


