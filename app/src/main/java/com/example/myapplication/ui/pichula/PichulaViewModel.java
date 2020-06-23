package com.example.myapplication.ui.pichula;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PichulaViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public PichulaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is pichula fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}