package com.yiann0s.expensetracker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class RootFragment extends BaseFragment {

    private ScreensNavigator screensNavigator;
    private String TAG = "TEST.RootFragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_root, container, false);
    }

    public static RootFragment  newInstance(int instance) {
        Bundle args = new Bundle();
        args.putInt(ARGS_INSTANCE, instance);
        RootFragment fragment = new RootFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onViewCreated: ");
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick: ");
                //todo mFragmentNavigation is null :(
                if (mFragmentNavigation != null) {
                    mFragmentNavigation.pushFragment(PinkFragment.newInstance(mInt+1));
                } else {
                    Log.i(TAG, "onClick: mNaivgation is nUll");
                }
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        Log.i(TAG, "onAttach: ");
        super.onAttach(context);
    }

    public static RootFragment newInstance() {

        Bundle args = new Bundle();

        RootFragment fragment = new RootFragment();
        fragment.setArguments(args);
        return fragment;
    }

}