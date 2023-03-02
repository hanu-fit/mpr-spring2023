package edu.hanu.internalservicesdemo.adapters;

import android.content.Context;
import android.hardware.Sensor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.hanu.internalservicesdemo.R;

public class SensorAdapter  extends RecyclerView.Adapter<SensorAdapter.SensorHolder> {
    private List<Sensor> sensors;

    public SensorAdapter(List<Sensor> sensors) {
        this.sensors = sensors;
    }

    @NonNull
    @Override
    public SensorHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.item_sensor, parent, false);

        return new SensorHolder(itemView, context);
    }

    @Override
    public void onBindViewHolder(@NonNull SensorHolder holder, int position) {
        Sensor sensor = sensors.get(position);

        holder.bind(sensor);
    }

    @Override
    public int getItemCount() {
        return sensors.size();
    }

    class SensorHolder extends RecyclerView.ViewHolder {
        private TextView tvName;
        private Context context;


        public SensorHolder(@NonNull View itemView, Context context) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            this.context = context;
        }

        public void bind(Sensor sensor) {
            tvName.setText(sensor.getName());

            tvName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, sensor.toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
