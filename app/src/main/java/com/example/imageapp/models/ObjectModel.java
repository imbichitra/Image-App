package com.example.imageapp.models;

import java.util.List;

public class ObjectModel {
    private int total;
    private int totalHits;
    private List<HitsModel> hits;

    public ObjectModel() {
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotalHits() {
        return totalHits;
    }

    public void setTotalHits(int totalHits) {
        this.totalHits = totalHits;
    }

    public List<HitsModel> getHits() {
        return hits;
    }

    public void setHits(List<HitsModel> hits) {
        this.hits = hits;
    }
}
