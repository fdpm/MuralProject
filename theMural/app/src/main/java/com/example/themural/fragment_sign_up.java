package com.example.themural;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class fragment_sign_up extends Fragment implements View.OnClickListener {


    private BottomNavigationView bottomNavigationView2;
    private EditText nameSignUp;
    private EditText lastnameSignUp;
    private EditText pwdSignUp;
    private EditText editTextTextPassword2;
    private EditText phoneSignUp;
    private ImageView imageView2;
    private Button buttonAddImageSignUp;
    private Button buttonConfirmSignUp;

    public fragment_sign_up() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static fragment_sign_up newInstance() {
        fragment_sign_up fragment = new fragment_sign_up();
        Bundle args = new Bundle();
        //args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_sign_up, container, false);
        bottomNavigationView2 = root.findViewById(R.id.bottomNavigationView2);
        nameSignUp = root.findViewById(R.id.nameSignUp);
        lastnameSignUp = root.findViewById(R.id.lastnameSignUp);
        pwdSignUp = root.findViewById(R.id.pwdSignUp);
        editTextTextPassword2 = root.findViewById(R.id.editTextTextPassword2);
        phoneSignUp = root.findViewById(R.id.phoneSignUp);
        imageView2 = root.findViewById(R.id.imageView2);
        buttonAddImageSignUp = root.findViewById(R.id.buttonAddImageSignUp);
        buttonConfirmSignUp = root.findViewById(R.id.buttonConfirmSignUp);

        buttonAddImageSignUp.setOnClickListener(this);
        buttonConfirmSignUp.setOnClickListener(this);


        return root;
    }

    @Override
    public void onClick(View v) {

    }
}