package com.example.win10.classmaker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;

public class TeachSignUp extends AppCompatActivity {
    String base_url = "https://classmaker-9baea.firebaseio.com/";
    Firebase fb_db;

    EditText username,password;
    TextView signup;
    String uname,upass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        setContentView(R.layout.activity_teach_sign_up);
        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        signup=(TextView)findViewById(R.id.signup);

        Firebase.setAndroidContext(this);
        fb_db = new Firebase(base_url);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uname=username.getText().toString();
                upass=password.getText().toString();
                CredUpdate credUpdate = new CredUpdate();
                credUpdate.setUsername(uname);
                credUpdate.setPassword(upass);
                fb_db.child("TeachCreds").child(uname).setValue(credUpdate);
                Intent i=new Intent(getApplicationContext(),Teacher.class);
                Toast.makeText(getApplicationContext(),"Account Created",Toast.LENGTH_SHORT).show();
                startActivity(i);
                finish();


            }
        });
    }
}
