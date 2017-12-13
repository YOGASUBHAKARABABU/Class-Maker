package com.example.win10.classmaker;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import org.w3c.dom.Text;

public class marks extends AppCompatActivity {
    String base_url;
    Firebase fb_db;
    String name,test;

    TextView textView2,textView4,textView6,textView8,textView10,k;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marks);
        Firebase.setAndroidContext(this);
        name=getIntent().getExtras().getString("k");
        test=getIntent().getExtras().getString("l");
        k=(TextView)findViewById(R.id.k);
        textView2=(TextView)findViewById(R.id.textView2);
        textView4=(TextView)findViewById(R.id.textView4);
        textView6=(TextView)findViewById(R.id.textView6);
        textView8=(TextView)findViewById(R.id.textView8);
        textView10=(TextView)findViewById(R.id.textView10);
        base_url = "https://classmaker-9baea.firebaseio.com/"+name+"/"+test;
        fb_db = new Firebase(base_url);
        new MyTask().execute();

    }

     private class MyTask extends AsyncTask<String, Integer, String> {

        // Runs in UI before background thread is called
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
//           progressDialog = ProgressDialog.show(getApplicationContext(), "Message", "Creating Account...");

        }

        // This is run in a background thread
        @Override
        protected String doInBackground(String... params)
        {

            fb_db.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    try {
                        Adapter adapter = dataSnapshot.getValue(Adapter.class);

                        textView2.setText(adapter.getM1());
                        textView4.setText(adapter.getM2());
                        textView6.setText(adapter.getM3());
                        textView8.setText(adapter.getM4());
                        textView10.setText(adapter.getM5());
                    }
                    catch (NullPointerException e)
                    {
                        textView2.setText("not yet posted");
                        textView4.setText("not yet posted");
                        textView6.setText("not yet posted");
                        textView8.setText("not yet posted");
                        textView10.setText("not yet posted");

                    }

                }




                @Override
                public void onCancelled(FirebaseError firebaseError) {
                    Toast.makeText(getApplicationContext(),"not yet updated",Toast.LENGTH_SHORT).show();

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

//            progressDialog.dismiss();
            // Do things like hide the progress bar or change a TextView
        }
    }

}
