package com.kitsyambochka.yalantistask2.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kitsyambochka.yalantistask2.activities.InfoActivity;
import com.kitsyambochka.yalantistask2.utils.ItemContainer;
import com.kitsyambochka.yalantistask2.R;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Developer on 16.04.2016.
 */
public class MainListAdapter extends BaseAdapter {
    private List<ItemContainer> mItemList;
    private Context mContext;

    public MainListAdapter(List<ItemContainer> itemList, Context context) {
        mItemList = itemList;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mItemList.size();
    }

    @Override
    public ItemContainer getItem(int position) {
        return mItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.main_item, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.mTvItemEconomy.setText(mItemList.get(position).getEconomy());
        holder.mTvItemAddress.setText(mItemList.get(position).getAddress());
        holder.mTvItemDate.setText(mItemList.get(position).getDate());
        holder.mTvItemDays.setText(mItemList.get(position).getDays());
        holder.mTvItemLike.setText(mItemList.get(position).getLike());
        holder.mTvItemIcon.setImageResource(mItemList.get(position).getIcon());

        return convertView;
    }

    public class ViewHolder {
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

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
