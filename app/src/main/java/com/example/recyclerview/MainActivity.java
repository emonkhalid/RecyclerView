package com.example.recyclerview;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TimeAdapter adapter;
    private RecyclerView rv;
    private List<TimeStamp>timeStampList = new ArrayList<>();
    private LinearLayoutManager layoutManager;
    private GridLayoutManager gridLayoutManager;
    private StaggeredGridLayoutManager sgm;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.timeRV);
        fab = findViewById(R.id.addFab);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        //layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        gridLayoutManager = new GridLayoutManager(this,3);
        sgm = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        //rv.setLayoutManager(layoutManager);
        rv.setLayoutManager(sgm);
        //rv.setLayoutManager(gridLayoutManager);
        adapter = new TimeAdapter(this,timeStampList);
        rv.setAdapter(adapter);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long time = System.currentTimeMillis();
                TimeStamp timeStamp = new TimeStamp(String.valueOf(time));
                timeStampList.add(timeStamp);
                adapter.updateList(timeStampList);
            }
        });





    }
}
