package com.dgdgjfm.l.reposproject.orders.currentOrders;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dgdgjfm.l.reposproject.R;

public class CurrentOrdersFragment extends Fragment {

    private CurrentOrdersViewModel mViewModel;

    public static CurrentOrdersFragment newInstance() {
        return new CurrentOrdersFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.current_orders_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(CurrentOrdersViewModel.class);
        // TODO: Use the ViewModel
    }

}