package com.kitsyambochka.yalantistask2.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;

import com.kitsyambochka.yalantistask2.R;
import com.kitsyambochka.yalantistask2.adapters.MainListAdapter;
import com.kitsyambochka.yalantistask2.interfaces.ScrollListener;
import com.kitsyambochka.yalantistask2.utils.ItemContainer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Developer on 16.04.2016.
 */
public class FragmentForListView extends android.support.v4.app.Fragment {
    public final static String ITEMS_COUNT_KEY = "FragmentForListView$ItemsCount";

    private ScrollListener mScrollListener;

    private ListView mListView;

    public static FragmentForListView createInstance(int itemsCount) {
        FragmentForListView fragmentForListView = new FragmentForListView();
        Bundle bundle = new Bundle();
        bundle.putInt(ITEMS_COUNT_KEY, itemsCount);
        fragmentForListView.setArguments(bundle);
        return fragmentForListView;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        mListView = (ListView) inflater.inflate(
                R.layout.list_view_layout, container, false);
        setupListView(mListView);

        mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            int mLastFirstVisibleItem;

            @Override
            public void onScrollStateChanged(AbsListView view,
                                             int scrollState) {
                //TODO: some controls if they will need
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (view.getId() == mListView.getId()) {
                    final int currentFirstVisibleItem = mListView.getFirstVisiblePosition();

                    if (currentFirstVisibleItem > mLastFirstVisibleItem) {
                        mScrollListener.onScrollUp(true);
                    } else if (currentFirstVisibleItem < mLastFirstVisibleItem) {
                        mScrollListener.onScrollUp(false);
                    }
                    mLastFirstVisibleItem = currentFirstVisibleItem;
                }
            }
        });
        return mListView;
    }

    private void setupListView(ListView listView) {
        MainListAdapter listAdapter = new MainListAdapter(createItemList(), getContext());
        listView.setAdapter(listAdapter);
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

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mScrollListener = (ScrollListener) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mScrollListener = null;
    }
}
