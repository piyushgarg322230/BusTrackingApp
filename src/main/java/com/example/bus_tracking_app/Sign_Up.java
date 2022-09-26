package com.example.bus_tracking_app;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Sign_Up extends AppCompatActivity {
    Button sinup;
    EditText userName,registrationId,emailId,mobileNumber,passWord,returnPassword;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        //Actionbar
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Bus Tracking");
        sinup=(Button) findViewById(R.id.signup);
        userName=(EditText) findViewById(R.id.regitrationNo);
        registrationId=(EditText) findViewById(R.id.Registration_Id);
        emailId=(EditText) findViewById(R.id.Email_Id);
        mobileNumber=(EditText) findViewById(R.id.Mobile_Number);
        passWord=(EditText) findViewById(R.id.Password);
        returnPassword=(EditText) findViewById(R.id.Re_Password);
        sinup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseDatabase= FirebaseDatabase.getInstance();
                databaseReference = firebaseDatabase.getReference("Users");
                String userN = userName.getText().toString();
                String reId = registrationId.getText().toString();
                String eId = emailId.getText().toString();
                String mobileN = mobileNumber.getText().toString();
                String passW = passWord.getText().toString();
                String rerturnPass = returnPassword.getText().toString();
                HelperClass helperClass = new HelperClass(userN,reId,eId,mobileN,passW,rerturnPass);
                databaseReference.child(reId).setValue(helperClass);
                if(userN!=null && passW!=null){
                    Intent intent=new Intent(Sign_Up.this,Sign_In.class);
                    startActivity(intent);
                }
            }
        });

    }
}