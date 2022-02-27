package com.dgdgjfm.l.reposproject.orders.pastOrders;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dgdgjfm.l.reposproject.R;

public class PastOrdersFragment extends Fragment {

    private PastOrdersViewModel mViewModel;

    public static PastOrdersFragment newInstance() {
        return new PastOrdersFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.past_orders_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(PastOrdersViewModel.class);
        // TODO: Use the ViewModel
    }

}