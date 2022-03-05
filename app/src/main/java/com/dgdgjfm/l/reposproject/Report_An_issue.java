package com.dgdgjfm.l.reposproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.dgdgjfm.l.reposproject.databinding.ActivityReportAnIssueBinding;

public class Report_An_issue extends AppCompatActivity {
    ActivityReportAnIssueBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityReportAnIssueBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.sendReportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}