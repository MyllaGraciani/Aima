package com.ai.app.aima.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import com.ai.app.aima.R;
import com.ai.app.aima.activity.Sintomas_Activity;


public class IdeiasFragment extends Fragment {
    private Button btnSintomas;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ideias, container, false);

        btnSintomas = view.findViewById(R.id.ia_btnSintomas);

        btnSintomas.setOnClickListener(v -> {
            Intent i = new Intent(getActivity(), Sintomas_Activity.class);
            startActivity(i);
        });

        return view;
    }




}