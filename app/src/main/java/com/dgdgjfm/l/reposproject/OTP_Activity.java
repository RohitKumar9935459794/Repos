package com.dgdgjfm.l.reposproject;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.dgdgjfm.l.reposproject.adapter.OtpReciver;
import com.dgdgjfm.l.reposproject.databinding.ActivityOtpBinding;
import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class OTP_Activity extends AppCompatActivity {
      ActivityOtpBinding binding;
      String phoneNumber;
    private String  verificationId;
    private OtpReciver otpReciver;
    FirebaseAuth auth;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityOtpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        auth=FirebaseAuth.getInstance();


        phoneNumber=getIntent().getStringExtra("phone").toString();


          editTextInput();
          autoOtpReceiver();
        binding.enterMobileForOtp.setText(String.format(
                "+91-%s",getIntent().getStringExtra("phone")
        ));
        verificationId=getIntent().getStringExtra("verificationId") ;

        binding.resendOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(OTP_Activity.this, "Otp send Successfully", Toast.LENGTH_SHORT).show();
                againOtpSend();
            }
        });

        binding.vierfy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.vierfy.setVisibility(View.INVISIBLE);
                if(binding.otp1.getText().toString().trim().isEmpty()||
                        binding.otp2.getText().toString().trim().isEmpty()||
                        binding.otp3.getText().toString().trim().isEmpty()||
                        binding.otp4.getText().toString().trim().isEmpty()||
                        binding.otp5.getText().toString().trim().isEmpty()||
                        binding.otp6.getText().toString().trim().isEmpty()){
                    Toast.makeText(OTP_Activity.this, "please enter otp", Toast.LENGTH_SHORT).show();
                } else {
                    if(verificationId!=null){
                        String code= binding.otp1.getText().toString().trim()+
                                binding.otp2.getText().toString().trim()+
                                binding.otp3.getText().toString().trim()+
                                binding.otp4.getText().toString().trim()+
                                binding.otp5.getText().toString().trim()+
                                binding.otp6.getText().toString().trim();;
                        ;

                        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId, code);

                        FirebaseAuth.getInstance().signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    binding.vierfy.setVisibility(View.VISIBLE);
                                    Toast.makeText(OTP_Activity.this,"Otp Verify Successfully",Toast.LENGTH_SHORT).show();
                                    Intent intent= new Intent(OTP_Activity.this,SignUpActivity.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                                    startActivity(intent);
                                } else {
                                    binding.vierfy.setVisibility(View.VISIBLE);
                                    Toast.makeText(OTP_Activity.this, "Otp is not correct", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                }
            }
        });
    }

    private void editTextInput() {
        binding.otp1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                binding.otp2.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        binding.otp2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                binding.otp3.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        binding.otp3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                binding.otp4.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        }); binding.otp4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                binding.otp5.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        }); binding.otp5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                binding.otp6.requestFocus();
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
                int o1= Character.getNumericValue(otp.charAt(0));
                int o2= Character.getNumericValue(otp.charAt(1));
                int o3= Character.getNumericValue(otp.charAt(2));
                int o4= Character.getNumericValue(otp.charAt(3));
                int o5= Character.getNumericValue(otp.charAt(4));
                int o6= Character.getNumericValue(otp.charAt(5));

                binding.otp1.setText(String.valueOf(o1));
                binding.otp2.setText(String.valueOf(o2));
                binding.otp3.setText(String.valueOf(o3));
                binding.otp4.setText(String.valueOf(o4));
                binding.otp5.setText(String.valueOf(o5));
                binding.otp6.setText(String.valueOf(o6));
            }

            @Override
            public void onOtpTimeOut() {
                Toast.makeText(OTP_Activity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private  void  phoneInput(){

    }  

    private void againOtpSend() {

        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            @Override
            public void onVerificationCompleted(PhoneAuthCredential credential) {
                signInWithPhoneAuthCredential( credential);
            }

            @Override
            public void onVerificationFailed(FirebaseException e) {
                Toast.makeText(OTP_Activity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }


            @Override
            public void onCodeSent(@NonNull String verificationId,
                                   @NonNull PhoneAuthProvider.ForceResendingToken token) {
                Toast.makeText(OTP_Activity.this,"Otp send Successfully",Toast.LENGTH_SHORT).show();

            }
        };
        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(auth)
                        .setPhoneNumber("+91"+getIntent().getStringExtra("phone").trim())       // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(OTP_Activity.this)                 // Activity (for callback binding)
                        .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        auth.signInWithCredential(credential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(OTP_Activity.this,"Otp send Successfully",Toast.LENGTH_SHORT).show();
                    Intent intent= new Intent(OTP_Activity.this,SignUpActivity.class);
                    intent.putExtra("phone",binding.enterMobileForOtp.getText().toString().trim());
                    String id=task.getResult().getUser().getUid();
                    intent.putExtra("UserId",id);
                    startActivity(intent);



                }else {
                    Toast.makeText(OTP_Activity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (otpReciver!=null){
            unregisterReceiver(otpReciver);
        }
    }
}