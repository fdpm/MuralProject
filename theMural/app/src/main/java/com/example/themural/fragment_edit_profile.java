package com.example.themural;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.themural.ui.login.LoginViewModel;
import com.google.firebase.firestore.FirebaseFirestore;


public class fragment_edit_profile extends Fragment implements View.OnClickListener {

    private FirebaseFirestore db;


    private EditText name;
    private EditText password;
    private EditText telephone;
    private Button editPhoto;
    private Button confirmar;


    public fragment_edit_profile() {
        // Required empty public constructor
    }



    public static fragment_edit_profile newInstance() {
        fragment_edit_profile fragment = new fragment_edit_profile();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        db = FirebaseFirestore.getInstance();
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_edit_profile, container, false);
        name = root.findViewById(R.id.nameET);
        password = root.findViewById(R.id.passwordET);
        telephone = root.findViewById(R.id.telephoneET);
        editPhoto = root.findViewById(R.id.buttonEditProfileImage);
        confirmar = root.findViewById(R.id.buttonEditProfile);

        editPhoto.setOnClickListener(this);
        confirmar.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

        }
    }
}