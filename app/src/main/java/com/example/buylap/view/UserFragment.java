package com.example.buylap.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.buylap.R;
import com.example.buylap.controller.graphic.UserFragmentGraphicController;

public class UserFragment extends Fragment {


    public UserFragment() {
        // Required empty public constructor
    }
    private UserFragmentGraphicController userFragmentGraphicController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Button signOut;

        userFragmentGraphicController= new UserFragmentGraphicController(this);

        View view= inflater.inflate(R.layout.fragment_user, container, false);
        userFragmentGraphicController.initializeSession(view);
        signOut=view.findViewById(R.id.signoutBtn);
        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userFragmentGraphicController.onSignOut();
            }
        });

        return view;
    }

    public void setFragmentGuest(View view) {
        TextView editUsername;
        editUsername = view.findViewById(R.id.editUsern);
        editUsername.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userFragmentGraphicController.notifyGuest(v);
            }
        });
        TextView editEmail;
        editEmail = view.findViewById(R.id.editEmail);
        editEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userFragmentGraphicController.notifyGuest(v);
            }
        });
        TextView editPassword;
        editPassword = view.findViewById(R.id.numberCard);
        editPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userFragmentGraphicController.notifyGuest(v);
            }
        });
    }


}