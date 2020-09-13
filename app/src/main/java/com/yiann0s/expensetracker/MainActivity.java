package com.yiann0s.expensetracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.ncapdevi.fragnav.FragNavController;

public class MainActivity extends AppCompatActivity {

    FragNavController fragNavController;
    ScreensNavigator screensNavigator;
    private FragNavController.RootFragmentListener mRootFragmentListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragNavController = new FragNavController(getSupportFragmentManager(), R.id.container);

        mRootFragmentListener = new FragNavController.RootFragmentListener() {
            @Override
            public int getNumberOfRootFragments() {
                return 1;
            }

            @Override
            public Fragment getRootFragment(int index) {
                switch (index) {
                    case 0:
                        return RootFragment.newInstance();
                    default:
                        throw new IllegalStateException("unsupported tab index: " + index);
                }
            }
        };
        fragNavController.setRootFragmentListener(mRootFragmentListener);
        fragNavController.initialize(0, savedInstanceState);

    }

}