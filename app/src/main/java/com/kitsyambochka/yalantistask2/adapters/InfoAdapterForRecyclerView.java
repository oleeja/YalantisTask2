package com.kitsyambochka.yalantistask2.adapters;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.kitsyambochka.yalantistask2.R;
import com.squareup.picasso.Picasso;
import java.util.List;

/**
 * Created by Developer on 16.03.2016.
 *
 *
 */
public class InfoAdapterForRecyclerView extends RecyclerView.Adapter {

    private List<Uri> mImageUri;
    private Context mContext;

    public InfoAdapterForRecyclerView(List<Uri> imageUri, Context context) {
        mImageUri = imageUri;
        mContext = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView mImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView)itemView.findViewById(R.id.imageView);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        Picasso.with(mContext).load(mImageUri.get(position)).error(R.drawable.no_image)
                .into(((ViewHolder) holder).mImageView);

        ((ViewHolder) holder).mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, v.getClass().getSimpleName(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mImageUri.size();
    }
}