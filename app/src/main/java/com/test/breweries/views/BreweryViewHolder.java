package com.test.breweries.views;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.test.breweries.R;
import com.test.breweries.base.BaseViewHolder;
import com.test.breweries.model.Brewery;

public class BreweryViewHolder extends BaseViewHolder
{
    TextView name_brewery_tv;
    TextView phone_tv;
    TextView website_tv;
    TextView country_tv;
    TextView state_tv;
    TextView city_tv;
    TextView street_tv;

    public BreweryViewHolder(@NonNull View itemView) {
        super(itemView);
        bindView(itemView);
    }

    @Override
    public void bind(Brewery brewery) {
        name_brewery_tv.setText(brewery.getName());
        city_tv.setText(brewery.getCity());
        country_tv.setText(brewery.getCountry());
        phone_tv.setText(brewery.getPhone());
        state_tv.setText(brewery.getState());
        street_tv.setText(brewery.getStreet());
        website_tv.setText(brewery.getWebsite_url());
    }

    @Override
    public void bindView(View view) {
        name_brewery_tv = view.findViewById(R.id.tv_name_brewery);
        phone_tv = view.findViewById(R.id.tv_phone);
        website_tv = view.findViewById(R.id.tv_website);
        country_tv = view.findViewById(R.id.tv_country);
        state_tv = view.findViewById(R.id.tv_state);
        city_tv = view.findViewById(R.id.tv_city);
        street_tv = view.findViewById(R.id.tv_street);
    }
}
