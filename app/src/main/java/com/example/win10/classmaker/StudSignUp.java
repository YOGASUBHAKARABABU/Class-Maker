package com.example.win10.classmaker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;

public class StudSignUp extends AppCompatActivity {

    String base_url = "https://classmaker-9baea.firebaseio.com/";
    Firebase fb_db;
    EditText username,password;
    Spinner dep;
    TextView signup;
    String uname,upass,udep;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stud_sign_up);
        Firebase.setAndroidContext(this);
        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        dep=(Spinner) findViewById(R.id.dep);
        signup=(TextView)findViewById(R.id.signup);
        Firebase.setAndroidContext(this);
        final String citie[]={"CSE","IT","EEE"};
        ArrayAdapter<String> l=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,citie);
        dep.setAdapter(l);

        dep.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });


        fb_db = new Firebase(base_url);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uname=username.getText().toString();
                upass=password.getText().toString();
                udep=dep.getSelectedItem().toString();
                CredUpdate credUpdate = new CredUpdate();
                credUpdate.setUsername(uname);
                credUpdate.setPassword(upass);
                credUpdate.setDept(udep);

                fb_db.child("StudCreds").child(uname).setValue(credUpdate);


                Intent i=new Intent(getApplicationContext(),Student.class);
                Toast.makeText(getApplicationContext(),"Account Created",Toast.LENGTH_SHORT).show();
                startActivity(i);
                finish();






            }
        });
    }
}
