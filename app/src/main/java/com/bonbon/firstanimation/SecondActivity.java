package com.bonbon.firstanimation;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        int points = getIntent().getIntExtra("points", 0);
        Toast.makeText(this, String.valueOf(points), Toast.LENGTH_SHORT).show();
    }
}
