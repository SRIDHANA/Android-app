package com.example.sridhana.englishgrammarnotepad;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Sridhana on 3/17/2017.
 */

public class UserNamePassFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View userNamePassView = inflater.inflate(R.layout.registration_usrname_pass_layout,container,false);

        return userNamePassView;
    }
}