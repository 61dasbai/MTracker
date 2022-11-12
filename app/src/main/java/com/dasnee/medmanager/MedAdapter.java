package com.dasnee.medmanager;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MedAdapter extends RecyclerView.Adapter<MedAdapter.ViewHolder> {

    private List<Med> meds;
    private Context context;

    public MedAdapter(List<Med> meds){
        this.meds = meds;
    }

    @NonNull
    @Override
    public MedAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_med, parent, false);
        context = parent.getContext();

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MedAdapter.ViewHolder holder, int position) {
        holder.getMedNameTV().setText(meds.get(position).getMedName());
        holder.getMedDoseTV().setText(meds.get(position).getMedDose());

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                //Toast.makeText(view.getContext(), meds.get(holder.getAdapterPosition()).getMedName(), Toast.LENGTH_SHORT).show();

                return true;
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MedActivity.class);
                intent.putExtra("medId", meds.get(holder.getAdapterPosition()).getId());
                context.startActivity(intent);
            }
        });

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
