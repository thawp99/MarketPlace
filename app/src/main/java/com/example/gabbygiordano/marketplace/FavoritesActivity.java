package com.example.gabbygiordano.marketplace;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

import static com.example.gabbygiordano.marketplace.ItemAdapter.getContext;

public class FavoritesActivity extends AppCompatActivity {

    RecyclerView rvFavorites;

    ArrayList<Item> items;
    ItemAdapter itemAdapter;
    String id;

    int ADD_ITEM_REQUEST = 10;

    Context mContext;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites_test);

        getSupportActionBar().setTitle("Favorites");

        context = this;

        // perform find view by id lookups
        rvFavorites = (RecyclerView) findViewById(R.id.rvFavorites);

        // initialize arraylist
        items = new ArrayList<>();

        //construct the adapter from the array list
        itemAdapter = new ItemAdapter(items, getContext());

        mContext = getContext();

        // RecyclerView setup (layout manager, use adapter)
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rvFavorites.setLayoutManager(linearLayoutManager);
        rvFavorites.setAdapter(itemAdapter);
        rvFavorites.setHasFixedSize(true);

        ParseUser user = ParseUser.getCurrentUser();

        addItems(user.<Item>getList("favoritesList"));
    }

    public void addItems(List<Item> list){
        for(int i=0; i< list.size(); i++){
            items.add(list.get(i));
            itemAdapter.notifyItemInserted(items.size()-1);
        }

    }
}
