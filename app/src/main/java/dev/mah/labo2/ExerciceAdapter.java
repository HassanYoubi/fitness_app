package dev.mah.labo2;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExerciceAdapter extends RecyclerView.Adapter<ExerciceAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Exercice> exerciceArrayList;

    public ExerciceAdapter(ArrayList<Exercice> exerciceArrayList, Context context) {
        this.exerciceArrayList = exerciceArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.exercice_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Exercice exercice = exerciceArrayList.get(position);
        Context context = holder.imgExercice.getContext();
        int imageResource = context.getResources().getIdentifier(exercice.getImage(), "drawable", context.getPackageName());
        holder.imgExercice.setImageResource(imageResource);
        holder.tvTitle.setText(exercice.getTitle());
        holder.tvTime.setText(String.valueOf(exercice.getTime()));
        holder.tvRepeat.setText(exercice.getRepeat());
        if (exercice.getDescription().length() < 45) {
            holder.tvDesc.setText(exercice.getDescription());
        } else {
            holder.tvDesc.setText(exercice.getDescription().substring(0, 45) + "...");
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, DetailActivity.class);
                i.putExtra("idExercice", exercice.getId());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return exerciceArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle, tvTime, tvRepeat, tvDesc;
        ImageView imgExercice;

        public ViewHolder(View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvTime = itemView.findViewById(R.id.tvTime);
            tvRepeat = itemView.findViewById(R.id.tvRepeat);
            tvDesc = itemView.findViewById(R.id.tvDesc);
            imgExercice = itemView.findViewById(R.id.imgExercice);
        }
    }
}