package com.dgdgjfm.l.reposproject.ui.orders;

import android.app.FragmentManager;
import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

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