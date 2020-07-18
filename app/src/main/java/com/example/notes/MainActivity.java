package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText et;
    private Button b;
    public static final String SP = "shapre";
    public static final String TEXT =  "text";
    private String s, e;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = (EditText)findViewById(R.id.et);
        b = (Button)findViewById(R.id.b);
        et.setEnabled(false);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e = b.getText().toString();
                if (e.equals("Edit")){
                    et.setEnabled(true);
                    b.setText("Save");

                }
                if(e.equals("Save")){
                    et.setEnabled(false);
                    b.setText("Edit");
                    save();

                }
            }
        });
        load();
        set();
    }

    private void set() {
        et.setText(s);
    }

    private void load() {
        SharedPreferences p = getSharedPreferences(SP,MODE_PRIVATE);
        s = p.getString(TEXT, " ");
    }

    private void save() {
        SharedPreferences p = getSharedPreferences(SP,MODE_PRIVATE);
        SharedPreferences.Editor e = p.edit();
        e.putString(TEXT,et.getText().toString());
        e.apply();
    }
}
