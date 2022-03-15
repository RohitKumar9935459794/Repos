package com.dgdgjfm.l.reposproject.ui.history;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


import com.dgdgjfm.l.reposproject.adapter.HistoryFragmentAdpter;
import com.dgdgjfm.l.reposproject.databinding.FragmentHistoryBinding;
import com.google.android.material.tabs.TabLayoutMediator;

public class HistoryFragment extends Fragment {

    private HistoryViewModel historyViewModel;
    private @NonNull
    FragmentHistoryBinding binding;
    HistoryFragmentAdpter historyFragmentAdpter;
    private String[] titles= new String[]{"Current order,Past order"};


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        historyViewModel = new ViewModelProvider(this).get(HistoryViewModel.class);

        binding = FragmentHistoryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        historyFragmentAdpter= new HistoryFragmentAdpter(this);

        binding.viewPager.setAdapter(historyFragmentAdpter);

      new TabLayoutMediator(binding.tabLayout,binding.viewPager,((tab, position) -> tab.setText(titles[position]))).attach();
        // binding.viewPager.setAdapter(new HistoryFragmentAdpter( FragmentManager()));

        final TextView textView = binding.textNotifications;
        historyViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
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