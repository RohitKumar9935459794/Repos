package com.dgdgjfm.l.reposproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.dgdgjfm.l.reposproject.databinding.ActivityLoginWithOtpBinding;
import com.dgdgjfm.l.reposproject.model.Users;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class LoginWithOTP extends AppCompatActivity {
     ActivityLoginWithOtpBinding binding;
     FirebaseAuth auth;
    ProgressDialog progressDialog;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;


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
                      sendOtp();
                      Intent intent= new Intent(LoginWithOTP.this,OTP_Activity.class);
                      intent.putExtra("phone",binding.inputMobileNumber.getText().toString().trim());
                      startActivity(intent);
                  }else{
                      Toast.makeText(LoginWithOTP.this, "Please enter correct number", Toast.LENGTH_SHORT).show();
                  }
              }else {
                  Toast.makeText(LoginWithOTP.this, "Enter your mobile number ", Toast.LENGTH_SHORT).show();
              }
            }
        });



    }
    private void sendOtp(){
        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            @Override
            public void onVerificationCompleted(PhoneAuthCredential credential) {
                signInWithPhoneAuthCredential( credential);
            }

            @Override
            public void onVerificationFailed(FirebaseException e) {

            }

            @Override
            public void onCodeSent(@NonNull String verificationId,
                                   @NonNull PhoneAuthProvider.ForceResendingToken token) {
                Toast.makeText(LoginWithOTP.this,"Otp send Successfully",Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(LoginWithOTP.this,Otp_for_signin.class);
                intent.putExtra("phone",binding.inputMobileNumber.getText().toString().trim());
                intent.putExtra("verificationId",verificationId);
                startActivity(intent);
            }
        };
        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(auth)
                        .setPhoneNumber("+91"+binding.inputMobileNumber.getText().toString().trim())       // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(this)                 // Activity (for callback binding)
                        .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {

        auth.signInWithCredential(credential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(LoginWithOTP.this,"Otp send Successfully",Toast.LENGTH_SHORT).show();
                    Intent intent= new Intent(LoginWithOTP.this,SignUpActivity.class);
                    intent.putExtra("phone",binding.inputMobileNumber.getText().toString().trim());
                    String id=task.getResult().getUser().getUid();
                    intent.putExtra("UserId",id);
                    startActivity(intent);



                }else {
                    Toast.makeText(LoginWithOTP.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}