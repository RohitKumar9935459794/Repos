package com.dgdgjfm.l.reposproject.ui.profile;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.dgdgjfm.l.reposproject.Add_AssetFragment;
import com.dgdgjfm.l.reposproject.LoginActivity;
import com.dgdgjfm.l.reposproject.R;
import com.dgdgjfm.l.reposproject.databinding.FragmentProfileBinding;
import com.dgdgjfm.l.reposproject.ui.profile.ProfileViewModel;
import com.google.firebase.auth.FirebaseAuth;

public class ProfileFragment extends Fragment {

    private ProfileViewModel ProfileViewModel;
    private FragmentProfileBinding binding;
    FirebaseAuth auth;
    ProgressDialog progressDialog;
    

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        auth=FirebaseAuth.getInstance();

      /*  progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("You are singIp");
        progressDialog.setMessage("You are login your account");*/

        ProfileViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);

        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            auth.signOut();
              Intent intent =new Intent(getActivity(),LoginActivity.class);


            }
        });

        binding.updateProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        binding.ReportAnIssue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        binding.supportText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

       final TextView textView = binding.supportText;
        ProfileViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}