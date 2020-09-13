package com.yiann0s.expensetracker;

import android.os.Bundle;
import android.util.Log;

import androidx.fragment.app.Fragment;

import com.ncapdevi.fragnav.FragNavController;

import static android.content.ContentValues.TAG;


public class ScreensNavigator {

    private final FragNavController mFragNavController;

    private FragNavController.RootFragmentListener mRootFragmentListener = new FragNavController.RootFragmentListener() {
        @Override
        public int getNumberOfRootFragments() {
            return 1;
        }
        
        @Override
        public Fragment getRootFragment(int index) {
            switch (index) {
                case FragNavController.TAB1:
                    return RootFragment.newInstance();
                default:
                    throw new IllegalStateException("unsupported tab index: " + index);
            }
        }
    };

    public ScreensNavigator(FragNavController fragNavController) {
        Log.i(TAG, "ScreensNavigator: ");
        mFragNavController = fragNavController;
    }

    public void init(Bundle savedInstanceState) {
        Log.i(TAG, "init: ");
        mFragNavController.setRootFragmentListener(mRootFragmentListener);
        mFragNavController.initialize(FragNavController.TAB1, savedInstanceState);
    }

    public void onSaveInstanceState(Bundle saveInstanceState) {
        mFragNavController.onSaveInstanceState(saveInstanceState);
    }
}
