package com.dgdgjfm.l.reposproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.dgdgjfm.l.reposproject.databinding.ActivityOtpBinding;

public class OTP_Activity extends AppCompatActivity {
      ActivityOtpBinding binding;
      String phoneNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityOtpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        phoneNumber=getIntent().getStringExtra("phone").toString();

        binding.vierfy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.vierfy.setVisibility(View.INVISIBLE);
                if(binding.otp1.getText().toString().trim().isEmpty()||
                        binding.otp2.getText().toString().trim().isEmpty()||
                        binding.otp3.getText().toString().trim().isEmpty()||
                        binding.otp4.getText().toString().trim().isEmpty()){
                    Toast.makeText(OTP_Activity.this, "please enter otp", Toast.LENGTH_SHORT).show();
                } else {
                    /*if(verificationId!=null){
                        String code= binding.otp1.getText().toString().trim()+
                                binding.otp1.getText().toString().trim()+
                                binding.otp1.getText().toString().trim()+
                                binding.otp1.getText().toString().trim();

                    }

     //change box selected
                  /*  private void editTextInput() {
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
                        }); binding.otp1.addTextChangedListener(new TextWatcher() {
                            @Override
                            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            }

                            @Override
                            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                                binding.otp2.requestFocus();
                            }

                            @Override
                            public void afterTextChanged(Editable editable) {*/

                            }
                        }

                    } );}}