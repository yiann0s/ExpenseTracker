package com.yiann0s.expensetracker;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BaseFragment extends Fragment {

    public static final String ARGS_INSTANCE = "com.ncapdevi.sample.argsInstance";
    private String TAG = "TEST.BaseFragment";

    FragmentNavigation mFragmentNavigation;
    int mInt = 0;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            mInt = args.getInt(ARGS_INSTANCE);
        }
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onViewCreated: ");
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        Log.i(TAG, "onAttach: ");
        super.onAttach(context);
        if (context instanceof FragmentNavigation) {
            Log.i(TAG, "onAttach: success");
            mFragmentNavigation = (FragmentNavigation) context;
        } else {
            Log.i(TAG, "onAttach: failure");
        }
    }

    public interface FragmentNavigation {
        public void pushFragment(Fragment fragment);
    }
}
