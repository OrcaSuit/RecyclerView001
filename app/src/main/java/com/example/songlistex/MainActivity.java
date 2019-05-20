package com.example.songlistex;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
    RecyclerView recycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler = (RecyclerView)findViewById(R.id.recycler);
        ArrayList<Song> list = new ArrayList<>();

        Song s1 = new Song();
        s1.name = "씨스타";
        s1.title = "Touch My Body";
        s1.type = 2;
        list.add(s1);

        Song s2 = new Song();
        s2.name = "인피니트";
        s2.title = "Back";
        s2.type = 1;
        list.add(s2);

        Song s3 = new Song();
        s3.name = "현아";
        s3.title = "빨개요";
        s3.type = 2;
        list.add(s3);

        Song s4 = new Song();
        s4.name = "싸이";
        s4.title = "강남스타일";
        s4.type = 1;
        list.add(s4);

        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(new SongAdapter(list));
    }

    private class SongAdapter extends RecyclerView.Adapter<SongViewHolder> {
        private ArrayList<Song> list;
        public SongAdapter(ArrayList<Song> list) {
            this.list = list;
        }

        @NonNull
        @Override
        public SongViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_item, viewGroup, false);
            return new SongViewHolder(view);
        }


        @Override
        public void onBindViewHolder(SongViewHolder holder, int position ) {
            Song s = list.get(position);

            holder.title.setText(s.title);
            holder.name.setText(s.name);

            if(s.type==1)
                holder.image.setImageResource(R.drawable.male);
            else if(s.type==2)
                holder.image.setImageResource(R.drawable.female);
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }

    private class SongViewHolder extends RecyclerView.ViewHolder {

        public CircleImageView image;
        public TextView title;
        public TextView name;


        public SongViewHolder(@NonNull View itemView){
            super(itemView);
            image = (CircleImageView) itemView.findViewById(R.id.custom_item_type_image);
            title = (TextView) itemView.findViewById(R.id.custom_item_title);
            name = (TextView) itemView.findViewById(R.id.custom_item_name);
        }
    }

}

