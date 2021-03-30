package com.example.djkaandictionary.ui.alphabetical;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AlphabeticalViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AlphabeticalViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}