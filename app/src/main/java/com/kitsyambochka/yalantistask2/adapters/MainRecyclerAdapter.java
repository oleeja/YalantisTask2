package com.kitsyambochka.yalantistask2.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kitsyambochka.yalantistask2.R;
import com.kitsyambochka.yalantistask2.activities.InfoActivity;
import com.kitsyambochka.yalantistask2.utils.ItemContainer;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Developer on 14.04.2016.
 */
public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.ViewHolder> {
    private List<ItemContainer> mItemList;
    private Context mContext;

    public MainRecyclerAdapter(List<ItemContainer> itemList, Context context) {
        mItemList = itemList;
        mContext = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.item_economy) TextView mTvItemEconomy;
        @Bind(R.id.item_address) TextView mTvItemAddress;
        @Bind(R.id.item_date) TextView mTvItemDate;
        @Bind(R.id.item_days) TextView mTvItemDays;
        @Bind(R.id.likeSum) TextView mTvItemLike;
        @Bind(R.id.main_icon) ImageView mTvItemIcon;

        @OnClick(R.id.item_layout)
        public void onClickItem() {
            Intent intent = new Intent(mContext, InfoActivity.class);
            mContext.startActivity(intent);
        }

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        ((ViewHolder) holder).mTvItemEconomy.setText(mItemList.get(position).getEconomy());
        ((ViewHolder) holder).mTvItemAddress.setText(mItemList.get(position).getAddress());
        ((ViewHolder) holder).mTvItemDate.setText(mItemList.get(position).getDate());
        ((ViewHolder) holder).mTvItemDays.setText(mItemList.get(position).getDays());
        ((ViewHolder) holder).mTvItemLike.setText(mItemList.get(position).getLike());
        ((ViewHolder) holder).mTvItemIcon.setImageResource(mItemList.get(position).getIcon());
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }
}
