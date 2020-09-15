package com.yiann0s.expensetracker;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.ncapdevi.fragnav.FragNavController;

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

    public ScreensNavigator(FragmentManager fragmentManager, Integer containerId) {
        mFragNavController = new FragNavController(fragmentManager,containerId);
    }

    public void init(Bundle savedInstanceState) {
        mFragNavController.setRootFragmentListener(mRootFragmentListener);
        mFragNavController.initialize(FragNavController.TAB1, savedInstanceState);
    }

    public void onSaveInstanceState(Bundle saveInstanceState) {
        mFragNavController.onSaveInstanceState(saveInstanceState);
    }

    public boolean navigateBack() {
        if(mFragNavController.isRootFragment()) {
            return false;
        } else {
            mFragNavController.popFragment();
            return true;
        }
    }
}
