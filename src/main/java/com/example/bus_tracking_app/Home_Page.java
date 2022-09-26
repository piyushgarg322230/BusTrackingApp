package com.example.bus_tracking_app;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class Home_Page extends AppCompatActivity {
    TextView showName;
    String id;
    Button personalDetail,seeBusDetail,findBusLocation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Actionbar Title
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Home Page");
        //
        setContentView(R.layout.activity_home_page);
        showName=(TextView) findViewById(R.id.greeting);
        personalDetail=(Button) findViewById(R.id.Personal_Details);
        seeBusDetail=(Button) findViewById(R.id.Bus_Details);
        findBusLocation=(Button) findViewById(R.id.Find_Location);

        personalDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Home_Page.this,personaldetails.class);
                intent.putExtra("Id",id);
                startActivity(intent);
            }
        });
        seeBusDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Home_Page.this,bus_details.class);
                startActivity(intent);
            }
        });
        findBusLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Home_Page.this,MapsActivity.class);
                startActivity(intent);
            }
        });
        Intent intent = getIntent();
        id = intent.getStringExtra("Id");
        String name=intent.getStringExtra("Name");
        showName.setText("Hello, "+name.toUpperCase().charAt(0)+name.toLowerCase().substring(1));

    }
}