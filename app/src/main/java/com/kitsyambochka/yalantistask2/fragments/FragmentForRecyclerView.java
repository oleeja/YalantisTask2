package com.kitsyambochka.yalantistask2.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kitsyambochka.yalantistask2.utils.ItemContainer;
import com.kitsyambochka.yalantistask2.R;
import com.kitsyambochka.yalantistask2.adapters.MainRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Developer on 14.04.2016.
 */
public class FragmentForRecyclerView extends android.support.v4.app.Fragment {
    public final static String ITEMS_COUNT_KEY = "FragmentForRecyclerView$ItemsCount";

    public static FragmentForRecyclerView createInstance(int itemsCount) {
        FragmentForRecyclerView fragmentForRecyclerView = new FragmentForRecyclerView();
        Bundle bundle = new Bundle();
        bundle.putInt(ITEMS_COUNT_KEY, itemsCount);
        fragmentForRecyclerView.setArguments(bundle);
        return fragmentForRecyclerView;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(
                R.layout.recycler_view_layout, container, false);
        setupRecyclerView(recyclerView);
        return recyclerView;
    }

    private void setupRecyclerView(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        MainRecyclerAdapter recyclerAdapter = new MainRecyclerAdapter(createItemList(), getContext());
        recyclerView.setAdapter(recyclerAdapter);
    }

    private List<ItemContainer> createItemList() {
        List<ItemContainer> itemList = new ArrayList<>();
        Bundle bundle = getArguments();
        if (bundle != null) {
            int itemsCount = bundle.getInt(ITEMS_COUNT_KEY);
            for (int i = 0; i < itemsCount / 2; i++) {
                itemList.add(new ItemContainer(getString(R.string.item_economy),
                        getString(R.string.item_address),
                        getString(R.string.item_date), getString(R.string.item_days),
                        String.valueOf(i), R.drawable.ic_list));
                itemList.add(new ItemContainer(
                        getString(R.string.item_second_economy),
                        getString(R.string.item_address),
                        getString(R.string.item_date), getString(R.string.item_days),
                        String.valueOf(i), R.drawable.ic_trash));
            }
        }
        return itemList;
    }
}

