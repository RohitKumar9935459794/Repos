package com.dgdgjfm.l.reposproject.chage_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.dgdgjfm.l.reposproject.databinding.FragmentChangeFragementAssetBinding;

public class Change_Fragement_Asset extends Fragment {
    private FragmentChangeFragementAssetBinding binding;





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        binding = FragmentChangeFragementAssetBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;

       /* binding.buttonAddMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });  */


       

    }
}