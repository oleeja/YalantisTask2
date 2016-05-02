package com.kitsyambochka.yalantistask2.activities;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.kitsyambochka.yalantistask2.R;
import com.kitsyambochka.yalantistask2.adapters.InfoAdapterForRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class InfoActivity extends AppCompatActivity {

    @Bind(R.id.info_toolbar) Toolbar mToolbar;
    @Bind(R.id.textViewEconomy) TextView mTvEconomy;
    @Bind(R.id.textViewInWork) TextView mTvInWork;
    @Bind(R.id.textViewCreatedDate) TextView mTvCreatedDate;
    @Bind(R.id.textViewRegisteredDate) TextView mTvRegisteredDate;
    @Bind(R.id.textViewDecisionDate) TextView mTvDecisionDate;
    @Bind(R.id.textViewResponsibleName) TextView mTvResponsibleName;
    @Bind(R.id.textViewDescription) TextView mTvDescription;
    @Bind(R.id.textViewCreated) TextView mTvCreated;
    @Bind(R.id.textViewRegistered) TextView mTvRegistered;
    @Bind(R.id.textViewDecision) TextView mTvDecision;
    @Bind(R.id.textViewResponsible) TextView mTvResponsible;
    @Bind(R.id.info_recyclerView) RecyclerView mRecyclerView;

    private List<Uri> mImageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle(R.string.screen_name);

        mImageUri = new ArrayList<>();

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        setValues();

        addListeners();
    }

    private void setValues() {

        for (String i : getResources().getStringArray(R.array.link_photo)) {
            mImageUri.add(Uri.parse(i));
        }

        mTvEconomy.setText(R.string.economy_name);
        mTvInWork.setText(R.string.in_work_name);
        mTvCreatedDate.setText(R.string.created_name);
        mTvRegisteredDate.setText(R.string.registered_name);
        mTvDecisionDate.setText(R.string.decision_date_name);
        mTvResponsibleName.setText(R.string.responsible_name);
        mTvDescription.setText(R.string.description_name);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        InfoAdapterForRecyclerView adapter = new InfoAdapterForRecyclerView(mImageUri, this);
        mRecyclerView.setAdapter(adapter);
    }

    private void addListeners() {

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(InfoActivity.this, v.getClass().getSimpleName(), Toast.LENGTH_SHORT)
                        .show();
            }
        };

        mTvEconomy.setOnClickListener(onClickListener);
        mTvInWork.setOnClickListener(onClickListener);
        mTvCreatedDate.setOnClickListener(onClickListener);
        mTvRegisteredDate.setOnClickListener(onClickListener);
        mTvDecisionDate.setOnClickListener(onClickListener);
        mTvResponsibleName.setOnClickListener(onClickListener);
        mTvDescription.setOnClickListener(onClickListener);
        mTvCreated.setOnClickListener(onClickListener);
        mTvRegistered.setOnClickListener(onClickListener);
        mTvDecision.setOnClickListener(onClickListener);
        mTvResponsible.setOnClickListener(onClickListener);

        mToolbar.setOnClickListener(onClickListener);

        mRecyclerView.setOnClickListener(onClickListener);
    }
}
