package com.example.themural;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.themural.data.model.Item;
import com.example.themural.data.model.Main;
import com.example.themural.data.model.User;
import com.example.themural.ui.login.LoginActivity;
import com.example.themural.ui.login.LoginViewModel;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;


public class fragment_edit_profile extends Fragment implements View.OnClickListener {

    private FirebaseFirestore db;


    private EditText name;
    private EditText password;
    private EditText telephone;
    private Button editPhoto;
    private Button confirmar;

    private Main main;
    private User user;


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
        main = LoginActivity.getMain();
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
        confirmar = root.findViewById(R.id.buttonConfirmEditProfile);

        editPhoto.setOnClickListener(this);
        confirmar.setOnClickListener(this);
        user = main.getUsers().get(0);
        name.setText(user.getName());
        password.setText(user.getPassword());
        telephone.setText(user.getPhone());

        return root;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonConfirmEditProfile:
                user.setName(name.getText().toString());
                user.setPassword(password.getText().toString());
                user.setPhone(telephone.getText().toString());
                db.collection("usuarios").document(user.getUserId()).set(user);
                Intent home = new Intent(v.getContext(), HomeActivity.class);
                startActivity(home);

        }
    }
}