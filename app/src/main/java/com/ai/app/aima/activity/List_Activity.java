package com.ai.app.aima.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.graphics.Color;
import android.os.Bundle;

import android.widget.TextView;

import com.ai.app.aima.R;
import com.ai.app.aima.adapter.AdapterLists;
import com.ai.app.aima.fragment.IdeiasFragment;
import com.ai.app.aima.model.Sintomas;

public class List_Activity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private int btn = 0;
    AdapterLists adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        btn = IdeiasFragment.getBtnId();

        if(btn==1){
            adapter = new AdapterLists(Sintomas.initSintomas(getResources()));
            adp(adapter);
        }
        else if(btn==2){
            setContentView(R.layout.fragment_ciclo);
        }

    }

    public void adp(AdapterLists adapter){
        recyclerView = findViewById(R.id.recView);

        //config recyclerview
        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setHasFixedSize(true);

        recyclerView.setAdapter(adapter);

    }
}