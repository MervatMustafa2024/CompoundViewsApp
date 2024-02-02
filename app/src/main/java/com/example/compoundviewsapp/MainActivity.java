package com.example.compoundviewsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;
import com.example.compoundviewsapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
   private ActivityMainBinding bindingVar;
   private MainViewModel model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        bindingVar=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(bindingVar.getRoot());
/*
        bindingVar.chk1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Respond to the checked state change
                if (isChecked) {
                    // Checkbox is checked
                    Toast.makeText(MainActivity.this, "Checkbox Checked", Toast.LENGTH_SHORT).show();
                } else {
                    // Checkbox is unchecked
                    Toast.makeText(MainActivity.this, "Checkbox Unchecked", Toast.LENGTH_SHORT).show();
                }
            }
        });

*/
// Initialize ViewModel
        model = new ViewModelProvider(this).get(MainViewModel.class);

        // Observe the LiveData

        model.isSelected.observe(this,selected->{
            bindingVar.chk1.setChecked(selected);
            bindingVar.rd1.setChecked(selected);
            bindingVar.swt1.setChecked(selected);
        });


        bindingVar.chk1.setOnCheckedChangeListener((buttonView, isChecked) -> {
           // Toast.makeText(MainActivity.this, "Meme---- "+model.getIsSelected().getValue(), Toast.LENGTH_SHORT).show();

            //Respond to the checked state change
            if (model.isSelected.getValue()) {
                // Checkbox is checked
                Toast.makeText(MainActivity.this, "Checkbox Checked", Toast.LENGTH_SHORT).show();
            } else {
                // Checkbox is unchecked
                Toast.makeText(MainActivity.this, "Checkbox Unchecked", Toast.LENGTH_SHORT).show();
            }


        });
        bindingVar.rd1.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Toast.makeText(MainActivity.this, "Meme---- "+model.getIsSelected().getValue(), Toast.LENGTH_SHORT).show();

            //Respond to the checked state change
            if (model.isSelected.getValue()) {
                // Checkbox is checked
                Toast.makeText(MainActivity.this, "Radio Checked", Toast.LENGTH_SHORT).show();
            } else {
                // Checkbox is unchecked
                Toast.makeText(MainActivity.this, "Radio Unchecked", Toast.LENGTH_SHORT).show();
            }


        });
        bindingVar.swt1.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Toast.makeText(MainActivity.this, "Meme---- "+model.getIsSelected().getValue(), Toast.LENGTH_SHORT).show();

            //Respond to the checked state change
            if (model.isSelected.getValue()) {
                // Checkbox is checked
                Toast.makeText(MainActivity.this, "Switch Checked", Toast.LENGTH_SHORT).show();
            } else {
                // Checkbox is unchecked
                Toast.makeText(MainActivity.this, "Switch Unchecked", Toast.LENGTH_SHORT).show();
            }


        });




    }






}