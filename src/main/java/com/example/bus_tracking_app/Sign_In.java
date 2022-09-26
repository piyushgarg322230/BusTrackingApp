package com.example.bus_tracking_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Sign_In extends AppCompatActivity {
    EditText reId1;
    EditText passWord;
    TextView newUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Actionbar Title
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Bus Tracking");
        //
        setContentView(R.layout.activity_sign);
        reId1=(EditText) findViewById(R.id.regitrationNo);
        passWord=(EditText) findViewById(R.id.Password);
        newUser=(TextView) findViewById(R.id.signInToSignUp);
        newUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sign_In.this, Sign_Up.class);
                startActivity(intent);
            }
        });
    }
    public void changeActivity(View view){

        String regNo=reId1.getText().toString();
        String pass=passWord.getText().toString();
        //for the users connectivity
        DatabaseReference reference= FirebaseDatabase.getInstance().getReference("Users");
        Query checkUser=reference.orderByChild("reId").equalTo(regNo);


        //for the Driver connectivity
        DatabaseReference reference1= FirebaseDatabase.getInstance().getReference("Driver");
        Query checkDriver1=reference1.orderByChild("reId").equalTo(regNo);

        //for the user connectivity
        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    checkUserValidity(dataSnapshot,regNo,pass);
                }else{
                    reId1.setError("No Such User Exits");
                    passWord.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        //for the Driver Connectivity
        checkDriver1.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
//                    String passwordDb=dataSnapshot.child(regNo).child("driverPassword").getValue(String.class);
//                    if(pass !=null && passwordDb.equals(pass)){
////                        String emailDb=dataSnapshot.child().child("eId").getValue(String.class);
////                        String mobileNDb=dataSnapshot.child(un).child("mobileN").getValue(String.class);
////                        String registrationDb=dataSnapshot.child(un).child("reId").getValue(String.class);
//                        String driverNameDb=dataSnapshot.child(regNo).child("driverName").getValue(String.class);
//                        Intent intent = new Intent(Sign_In.this, drivermodule.class);
////                        intent.putExtra("Name",driverNameDb);
//                        startActivity(intent);
//                    }
//                    else {
//                        passWord.setError("Wrong Password");
//                        passWord.requestFocus();
//                    }

                    checkDriverValidity(dataSnapshot,regNo,pass);
                }else{
                    reId1.setError("No Such Driver Exits");
                    passWord.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
//        if(un.equals("piyush") && pass.equals("1234"))
//        {
//            Intent intent = new Intent(Sign_In.this, Home_Page.class);
//            startActivity(intent);
//        }
//
//        else {
//            Toast.makeText(this, "Wrong Password", Toast.LENGTH_SHORT).show();
//        }
        //for the
    }
    //check driver validity
    public void checkDriverValidity(DataSnapshot dataSnapshot, String regNo,String pass){
        String passwordDb=dataSnapshot.child(regNo).child("driverPassword").getValue(String.class);

        if(pass !=null && passwordDb.equals(pass)){
            String driverNameDb=dataSnapshot.child(regNo).child("driverName").getValue(String.class);
            Intent intent = new Intent(Sign_In.this, drivermodule.class);
//            intent.putExtra("Id",regNo);
            startActivity(intent);
        }
        else {
            passWord.setError("Wrong Password");
            passWord.requestFocus();
        }
    }

    //check Users validity
    public void checkUserValidity(DataSnapshot dataSnapshot, String regNo,String pass){
        String passwordDb=dataSnapshot.child(regNo).child("passW").getValue(String.class);
        if(pass !=null && passwordDb.equals(pass)){
            String userNameDb=dataSnapshot.child(regNo).child("userN").getValue(String.class);
            Intent intent = new Intent(Sign_In.this, Home_Page.class);
            intent.putExtra("Name",userNameDb);
            intent.putExtra("Id",regNo);

            startActivity(intent);
        }
        else {
            passWord.setError("Wrong Password");
            passWord.requestFocus();
        }
    }

}