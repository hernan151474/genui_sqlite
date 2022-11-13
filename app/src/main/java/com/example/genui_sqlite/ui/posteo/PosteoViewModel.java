package com.example.genui_sqlite.ui.posteo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PosteoViewModel extends ViewModel{
    private MutableLiveData<String> mText;

    public PosteoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");

    }

    public LiveData<String> getText() {
        return mText;
    }
}
