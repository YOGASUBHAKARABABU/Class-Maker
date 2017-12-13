package com.example.win10.classmaker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class test extends AppCompatActivity {

    ListView ka;
    String dept;
    String tests[]={"TEST1","TEST2","TEST3"};
    Integer c[]={R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        dept=getIntent().getExtras().getString("k");
        CustomList customList = new CustomList(this, tests, c);

        ka = (ListView) findViewById(R.id.ka);
        ka.setAdapter(customList);

        ka.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "You Clicked " + tests[i], Toast.LENGTH_SHORT).show();

                Intent z = new Intent(getApplicationContext(), list.class);
                z.putExtra("l", tests[i]);
                z.putExtra("k", dept);

                startActivity(z);
            }
        });


    }
}
