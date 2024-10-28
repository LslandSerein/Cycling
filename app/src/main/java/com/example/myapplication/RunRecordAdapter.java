package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class RunRecordAdapter extends RecyclerView.Adapter<RunRecordAdapter.ViewHolder> {
    private List<RunRecordEntity> records;

    public RunRecordAdapter(List<RunRecordEntity> records) {
        this.records = records;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_run_record, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RunRecordEntity record = records.get(position);
        holder.runTimeTextView.setText("时间: " + record.runTime);
        holder.durationTextView.setText("时长: " + record.duration / 1000 + "秒");
        holder.speedTextView.setText("速度: " + record.speed + "分钟/千米");
        holder.distanceTextView.setText("路程: " + record.distance + "米");
    }


    @Override
    public int getItemCount() {
        return records.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView runTimeTextView, durationTextView, speedTextView, distanceTextView;

        ViewHolder(View itemView) {
            super(itemView);
            runTimeTextView = itemView.findViewById(R.id.run_time);
            durationTextView = itemView.findViewById(R.id.duration);
            speedTextView = itemView.findViewById(R.id.speed);
            distanceTextView = itemView.findViewById(R.id.distance);
        }
    }
}
