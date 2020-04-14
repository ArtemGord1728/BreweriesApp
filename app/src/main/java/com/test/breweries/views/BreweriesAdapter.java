package com.test.breweries.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.test.breweries.R;
import com.test.breweries.model.Brewery;

import java.util.ArrayList;
import java.util.List;

public class BreweriesAdapter
        extends RecyclerView.Adapter<BreweryViewHolder>
{
    private List<Brewery> breweryList;


    @NonNull
    @Override
    public BreweryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.brewery_card_view, parent, false);
        return new BreweryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BreweryViewHolder holder, int position) {
        Brewery brewery = breweryList.get(position);
        holder.bind(brewery);
    }

    @Override
    public int getItemCount() {
        return breweryList.size();
    }

    public void setListCities(ArrayList<Brewery> breweryList) {
        this.breweryList = breweryList;
        notifyItemRangeInserted(0, breweryList.size());
    }
}
