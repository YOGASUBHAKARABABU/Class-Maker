package com.example.win10.classmaker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.win10.classmaker.R.id.textView13;

public class MainActivity extends AppCompatActivity {
    TextView textView,textView2,textView12;
    ImageView imageView,imageView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            textView=(TextView)findViewById(R.id.textView);
            textView2=(TextView)findViewById(R.id.textView2);
            textView12=(TextView)findViewById(R.id.textView13);
            imageView=(ImageView)findViewById(R.id.imageView6);
            imageView1=(ImageView)findViewById(R.id.imageView8);
            imageView.setImageResource(R.drawable.images);
            imageView1.setImageResource(R.drawable.download);


        textView2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(),"Clicked Student",Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(MainActivity.this,Student.class);
                    startActivity(i);
                    finish();
                }
            });

            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(),"Clicked Staff",Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(MainActivity.this,Teacher.class);
                    startActivity(i);
                   finish();

                }
            });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Clicked Student",Toast.LENGTH_SHORT).show();
                Intent i=new Intent(MainActivity.this,Student.class);
                startActivity(i);
                finish();
            }
        });

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Clicked Staff",Toast.LENGTH_SHORT).show();
                Intent i=new Intent(MainActivity.this,Teacher.class);
                startActivity(i);
                finish();

            }
        });
    }
}
