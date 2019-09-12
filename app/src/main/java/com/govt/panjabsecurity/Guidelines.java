package com.govt.panjabsecurity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class Guidelines extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private GuidelinesAdapter mAdapter;
    final ArrayList<Guidelines_card> cardList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cardList.add(new Guidelines_card(R.drawable.ic_local_shipping,"De-Addiction Centres"));
        cardList.add(new Guidelines_card(R.drawable.ic_storage,"Harmful Effects of Drugs"));
        cardList.add(new Guidelines_card(R.drawable.ic_smoking,"Identifying a Drug User"));
        cardList.add(new Guidelines_card(R.drawable.ic_record_voice,"Advice for Parents"));
        cardList.add(new Guidelines_card(R.drawable.ic_people,"Advice for Students"));
        cardList.add(new Guidelines_card(R.drawable.ic_add,"Major Facts about Narcotics Law"));

        mRecyclerView = findViewById(R.id.guideLinesView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new GuidelinesAdapter(cardList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new GuidelinesAdapter.OnItemClickListener() {
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
