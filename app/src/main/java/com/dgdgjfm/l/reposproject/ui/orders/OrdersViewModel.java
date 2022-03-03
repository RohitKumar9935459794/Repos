package com.dgdgjfm.l.reposproject.ui.orders;

import android.app.FragmentManager;
import android.view.View;

import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.dgdgjfm.l.reposproject.Add_AssetFragment;
import com.dgdgjfm.l.reposproject.R;

public class OrdersViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public OrdersViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("To place order add an asset");
    }

    public LiveData<String> getText() {
        return mText;
    }


}