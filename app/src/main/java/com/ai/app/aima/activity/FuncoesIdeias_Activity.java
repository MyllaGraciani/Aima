package com.ai.app.aima.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ai.app.aima.R;
import com.ai.app.aima.fragment.IdeiasFragment;

public class FuncoesIdeias_Activity extends AppCompatActivity {
    private int btn = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funcoes_ideias);

        btn = IdeiasFragment.getBtnId();

        /*if(btn==1){

        }else if(btn==2){

        }else if(btn==3){

        }else if(btn==4){

        }else if(btn==5){

        }else if(btn==6){

        }else if(btn==7){

        }else if(btn==8){

        }*/
    }

}