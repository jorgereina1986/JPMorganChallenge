package com.jorgereina.jpmorganchallenge;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jorgereina.jpmorganchallenge.Models.Entry;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.ViewHolder> {

    private List<Entry> entryList;
    private Context context;
    private String location;

    public WeatherAdapter(List<Entry> entryList, String location, Context context) {
        this.entryList = entryList;
        this.location = location;
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
        holder.city.setText(location);
        holder.date.setText(dateFormatter(entryList.get(position).getDt(), "EE MMM dd, yyyy"));
        holder.temp.setText(noDecimals(entryList.get(position).getMain().getTemp()) + "°");
        holder.minTemp.setText("Min " + noDecimals(entryList.get(position).getMain().getTempMin()) + "°");
        holder.humidity.setText("Humidity " + entryList.get(position).getMain().getHumidity());
        holder.description.setText(entryList.get(position).getWeather().get(0).getDescription());
        Picasso.with(context).load(getWeatherIcon(entryList.get(position).getWeather().get(0).getIcon())).into(holder.weatherIcon);
    }

    @Override
    public int getItemCount() {
        return entryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.date) TextView date;
        @BindView(R.id.city) TextView city;
        @BindView(R.id.weather_iv) ImageView weatherIcon;
        @BindView(R.id.temp) TextView temp;
        @BindView(R.id.minTemp) TextView minTemp;
        @BindView(R.id.humidity) TextView humidity;
        @BindView(R.id.description) TextView description;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    private String getWeatherIcon(String iconName) {

        String iconBaseUrl = "http://openweathermap.org/img/w/";
        String iconUrl = "";

        switch (iconName) {

            case "01d":
                iconUrl = iconBaseUrl + "01d.png";
                break;
            case "02d":
                iconUrl = iconBaseUrl + "02d.png";
                break;
            case "03d":
                iconUrl = iconBaseUrl + "03d.png";
                break;
            case "04d":
                iconUrl = iconBaseUrl + "04d.png";
                break;
            case "09d":
                iconUrl = iconBaseUrl + "09d.png";
                break;
            case "10d":
                iconUrl = iconBaseUrl + "10d.png";
                break;
            case "11d":
                iconUrl = iconBaseUrl + "11d.png";
                break;
            case "13d":
                iconUrl = iconBaseUrl + "13d.png";
                break;
            case "50d":
                iconUrl = iconBaseUrl + "50d.png";
                break;
            case "01n":
                iconUrl = iconBaseUrl + "01n.png";
                break;
            case "02n":
                iconUrl = iconBaseUrl + "02n.png";
                break;
            case "03n":
                iconUrl = iconBaseUrl + "03n.png";
                break;
            case "04n":
                iconUrl = iconBaseUrl + "04n.png";
                break;
            case "09n":
                iconUrl = iconBaseUrl + "09n.png";
                break;
            case "10n":
                iconUrl = iconBaseUrl + "10n.png";
                break;
            case "11n":
                iconUrl = iconBaseUrl + "11n.png";
                break;
            case "13n":
                iconUrl = iconBaseUrl + "13n.png";
                break;
            case "50n":
                iconUrl = iconBaseUrl + "50n.png";
                break;
        }

        return iconUrl;
    }

    private String dateFormatter(long dateMilliseconds, String dateFormat) {

        // Create a DateFormatter object for displaying date in specified format.
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);

        // Create a calendar object that will convert the date and time value in milliseconds to date.
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(dateMilliseconds * 1000);
        return formatter.format(calendar.getTime());
    }

    private int noDecimals(float temp) {
        int noDecimal = (int) temp;
        return noDecimal;
    }

}
