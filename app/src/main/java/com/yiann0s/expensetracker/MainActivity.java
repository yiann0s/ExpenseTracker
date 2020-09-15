package com.yiann0s.expensetracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ncapdevi.fragnav.FragNavController;

public class MainActivity extends AppCompatActivity {

    ScreensNavigator screensNavigator;
    private FragNavController.RootFragmentListener mRootFragmentListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screensNavigator = new ScreensNavigator(getSupportFragmentManager(),R.id.container);
        screensNavigator.init(savedInstanceState);

    }

    @Override
    public void onSaveInstanceState(Bundle saveInstanceState) {
        super.onSaveInstanceState(saveInstanceState);
        screensNavigator.onSaveInstanceState(saveInstanceState);
    }

    @Override
    public void onBackPressed() {
        if (!screensNavigator.navigateBack()) {
            super.onBackPressed();
        }
    }

}