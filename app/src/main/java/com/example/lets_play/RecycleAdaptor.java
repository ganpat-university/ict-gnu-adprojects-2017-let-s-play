package com.example.lets_play;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class RecycleAdaptor extends RecyclerView.Adapter<RecycleAdaptor.RecycleViewHolder> {

    private String place;
    private String title;
    private String time;
    private String date;
    private RecycleViewHolder view;     //not in use

    public RecycleAdaptor(String place, String title, String time, String date)
    {
        this.place = place;
        this.title = title;
        this.time = time;
        this.date = date;
    }
    @NonNull
    @Override
    public RecycleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       /* LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.post_row,parent,false);
        return new RecycleViewHolder(view);*/
       return view;     //not in use
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewHolder recycleViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class RecycleViewHolder extends RecyclerView.ViewHolder{

        public RecycleViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }


}
