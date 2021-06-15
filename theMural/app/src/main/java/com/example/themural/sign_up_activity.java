package com.example.themural;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.themural.data.model.User;
import com.example.themural.ui.login.LoginActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.FirebaseFirestore;


public class sign_up_activity extends AppCompatActivity implements View.OnClickListener {


    private BottomNavigationView bottomNavigationView2;
    private EditText nameSignUp;
    private EditText nickname;
    private EditText pwdSignUp;
    private EditText pwdConfirmar;
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
        nickname = findViewById(R.id.nicknameET);
        pwdSignUp = findViewById(R.id.pwdSignUp);
        editTextTextPassword2 = findViewById(R.id.pwdConfirmar);
        phoneSignUp = findViewById(R.id.phoneSignUp);
        imageView2 = findViewById(R.id.imageView2);
        buttonAddImageSignUp = findViewById(R.id.buttonAddImageSignUp);
        buttonConfirmSignUp = findViewById(R.id.buttonConfirmSignUp);
        pwdConfirmar = findViewById(R.id.pwdConfirmar);

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
                String nombre = nameSignUp.getText().toString();
                String nicknam = nickname.getText().toString();
                String contraeña = pwdSignUp.getText().toString();
                String telefono = phoneSignUp.getText().toString();
                String pwdConf = pwdConfirmar.getText().toString();
                Image imagen = null;
                db.collection("usuarios")
                        .whereEqualTo("nickName", nicknam)
                        .get().addOnCompleteListener(
                        task -> {
                            if (task.isSuccessful()) {
                                if (task.getResult().size() > 0) {
                                    Toast.makeText(this, "El usuario ya se encuentra registrado", Toast.LENGTH_SHORT).show();
                                } else {
                                    if (pwdConf.equals(contraeña)) {

                                        User user = new User(nombre, nicknam, contraeña, telefono, imagen);
                                        user.setDisplayName(nombre);
                                        db.collection("usuarios").document(user.getUserId()).set(user);
                                        nameSignUp.setText("");
                                        nickname.setText("");
                                        pwdSignUp.setText("");
                                        phoneSignUp.setText("");
                                        Toast.makeText(this, "Usuario registrado", Toast.LENGTH_SHORT).show();
                                        Intent login = new Intent(this, LoginActivity.class);
                                        startActivity(login);
                                    } else {
                                        Toast.makeText(this, "Contraseña diferentes", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        });
        }
    }
}