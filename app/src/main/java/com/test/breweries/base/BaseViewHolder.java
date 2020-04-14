package com.test.breweries.base;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.test.breweries.model.Brewery;

public abstract class BaseViewHolder
        extends RecyclerView.ViewHolder
{
    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
        bindView(itemView);
    }

    public abstract void bindView(View view);
    public abstract void bind(Brewery brewery);
}
