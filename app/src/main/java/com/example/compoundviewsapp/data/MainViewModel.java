package com.example.compoundviewsapp.data;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
public class MainViewModel extends  ViewModel
{
    public MutableLiveData<Boolean> isSelected= new MutableLiveData<>();

    // Constructor or any initialization method where you set initial value
    public MainViewModel() {
        isSelected.setValue(false); // Set initial value
    }


}
