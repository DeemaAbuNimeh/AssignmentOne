package com.example.assignmentone;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

public class Shop extends AppCompatActivity {

    public static final String DATA = "DATA";
    SharedPreferences MakeupPrefz;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_shop);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setupSharedPrefs();


        Gson gson = new Gson();
        String str = MakeupPrefz.getString(DATA, "");
        Makeup[] makeups;

        if (!str.equals("")) {
            makeups = gson.fromJson(str, Makeup[].class);
        } else {
            DataBase dataBase = new DataBase();
            makeups = dataBase.getMakeup().toArray(new Makeup[0]);

            String json = gson.toJson(makeups);
            editor.putString(DATA, json);
            editor.commit();
        }

        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MakeupAdapter adapter = new MakeupAdapter(this, java.util.Arrays.asList(makeups));
        recyclerView.setAdapter(adapter);
    }

    private void setupSharedPrefs() {
        MakeupPrefz = PreferenceManager.getDefaultSharedPreferences(this);
        editor = MakeupPrefz.edit();
    }
}
