package com.ai.app.aima.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import com.ai.app.aima.R;
import com.ai.app.aima.adapter.AdapterLists;
import com.ai.app.aima.fragment.NotesFragment;
import com.ai.app.aima.model.Humores;

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

        btn = NotesFragment.getBtnNotesId();

        if(btn==1){
            adapter = new AdapterLists(Sintomas.initSintomas(getResources()));
            adp(adapter);
        }
        else if(btn==2){
            adapter = new AdapterLists(Sintomas.initSintomas(getResources()));
            adp(adapter);
        }
        else if(btn==3){
            //adapter = new AdapterLists(Humores.initHumores(getResources()));
            adapter = new AdapterLists(Sintomas.initSintomas(getResources()));
            adp(adapter);
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