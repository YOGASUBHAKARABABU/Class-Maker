package com.example.win10.classmaker;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

/**
 * Created by WIN 10 on 25-06-2017.
 */

public class tech extends AppCompatActivity {

    ListView k;
    String cities[]={"CSE","IT","EEE"};
    Integer c[]={R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tech);
        CustomList customList = new CustomList(this, cities, c);

        k = (ListView) findViewById(R.id.k);
        k.setAdapter(customList);

        k.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "You Clicked " + cities[i], Toast.LENGTH_SHORT).show();

                Intent z = new Intent(getApplicationContext(), test.class);
                z.putExtra("k", cities[i]);

                startActivity(z);
            }
        });

    }
}
