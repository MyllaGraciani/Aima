package com.ai.app.aima.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.ai.app.aima.R;
import com.ai.app.aima.fragment.IdeiasFragment;

public class IdeiasDirect_Activity extends AppCompatActivity {
    private int btn = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        btn = IdeiasFragment.getBtnId();

        /*if(btn==1){
            setContentView(R.layout.fragment_notes);
        }else if(btn==2){
            setContentView(R.layout.fragment_ciclo);
        }*/
    }
}