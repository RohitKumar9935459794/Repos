package com.dgdgjfm.l.reposproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.dgdgjfm.l.reposproject.databinding.ActivityOtpForSigninBinding;
import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

public class Otp_for_signin extends AppCompatActivity {
      ActivityOtpForSigninBinding binding;
       private String  verificationId;
       private OtpReciver otpReciver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOtpForSigninBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
          editTextInput();
        binding.editTextTextPersonName2.setText(String.format(
          "+91-%s",getIntent().getStringExtra("phone")
        ));
        verificationId=getIntent().getStringExtra("verificationId") ;

        binding.resendOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Otp_for_signin.this, "Otp send Successfully", Toast.LENGTH_SHORT).show();
            }
        });

        binding.vierfy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.vierfy.setVisibility(View.INVISIBLE);
                if(binding.otp12.getText().toString().trim().isEmpty()||
                        binding.otp22.getText().toString().trim().isEmpty()||
                        binding.otp32.getText().toString().trim().isEmpty()||
                        binding.otp42.getText().toString().trim().isEmpty()){
                    Toast.makeText(Otp_for_signin.this, "please enter otp", Toast.LENGTH_SHORT).show();
                } else {
                    if(verificationId!=null){
                        String code= binding.otp12.getText().toString().trim()+
                                binding.otp12.getText().toString().trim()+
                                binding.otp12.getText().toString().trim()+
                                binding.otp12.getText().toString().trim();

                        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId, code);

                        FirebaseAuth.getInstance().signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                             if (task.isSuccessful()){
                                 binding.vierfy.setVisibility(View.VISIBLE);
                                 Toast.makeText(Otp_for_signin.this,"Otp Verify Successfully",Toast.LENGTH_SHORT).show();
                                 Intent intent= new Intent(Otp_for_signin.this,SignUpActivity.class);
                                 intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                                 startActivity(intent);
                             } else {
                                 binding.vierfy.setVisibility(View.VISIBLE);
                                 Toast.makeText(Otp_for_signin.this, "Otp is not correct", Toast.LENGTH_SHORT).show();
                             }
                            }
                        });
                    }
                }
            }
        });
    }

    private void editTextInput() {
        binding.otp12.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
               binding.otp22.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        binding.otp22.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                binding.otp32.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        binding.otp32.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                binding.otp42.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        }); binding.otp12.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                binding.otp22.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
       
    }
    private void autoOtpReceiver(){
        otpReciver= new OtpReciver();
        this.registerReceiver(otpReciver,new IntentFilter(SmsRetriever.SMS_RETRIEVED_ACTION));
        otpReciver.inItListener(new OtpReciver.OtpReciverListener() {
            @Override
            public void onOtpSuccess(String otp) {

            }

            @Override
            public void onOtpTimeOut() {

            }
        });
    }

   /* private  void  editTextInput(){

    } */
}