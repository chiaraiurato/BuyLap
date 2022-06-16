package com.example.buylap.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.buylap.R;
import com.example.buylap.abstract_factory.NavigationFactory;
import com.example.buylap.controller.graphic.UserFragmentGraphicController;

public class GuestFragment extends Fragment implements NavigationFactory {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_guest, container, false);
        Button signOut;

        signOut=view.findViewById(R.id.signoutGuest);
        UserFragmentGraphicController settingFragmentGraphicController = new UserFragmentGraphicController(this);
        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settingFragmentGraphicController.onSignOutGuest();
            }
        });
        return view;
    }

    @Override
    public Fragment selectMyFragment() {
        return this;
    }
}