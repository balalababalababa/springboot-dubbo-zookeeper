package com.example.domain;

import java.io.Serializable;

public class Movie implements Serializable {
    private String date;
    private String movie;
    private String time;
    private Integer priceNormal;
    private Integer priceVip;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getPriceNormal() {
        return priceNormal;
    }

    public void setPriceNormal(Integer priceNormal) {
        this.priceNormal = priceNormal;
    }

    public Integer getPriceVip() {
        return priceVip;
    }

    public void setPriceVip(Integer priceVip) {
        this.priceVip = priceVip;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "date='" + date + '\'' +
                ", movie='" + movie + '\'' +
                ", time='" + time + '\'' +
                ", priceNormal=" + priceNormal +
                ", priceVip=" + priceVip +
                '}';
    }
}
