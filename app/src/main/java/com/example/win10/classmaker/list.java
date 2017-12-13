package com.example.win10.classmaker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class list extends AppCompatActivity {
     EditText et;
    Button button;
    String name;
    String test;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        et=(EditText)findViewById(R.id.et);
        button=(Button)findViewById(R.id.button);
        test=getIntent().getExtras().getString("l");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               name=et.getText().toString();
                Intent i=new Intent(getApplicationContext(),markentry.class);
                i.putExtra("k",name);
                i.putExtra("l",test);
                startActivity(i);
            }
        });



    }
}
