package com.example.win10.classmaker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class stud extends AppCompatActivity {
   TextView welcome;
    ListView listView;
    String u;

    String[] gang={"TEST1","TEST2","TEST3"};
    Integer[] g={R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stud);
        welcome=(TextView)findViewById(R.id.Welcome);

         u=getIntent().getExtras().getString("k");
        welcome.setText("Welcome "+u+"!");

        CustomList customList = new CustomList(this, gang,g);

        listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(customList);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                                Toast.makeText(getApplicationContext(), "You Clicked " + gang[i], Toast.LENGTH_SHORT).show();

                                                Intent z=new Intent(getApplicationContext(),marks.class);
                                                z.putExtra("k",u);
                                                z.putExtra("l",gang[i]);
                                                startActivity(z);
                                            }
        });
    }
}
