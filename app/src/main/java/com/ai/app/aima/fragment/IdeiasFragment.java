package com.ai.app.aima.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import com.ai.app.aima.activity.List_Activity;
import com.ai.app.aima.R;


public class IdeiasFragment extends Fragment {
    private static int btnId;
    private Button btnSintomas;
    private Button btnHumores;
    private Button btnLua;
    private Button btnMedicamento;
    private Button btnHigiene;
    private Button btnAutoCuidado;
    private Button btnGraficos;
    private Button btnAlimentacao;

    public static int getBtnId() {
        return btnId;
    }

    public void setBtnId(int btnId) {
        IdeiasFragment.btnId = btnId;
    }

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
        btnHumores = view.findViewById(R.id.ia_btnHumores);

        btnSintomas.setOnClickListener(v -> {
            Intent i = new Intent(getActivity(), List_Activity.class);
            startActivity(i);
            setBtnId(1);
        });

        btnHumores.setOnClickListener(v -> {
            Intent i = new Intent(getActivity(), List_Activity.class);
            startActivity(i);
            setBtnId(2);
        });

        return view;
    }




}