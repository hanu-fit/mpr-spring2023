package edu.hanu.internalservicesdemo.adapters;

import android.content.Context;
import android.hardware.Sensor;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.hanu.internalservicesdemo.R;

public class SensorAdapter extends RecyclerView.Adapter<SensorAdapter.SensorHolder> {
    private List<Sensor> sensors;

    public SensorAdapter(List<Sensor> sensors) {
        this.sensors = sensors;
    }

    @Override
    public int getItemCount() {
        return sensors.size();
    }

    @NonNull
    @Override
    public SensorHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // inflate item view: from xml -> java object -> render into parent
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View itemView = inflater.inflate(R.layout.item_sensor, parent, false);

        return new SensorHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SensorHolder holder, int position) {
        // get data item from dataset at position
        Sensor sensor = sensors.get(position);

        // bind data into view
        holder.bind(sensor);
    }



    // view holder
    public class SensorHolder extends RecyclerView.ViewHolder {

        public SensorHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void bind(Sensor sensor) {
            TextView tvName = itemView.findViewById(R.id.tvName);

            tvName.setText(sensor.getName());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(itemView.getContext(), sensor.toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
