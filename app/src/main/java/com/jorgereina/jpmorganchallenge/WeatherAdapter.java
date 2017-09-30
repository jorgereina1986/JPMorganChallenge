package com.jorgereina.jpmorganchallenge;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jorgereina.jpmorganchallenge.Models.Entry;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.ViewHolder> {

    private List<Entry> entryList;
    private Context context;

    public WeatherAdapter(List<Entry> entryList, Context context) {
        this.entryList = entryList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                                      .inflate(R.layout.track_row, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.temp.setText(entryList.get(position).main.temperature);
//        holder.artistTv.setText(entryList.get(position).artistName);
//        holder.albumTv.setText(entryList.get(position).albumName);
//        Picasso.with(context).load(entryList.get(position).getImageUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return entryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

//        @BindView(R.id.album_iv) ImageView imageView;
        @BindView(R.id.temp) TextView temp;
//        @BindView(R.id.artist_tv) TextView artistTv;
//        @BindView(R.id.album_tv) TextView albumTv;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
