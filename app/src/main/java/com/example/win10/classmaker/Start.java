package com.example.win10.classmaker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Start extends AppCompatActivity {
     RelativeLayout l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        l=(RelativeLayout)findViewById(R.id.activity_start);
        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"WELCOME",Toast.LENGTH_SHORT).show();
                Intent i =new Intent(getBaseContext(),MainActivity.class);
                startActivity(i);
            }
        });
    }
}
