package com.example.gabbygiordano.marketplace.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.gabbygiordano.marketplace.Item;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.List;

/**
 * Created by tanvigupta on 7/17/17.
 */

public class ElectronicsTimelineFragment extends ItemsListFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        populateElectronicsTimeline();
    }

    public void populateElectronicsTimeline() {
        ParseQuery<Item> query = ParseQuery.getQuery(Item.class);
        query.include("owner");
        query.orderByDescending("_created_at");
        query.whereEqualTo("type", "Electronics");
        query.findInBackground(new FindCallback<Item>() {
            public void done(List<Item> itemsList, ParseException e) {
                if (e == null) {
                    if (!itemsList.isEmpty()) {
                        addItems(itemsList);
                    }
                } else {
                    Log.d("ElectronicsFragment", e.getMessage());
                }
            }
        });
    }
}