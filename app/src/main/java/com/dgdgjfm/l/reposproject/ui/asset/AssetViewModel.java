package com.dgdgjfm.l.reposproject.ui.asset;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AssetViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AssetViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}