package com.example.win10.classmaker;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class markentry extends AppCompatActivity {
    String base_url;
    Firebase fb_db;
    EditText textView2,textView4,textView6,textView8,textView10;
    String s1,s2,s3,s4,s5;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_markentry);
        Firebase.setAndroidContext(this);
        textView2=(EditText)findViewById(R.id.textView2);
        textView4=(EditText)findViewById(R.id.textView4);
        textView6=(EditText)findViewById(R.id.textView6);
        textView8=(EditText)findViewById(R.id.textView8);
        textView10=(EditText)findViewById(R.id.textView10);
        button2=(Button)findViewById(R.id.button2);
        final String name=getIntent().getExtras().getString("k");
        final String test=getIntent().getExtras().getString("l");

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1=textView2.getText().toString();
                s2=textView4.getText().toString();
                s3=textView6.getText().toString();
                s4=textView8.getText().toString();
                s5=textView10.getText().toString();
                base_url = "https://classmaker-9baea.firebaseio.com/";
                fb_db = new Firebase(base_url);
                Adapter adapter=new Adapter();
                adapter.setM1(s1);
                adapter.setM2(s2);
                adapter.setM3(s3);
                adapter.setM4(s4);
                adapter.setM5(s5);
                fb_db.child(name).child(test).setValue(adapter);
                Toast.makeText(getApplicationContext(),"Updated",Toast.LENGTH_SHORT).show();
                try {


                    Thread.sleep(2000);
                }
                catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(),"ERROR IN THREAD",Toast.LENGTH_SHORT);
                }
                Intent i=new Intent(getApplicationContext(),Start.class);
                startActivity(i);







            }
        });

    }



}
