package com.example.bus_tracking_app;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class bus_details extends AppCompatActivity {

    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Actionbar Title
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Bus Details");
        setContentView(R.layout.activity_bus_details);

        listView = findViewById(R.id.list);
        String []buses = {"Vit To Bhopla","Vit to Aasta","Vit to Sehore"};
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, buses);
        listView.setAdapter(arrayAdapter);

    }
}