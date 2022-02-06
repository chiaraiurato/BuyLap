package com.example.buylap.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.buylap.R;
import com.example.buylap.bean.BeanUser;
import com.example.buylap.controller.graphic.UserFragmentGraphicController;

import org.w3c.dom.Text;

public class UserFragment extends Fragment {


    public UserFragment() {
        // Required empty public constructor
    }
    private UserFragmentGraphicController userFragmentGraphicController;
    private Button signOut;
    private View view;
    private TextView editUsername;
    private TextView editEmail;
    private TextView editPassword;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        userFragmentGraphicController= new UserFragmentGraphicController(this);

        view= inflater.inflate(R.layout.fragment_user, container, false);
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
        editUsername = view.findViewById(R.id.editUsern);
        editUsername.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userFragmentGraphicController.notifyGuest(v);
            }
        });
        editEmail = view.findViewById(R.id.editEmail);
        editEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userFragmentGraphicController.notifyGuest(v);
            }
        });
        editPassword = view.findViewById(R.id.editPw);
        editPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userFragmentGraphicController.notifyGuest(v);
            }
        });
    }

    public void setFragmentUser(BeanUser beanUser,View view) {
    }
}