package com.example.themural;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.themural.ui.login.LoginActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.FirebaseFirestore;


public class sign_up_activity extends AppCompatActivity implements View.OnClickListener {


    private BottomNavigationView bottomNavigationView2;
    private EditText nameSignUp;
    private EditText lastnameSignUp;
    private EditText pwdSignUp;
    private EditText editTextTextPassword2;
    private EditText phoneSignUp;
    private ImageView imageView2;
    private Button buttonAddImageSignUp;
    private Button buttonConfirmSignUp;

    FirebaseFirestore db = FirebaseFirestore.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        bottomNavigationView2 = findViewById(R.id.bottomNavigationView2);
        nameSignUp = findViewById(R.id.nameSignUp);
        lastnameSignUp = findViewById(R.id.lastnameSignUp);
        pwdSignUp = findViewById(R.id.pwdSignUp);
        editTextTextPassword2 = findViewById(R.id.editTextTextPassword2);
        phoneSignUp = findViewById(R.id.phoneSignUp);
        imageView2 = findViewById(R.id.imageView2);
        buttonAddImageSignUp = findViewById(R.id.buttonAddImageSignUp);
        buttonConfirmSignUp = findViewById(R.id.buttonConfirmSignUp);

        buttonAddImageSignUp.setOnClickListener(this);
        buttonConfirmSignUp.setOnClickListener(this);
        bottomNavigationView2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bottomNavigationView2:
                Intent anterior = new Intent(this, LoginActivity.class);
                startActivity(anterior);

            case R.id.buttonConfirmSignUp:
                Intent login = new Intent(this, LoginActivity.class);
                startActivity(login);
        }
    }


}