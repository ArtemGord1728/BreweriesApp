package com.test.breweries.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.test.breweries.App;
import com.test.breweries.R;
import com.test.breweries.dao.BreweryDao;
import com.test.breweries.model.Brewery;
import com.test.breweries.views.BreweriesAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;


public class MainActivity extends AppCompatActivity implements MainView
{
    private final ArrayList<Brewery> breweriesList = new ArrayList<>();

    private EditText editText;
    private RecyclerView recyclerView;
    private BreweriesAdapter breweriesAdapter;
    private ProgressBar progressBar;
    private View errorView;

    @Inject
    BreweryDao breweryDao;

    @Inject
    MainPresenter mainPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        App.getDaggerComponent().inject(this);
        mainPresenter.setView(this);

        initView();

        mainPresenter.showAllBreweries();


        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Toast.makeText(MainActivity.this, "Text - " + s, Toast.LENGTH_SHORT).show();
                //mainPresenter.searchBrewery(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                hideLoading();
            }
        });
    }

    @Override
    public void showError(Throwable throwable) {
        if (throwable != null) {
            errorView.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
            throwable.printStackTrace();
        }
    }

    @Override
    public void initView() {
        recyclerView = findViewById(R.id.recycler_view_list_of_brewery);
        editText = findViewById(R.id.search_edit);
        progressBar = findViewById(R.id.home_progress_bar);
        errorView = findViewById(R.id.error_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        breweriesAdapter = new BreweriesAdapter();

        recyclerView.setAdapter(breweriesAdapter);
        breweriesAdapter.setListCities(breweriesList);
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showData(List<Brewery> breweries) {
        hideLoading();
        breweriesList.addAll(breweries);
    }
}