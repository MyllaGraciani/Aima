package com.ai.app.aima.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.ai.app.aima.EditarPerfil_Activity;
import com.ai.app.aima.R;
import com.ai.app.aima.firebase.UsuarioFirebase;
import com.ai.app.aima.model.Usuario;
import com.google.firebase.auth.FirebaseUser;


public class PerfilFragment extends Fragment {
    private Button btnEditarPerfil;
    private TextView txtNome;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);

        btnEditarPerfil = view.findViewById(R.id.pf_btnEditarPerfil);
        txtNome = view.findViewById(R.id.pf_txtNome);

        //Recuperar dados do usuario
        FirebaseUser usuarioPerfil = UsuarioFirebase.getUsuarioAtual();
        txtNome.setText(usuarioPerfil.getDisplayName());



        btnEditarPerfil.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), EditarPerfil_Activity.class);
            startActivity(intent);
        });

        return view;
    }

}

