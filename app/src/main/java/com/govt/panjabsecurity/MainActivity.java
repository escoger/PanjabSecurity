package com.govt.panjabsecurity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private CardAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    final ArrayList<CardItem> cardList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cardList.add(new CardItem(R.drawable.ic_local_shipping,"Shippment Comming/Going"));
        cardList.add(new CardItem(R.drawable.ic_storage,"Storage of Drugs"));
        cardList.add(new CardItem(R.drawable.ic_smoking,"Usage of Drugs"));
        cardList.add(new CardItem(R.drawable.ic_record_voice,"Promoting Of Drug Usage"));
        cardList.add(new CardItem(R.drawable.ic_people,"Selling Of Drugs"));
        cardList.add(new CardItem(R.drawable.ic_add,"Others"));


        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new CardAdapter(cardList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);



        mAdapter.setOnItemClickListener(new CardAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                openForm(position);
            }
        });
    }



    public void openForm(int position){
        Intent intent = new Intent(this, ComplainActivity.class);
        startActivityForResult(intent,0);
    }


}
