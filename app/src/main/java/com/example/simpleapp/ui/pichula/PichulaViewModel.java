package com.example.simpleapp.ui.pichula;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PichulaViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    ArrayList<String> listDatos;
    RecyclerView recycler;

    public PichulaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is pichula fragment");
        //recycler = findViewById(R.id.reciler)
    }

    public LiveData<String> getText() {
        return mText;
    }
}