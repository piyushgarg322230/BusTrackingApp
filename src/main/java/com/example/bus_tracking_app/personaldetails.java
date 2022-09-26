package com.example.bus_tracking_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class personaldetails extends AppCompatActivity {
    TextView name,emailId,mobileNumber,registerNo,passWord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Actionbar Title
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Personal Detail");
        //
        setContentView(R.layout.activity_personaldetails);
        name=findViewById(R.id.name);
        emailId=findViewById(R.id.emailId);
        mobileNumber=findViewById(R.id.mobileNumber);
        registerNo=findViewById(R.id.registrationNumber);
        passWord=findViewById(R.id.password);
        Intent intent=getIntent();
        String regNo=intent.getStringExtra("Id");
        DatabaseReference reference= FirebaseDatabase.getInstance().getReference("Users");
        Query checkUser=reference.orderByChild("reId").equalTo(regNo);
        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    String passwordDb=dataSnapshot.child(regNo).child("passW").getValue(String.class);

                       String emailDb=dataSnapshot.child(regNo).child("eId").getValue(String.class);
                       String mobileNDb=dataSnapshot.child(regNo).child("mobileN").getValue(String.class);
                        String registrationDb=dataSnapshot.child(regNo).child("reId").getValue(String.class);
                        String userNameDb=dataSnapshot.child(regNo).child("userN").getValue(String.class);
                        name.setText(userNameDb);
                        emailId.setText(emailDb);
                        mobileNumber.setText(mobileNDb);
                        registerNo.setText(registrationDb);
                        passWord.setText(passwordDb);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}