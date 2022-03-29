package com.dgdgjfm.l.reposproject.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.dgdgjfm.l.reposproject.orders.currentOrders.CurrentOrdersFragment;
import com.dgdgjfm.l.reposproject.orders.pastOrders.PastOrdersFragment;
import com.dgdgjfm.l.reposproject.ui.history.HistoryFragment;

public class HistoryFragmentAdpter  extends FragmentStateAdapter {

    private String[] titles= new String[]{"Current order,Past order"};


    public HistoryFragmentAdpter(@NonNull HistoryFragment fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
     switch (position){
         case 0:
             return new CurrentOrdersFragment();
         case 1:
             return  new PastOrdersFragment();

     }
     return new CurrentOrdersFragment();
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}
