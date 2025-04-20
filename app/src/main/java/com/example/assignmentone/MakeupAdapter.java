package com.example.assignmentone;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MakeupAdapter extends RecyclerView.Adapter<MakeupAdapter.ViewHolder> {

    private Context context;
    private List<Makeup> makeupList;

    public MakeupAdapter(Context context, List<Makeup> makeupList) {
        this.context = context;
        this.makeupList = makeupList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txtName, txtBrand, txtPrice;
        Button btnAdd;

        public ViewHolder( View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            txtName = itemView.findViewById(R.id.txtName);
            txtBrand = itemView.findViewById(R.id.txtBrand);
            txtPrice = itemView.findViewById(R.id.txtDuration);
            btnAdd = itemView.findViewById(R.id.btn);
        }
    }


    @Override
    public MakeupAdapter.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_make_up_part, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder( MakeupAdapter.ViewHolder holder, int position) {
        Makeup makeup = makeupList.get(position);

        holder.img.setImageResource(makeup.getImageId());
        holder.txtName.setText(makeup.getName());
        holder.txtBrand.setText(makeup.getBrand());
        holder.txtPrice.setText("$" + makeup.getPrice());

        holder.btnAdd.setOnClickListener(v -> {

            Toast.makeText(context, makeup.getName() + " item has been added to cart", Toast.LENGTH_SHORT).show();

            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
            SharedPreferences.Editor editor = prefs.edit();

            String jsonCartMakeup = prefs.getString("cart", "");
            List<Makeup> MakeupListCart = new ArrayList<>();

            if (!jsonCartMakeup.equals("")) {

                Gson gson = new Gson();
                Makeup[] existingItems = gson.fromJson(jsonCartMakeup, Makeup[].class);
                MakeupListCart = new ArrayList<>(Arrays.asList(existingItems));
            }


            boolean alreadyExists = false;
            if (!alreadyExists) {

                MakeupListCart.add(makeup);

                String MakeupUpdateCart = new Gson().toJson(MakeupListCart);
                editor.putString("cart", MakeupUpdateCart);
                editor.apply();
            }
        });
    }

    @Override
    public int getItemCount() {
        return makeupList.size();
    }
}
