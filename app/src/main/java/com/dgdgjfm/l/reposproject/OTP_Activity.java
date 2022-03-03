package com.dgdgjfm.l.reposproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.dgdgjfm.l.reposproject.databinding.ActivityOtpBinding;

public class OTP_Activity extends AppCompatActivity {
      ActivityOtpBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityOtpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        
    }
}