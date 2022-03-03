package com.dgdgjfm.l.reposproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.dgdgjfm.l.reposproject.databinding.ActivityLoginWithOtpBinding;
import com.google.firebase.auth.FirebaseAuth;

public class LoginWithOTP extends AppCompatActivity {
     ActivityLoginWithOtpBinding binding;
     FirebaseAuth auth;
    ProgressDialog progressDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLoginWithOtpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        auth=FirebaseAuth.getInstance();
        getSupportActionBar().hide();

        progressDialog=new ProgressDialog(LoginWithOTP.this);
        progressDialog.setTitle("OTP is sending");
        progressDialog.setMessage("OTP is sending your mobile");

        binding.getOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.show();
              if (!binding.inputMobileNumber.getText().toString().trim().isEmpty()) {
                  if ((binding.inputMobileNumber.getText().toString().trim()).length()==10){
                      progressDialog.dismiss();
                      startActivity(new Intent(LoginWithOTP.this,OTP_Activity.class));

                  }else{
                      Toast.makeText(LoginWithOTP.this, "Please enter correct number", Toast.LENGTH_SHORT).show();
                  }
              }else {
                  Toast.makeText(LoginWithOTP.this, "Enter your mobile number ", Toast.LENGTH_SHORT).show();
              }
            }
        });

    }
}