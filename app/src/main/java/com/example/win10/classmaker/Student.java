package com.example.win10.classmaker;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class Student extends AppCompatActivity {

    String base_url;
    Firebase fb_db;
    EditText user, pass;
    TextView signup;
    TextView login;
    String u, p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        Firebase.setAndroidContext(this);
        user = (EditText) findViewById(R.id.user);
        pass = (EditText) findViewById(R.id.pass);
        signup=(TextView)findViewById(R.id.signup);

        login = (TextView) findViewById(R.id.Login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                u = user.getText().toString();
                p = pass.getText().toString();
               // Intent i=new Intent(getApplicationContext(),stud.class);
              //  startActivity(i);
                if(u.length()>0&&p.length()>0) {
                    base_url = "https://classmaker-9baea.firebaseio.com/StudCreds/" + u + "/";
                       fb_db = new Firebase(base_url);
                       new MyTask().execute();


                }

                else
                {
                    Toast.makeText(getApplicationContext(),"Empty columns",Toast.LENGTH_SHORT).show();
                }






            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),StudSignUp.class);
                startActivity(i);
            }
        });



    }
    private class MyTask extends AsyncTask<String, Integer, String> {

        // Runs in UI before background thread is called
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
//           progressDialog = ProgressDialog.show(getApplicationContext(), "Message", "Please Wait...");

        }

        // This is run in a background thread
        @Override
        protected String doInBackground(String... params)
        {

            fb_db.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot)
                {
                    try {
                        CredUpdate credUpdate = dataSnapshot.getValue(CredUpdate.class);

                        if (credUpdate.getUsername().equals(u) && (credUpdate.getPassword().equals(p))) {
                            Intent i = new Intent(getApplicationContext(), stud.class);
                            i.putExtra("k", u);
                            // progressDialog.dismiss();
                            startActivity(i);

                            finish();
                        } else {
                            Toast.makeText(getApplicationContext(), "Wrong Details ", Toast.LENGTH_SHORT).show();
                        }
                    }
                    catch (Exception e)
                    {
                        Toast.makeText(getApplicationContext(),"Check your details",Toast.LENGTH_SHORT).show();
                    }

                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {
                    Toast.makeText(getApplicationContext(),"Network Error ",Toast.LENGTH_SHORT).show();

                }
            });








            return "SUCCESS";
        }



        // This runs in UI when background thread finishes
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            if(result.equals("SUCCESS")){
                System.out.println("SUCCESS");

//                Toast.makeText(Register.this,"Account Created",Toast.LENGTH_LONG).show();


            }
            else{
//                Toast.makeText(Register.this,"Failed..",Toast.LENGTH_LONG).show();
            }


            // Do things like hide the progress bar or change a TextView
        }
    }


}
