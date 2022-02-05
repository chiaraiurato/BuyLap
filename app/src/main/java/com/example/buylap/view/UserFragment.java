package com.example.buylap.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.buylap.R;
import com.example.buylap.controller.graphic.UserFragmentGraphicController;

public class UserFragment extends Fragment {


    public UserFragment() {
        // Required empty public constructor
    }
    private Button signOut;
    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        UserFragmentGraphicController userFragmentGraphicController= new UserFragmentGraphicController(this);

        view= inflater.inflate(R.layout.fragment_user, container, false);

        signOut=view.findViewById(R.id.signoutBtn);
        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userFragmentGraphicController.onSignOut();
            }
        });

        return view;
    }

}