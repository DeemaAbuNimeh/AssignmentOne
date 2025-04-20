package com.example.assignmentone;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LogInScreen extends AppCompatActivity {
    TextView tf;
    Button btn;
    private SharedPreferences makeupSharedPrefz;
    private SharedPreferences.Editor editor;
    public static final String userName = "NAME";
    public static final String userPass = "PASS";
    public static final String OnOffFLAG = "FLAG";
    private RadioButton rad;
    private boolean flag = false;
    EditText editTextusername;
    EditText editTextpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_log_in_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tf=findViewById(R.id.textView5);
        editTextusername=findViewById(R.id.editTextText);
        editTextpassword=findViewById(R.id.editTextText5);
        btn=findViewById(R.id.button);
        rad = findViewById(R.id.radioButton);
        setupSharedPrefs();
        ifprefarechecked();
        tf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogInScreen.this,SignUpScreen.class);
                startActivity(intent);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextusername.getText().toString();
                String password = editTextpassword.getText().toString();

                if (rad.isChecked()) {
                    editor.putString(userName, name);
                    editor.putString(userPass, password);
                    editor.putBoolean(OnOffFLAG, true);
                    editor.commit();
                }

                Intent intent = new Intent(LogInScreen.this, Navigation.class);
                startActivity(intent);
            }
        });




    }

    private void setupSharedPrefs() {
        makeupSharedPrefz = PreferenceManager.getDefaultSharedPreferences(this);
        editor = makeupSharedPrefz.edit();
    }

    private void ifprefarechecked() {
        flag = makeupSharedPrefz.getBoolean(OnOffFLAG, false);

        if(flag){
            String name = makeupSharedPrefz.getString(userName, "");
            String password = makeupSharedPrefz.getString(userPass, "");
            editTextusername.setText(name);
            editTextpassword.setText(password);
            rad.setChecked(true);
        }

    }




}