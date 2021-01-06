package com.ai.app.aima.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ai.app.aima.R;
import com.ai.app.aima.model.Sintomas;

import java.util.List;

public class AdapterLists extends RecyclerView.Adapter<AdapterLists.MyViewHolder>{

    private List<Sintomas> sintomasList;

    public AdapterLists(List<Sintomas> sintomasList) {
        this.sintomasList = sintomasList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_list, parent, false);

        return new MyViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        if (sintomasList != null && position < sintomasList.size()) {
            Sintomas sint = sintomasList.get(position);
            holder.sintoma.setText(sint.sintoma);

        }
    }

    @Override
    public int getItemCount() {
        return sintomasList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView sintoma;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            sintoma = itemView.findViewById(R.id.txtSintoma);
        }
    }
}


