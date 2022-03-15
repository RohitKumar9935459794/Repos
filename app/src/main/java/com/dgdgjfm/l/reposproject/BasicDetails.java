package com.dgdgjfm.l.reposproject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.dgdgjfm.l.reposproject.databinding.ActivityBasicDetailsBinding;
import com.dgdgjfm.l.reposproject.model.Users;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.FirebaseDatabase;

import java.util.concurrent.TimeUnit;

public class BasicDetails extends AppCompatActivity {

    ActivityBasicDetailsBinding binding;
    FirebaseAuth auth;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;
    FirebaseDatabase database;
    public String verificationId;
    public String token;
    ProgressDialog progressDialog;
    private static final String TAG =" get some error" ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityBasicDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        database=FirebaseDatabase.getInstance();
        auth=FirebaseAuth.getInstance();
        progressDialog=new ProgressDialog(BasicDetails.this);
        progressDialog.setTitle("You are singUp");
        progressDialog.setMessage("We are sending OTP");

        binding.buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.show();
                if(binding.phone.getText().toString().trim().isEmpty()|| binding.fullName.toString().trim().isEmpty()){
                    progressDialog.dismiss();
                    Toast.makeText(BasicDetails.this, " please enter details", Toast.LENGTH_SHORT).show();
                }else if(binding.phone.getText().toString().trim().length()!=10){
                    progressDialog.dismiss();
                    Toast.makeText(BasicDetails.this, "Please enter Correct number", Toast.LENGTH_SHORT).show();
                } else {
                    otpSend();
                    progressDialog.dismiss();


                }
            }

          
            private void otpSend() {

                mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

                    @Override
                    public void onVerificationCompleted(PhoneAuthCredential credential) {

                    }

                  

                    @Override
                    public void onVerificationFailed(FirebaseException e) {
                        Toast.makeText(BasicDetails.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }


                    @Override
                    public void onCodeSent(@NonNull String verificationId,
                                           @NonNull PhoneAuthProvider.ForceResendingToken token) {
                        Toast.makeText(BasicDetails.this,"Otp send Successfully",Toast.LENGTH_SHORT).show();
                       Intent intent= new Intent(BasicDetails.this,Otp_for_signin.class);
                       intent.putExtra("phone",binding.phone.getText().toString().trim());
                        intent.putExtra("fullName",binding.fullName.getText().toString().trim());
                       intent.putExtra("verificationId",verificationId);
                       startActivity(intent);

                        Users users = new Users(binding.fullName.getText().toString(), binding.phone.getText().toString());
                        database.getReference("Basic Details").child(users.getMobile()).setValue(users);

                    }
                };
                PhoneAuthOptions options =
                        PhoneAuthOptions.newBuilder(auth)
                                .setPhoneNumber("+91"+binding.phone.getText().toString().trim())       // Phone number to verify
                                .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                                .setActivity(BasicDetails.this)                 // Activity (for callback binding)
                                .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
                                .build();
                PhoneAuthProvider.verifyPhoneNumber(options);
            }
        });

        binding.loginText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BasicDetails.this,LoginActivity.class));
            }
        });
    }


}