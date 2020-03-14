package com.example.projectx.Activity.ui.FAQ;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FaqViewModel extends ViewModel {
    // TODO: Implement the ViewModel

    private MutableLiveData<String> mText;
    public FaqViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is FAQ fragment");
    }
    public LiveData<String> getText() {
        return mText;
    }
}
