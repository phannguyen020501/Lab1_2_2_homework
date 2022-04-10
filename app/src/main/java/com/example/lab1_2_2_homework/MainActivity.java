package com.example.lab1_2_2_homework;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;
    private Button mcountButton;
    private Button mResetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.show_count);
        mcountButton = findViewById(R.id.button_count);
        mResetButton = findViewById((R.id.button_zero));

        if(savedInstanceState != null){
             mCount = savedInstanceState.getInt("count");
            if(mShowCount != null){
                mShowCount.setText(Integer.toString(mCount));
            }
        }

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count", mCount);
    }


    public void showToast(View view){
        Toast toast = Toast.makeText(this, R.string.toast_message,
                Toast.LENGTH_SHORT);
        toast.show();
    }

    public void countUp(View view){
        mCount++;
        if(mShowCount != null){
            mShowCount.setText(Integer.toString(mCount));
        }
        switch (mCount % 2){
//            if mCount mod 2 is 0, number is even otherwise odd
            case 0: view.setBackgroundColor(Color.MAGENTA);
                break;
            case 1: view.setBackgroundColor(Color.GREEN);
                break;
            default: break;
        }
        mResetButton.setBackgroundColor(getResources().getColor(R.color.purple_500));
    }
    public void resetZero(View view){
        mCount = 0;
        if(mShowCount != null){
            mShowCount.setText(Integer.toString(mCount));
        }
        view.setBackgroundColor(Color.GRAY);
        mResetButton.setBackgroundColor(Color.GRAY);
    }


}