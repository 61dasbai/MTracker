package com.dasnee.medmanager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MedAdapter extends RecyclerView.Adapter<MedAdapter.ViewHolder> {

    private ArrayList<Med> meds;

    @NonNull
    @Override
    public MedAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_med, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MedAdapter.ViewHolder holder, int position) {
        holder.getMedNameTV().setText(meds.get(position).getMedName());
        holder.getMedDoseTV().setText(meds.get(position).getMedDose());

        //holder.fillCard(position);

    }

    @Override
    public int getItemCount() {
        return meds.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView medNameTV;
        private final TextView medDoseTV;

        public ViewHolder(@NonNull View view){
            super(view);

            medNameTV = view.findViewById(R.id.medNameTV);
            medDoseTV = view.findViewById(R.id.medDoseTV);
        }

        public void fillCard(int position){

        }

        public TextView getMedNameTV(){
            return medNameTV;
        }
        public TextView getMedDoseTV(){
            return medDoseTV;
        }
    }
}