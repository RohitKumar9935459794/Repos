package com.dgdgjfm.l.reposproject.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.dgdgjfm.l.reposproject.orders.currentOrders.CurrentOrdersFragment;
import com.dgdgjfm.l.reposproject.orders.pastOrders.PastOrdersFragment;

public class HistoryFragmentAdpter  extends FragmentPagerAdapter {

    public HistoryFragmentAdpter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
      switch (position){
          case 0:return new CurrentOrdersFragment();
          case 1:return new PastOrdersFragment();
          default:return new CurrentOrdersFragment();
      }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title=null;
        if (position==0){
            title="Current order";
        }
        if (position==1){
            title="Past order";
        }

        return title;
    }
}
