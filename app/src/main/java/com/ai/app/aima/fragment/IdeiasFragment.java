package com.ai.app.aima.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import com.ai.app.aima.activity.FuncoesIdeias_Activity;
import com.ai.app.aima.R;


public class IdeiasFragment extends Fragment {
    private static int btnId;
    private Button btnExames;
    private Button btnMetas;
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

        btnMetas = view.findViewById(R.id.ia_btnMetas);
        btnExames = view.findViewById(R.id.ia_btnExames);
        btnLua = view.findViewById(R.id.ia_btnLua);
        btnMedicamento = view.findViewById(R.id.ia_btnMedicamentos);
        btnHigiene = view.findViewById(R.id.ia_btnHigiene);
        btnAutoCuidado = view.findViewById(R.id.ia_btnAutocuidado);
        btnGraficos = view.findViewById(R.id.ia_btnGraficos);
        btnAlimentacao = view.findViewById(R.id.ia_btnAlimentacao);


        btnMetas.setOnClickListener(v -> {
            Intent i = new Intent(getActivity(), FuncoesIdeias_Activity.class);
            startActivity(i);
            setBtnId(1);
        });

        btnExames.setOnClickListener(v -> {
            Intent i = new Intent(getActivity(), FuncoesIdeias_Activity.class);
            startActivity(i);
            setBtnId(2);
        });

        btnLua.setOnClickListener(v -> {
            Intent i = new Intent(getActivity(), FuncoesIdeias_Activity.class);
            startActivity(i);
            setBtnId(3);
        });

        btnMedicamento.setOnClickListener(v -> {
            Intent i = new Intent(getActivity(), FuncoesIdeias_Activity.class);
            startActivity(i);
            setBtnId(4);
        });

        btnHigiene.setOnClickListener(v -> {
            Intent i = new Intent(getActivity(), FuncoesIdeias_Activity.class);
            startActivity(i);
            setBtnId(5);
        });

        btnAutoCuidado.setOnClickListener(v -> {
            Intent i = new Intent(getActivity(), FuncoesIdeias_Activity.class);
            startActivity(i);
            setBtnId(6);
        });

        btnGraficos.setOnClickListener(v -> {
            Intent i = new Intent(getActivity(), FuncoesIdeias_Activity.class);
            startActivity(i);
            setBtnId(7);
        });

        btnAlimentacao.setOnClickListener(v -> {
            Intent i = new Intent(getActivity(), FuncoesIdeias_Activity.class);
            startActivity(i);
            setBtnId(8);
        });


        return view;
    }


}