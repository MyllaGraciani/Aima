package com.ai.app.aima.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.ai.app.aima.R;
import com.ai.app.aima.activity.List_Activity;


public class NotesFragment extends Fragment {
    private static int btnNotesId;
    private Button btnNotes;
    private Button btnHumor;
    private Button btnSintoma;

    public static int getBtnNotesId() {
        return btnNotesId;
    }

    public void setBtnNotesId(int btnId) {
        NotesFragment.btnNotesId = btnId;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notes, container, false);

        btnNotes = view.findViewById(R.id.nt_btnNotes);
        btnHumor = view.findViewById(R.id.nt_btnHumor);
        btnSintoma = view.findViewById(R.id.nt_btnSintoma);

        btnNotes.setOnClickListener(v -> {
            Intent i = new Intent(getActivity(), List_Activity.class);
            startActivity(i);
            setBtnNotesId(1);
        });

        btnHumor.setOnClickListener(v -> {
            Intent i = new Intent(getActivity(), List_Activity.class);
            startActivity(i);
            setBtnNotesId(2);
        });

        btnSintoma.setOnClickListener(v -> {
            Intent i = new Intent(getActivity(), List_Activity.class);
            startActivity(i);
            setBtnNotesId(3);
        });

        return view;
    }

}