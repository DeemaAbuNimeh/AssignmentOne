package com.example.assignmentone;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cart extends AppCompatActivity {
    private static final String CART_PREFS_KEY = "cart";
    List<Makeup> makeupcartz = new ArrayList<>();
    SharedPreferences makeuppreferences;
    Button makeupBUYYY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);


        makeuppreferences = PreferenceManager.getDefaultSharedPreferences(this);


        loadMakeupCartItems();
        makeupBUYYY =findViewById(R.id.button7);
        makeupBUYYY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (makeupcartz.isEmpty()) {
                    Toast.makeText(Cart.this, "Your cart is empty,Please add makeup", Toast.LENGTH_SHORT).show();
                } else {

                    makeupcartz.clear();
                    saveCartItems();
                    Toast.makeText(Cart.this, "Purchase successful gorg!!!", Toast.LENGTH_SHORT).show();


                }
            }
        });


        RecyclerView recyclerViewmakeup = findViewById(R.id.recyclerView);
        recyclerViewmakeup.setLayoutManager(new LinearLayoutManager(this));

        // Setup the adapter for RecyclerView
        RecyclerView.Adapter recyclerViewAdapter = new RecyclerView.Adapter<RecyclerView.ViewHolder>() {

            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_cart_part, parent, false);
                return new RecyclerView.ViewHolder(itemView) {};
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                Makeup makeup = makeupcartz.get(position);

                // Bind data to the view
                ImageView img = holder.itemView.findViewById(R.id.img);
                TextView txtName = holder.itemView.findViewById(R.id.txtName);
                TextView txtBrand = holder.itemView.findViewById(R.id.txtBrand);
                TextView txtPrice = holder.itemView.findViewById(R.id.txtDuration);

                img.setImageResource(makeup.getImageId());
                txtName.setText(makeup.getName());
                txtBrand.setText(makeup.getBrand());
                txtPrice.setText("$" + makeup.getPrice());
            }

            @Override
            public int getItemCount() {
                return makeupcartz.size();
            }

        };

        recyclerViewmakeup.setAdapter(recyclerViewAdapter);



    }

    private void loadMakeupCartItems() {
        String cartJson = makeuppreferences.getString(CART_PREFS_KEY, ""); // Default to empty string
        if (!cartJson.isEmpty()) {
            Gson gson = new Gson();
            Makeup[] items = gson.fromJson(cartJson, Makeup[].class);
            makeupcartz = new ArrayList<>(Arrays.asList(items));
        }
    }


    private void saveCartItems() {
        Gson gson = new Gson();
        String updatedCart = gson.toJson(makeupcartz);
        SharedPreferences.Editor editor = makeuppreferences.edit();
        editor.putString(CART_PREFS_KEY, updatedCart);
        editor.apply();
    }


    public void addItemToCart(Makeup newItem) {
        makeupcartz.add(newItem);
        saveCartItems();
        Toast.makeText(this, "Item has been added to cart", Toast.LENGTH_SHORT).show();
    }


}
