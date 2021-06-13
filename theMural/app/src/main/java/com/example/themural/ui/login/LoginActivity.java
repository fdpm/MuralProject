package com.example.themural.ui.login;

import android.app.Activity;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.themural.HomeActivity;
import com.example.themural.R;
import com.example.themural.data.model.User;
import com.example.themural.sign_up_activity;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.UUID;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private LoginViewModel loginViewModel;
    private EditText usernameET;
    private EditText passwordET;
    private Button btnLogin;
    private Button btnRegistro;
    private  ProgressBar loadingProgressBar;

    //private fragment_sign_up sign_up;
    private HomeActivity home;
    private sign_up_activity signUp;
    
    //Firebase
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginViewModel = new ViewModelProvider(this, new LoginViewModelFactory())
                .get(LoginViewModel.class);

        signUp = new sign_up_activity();
        home = new HomeActivity();
        usernameET = findViewById(R.id.username);
        passwordET = findViewById(R.id.password);
        btnLogin = findViewById(R.id.btnLogin);
        loadingProgressBar = findViewById(R.id.loading);
        btnRegistro = findViewById(R.id.btnRegistro);

        loginViewModel.getLoginFormState().observe(this, new Observer<LoginFormState>() {
            @Override
            public void onChanged(@Nullable LoginFormState loginFormState) {
                if (loginFormState == null) {
                    return;
                }
                btnLogin.setEnabled(loginFormState.isDataValid());
                if (loginFormState.getUsernameError() != null) {
                    usernameET.setError(getString(loginFormState.getUsernameError()));
                }
                if (loginFormState.getPasswordError() != null) {
                    passwordET.setError(getString(loginFormState.getPasswordError()));
                }
            }
        });

        loginViewModel.getLoginResult().observe(this, new Observer<LoginResult>() {
            @Override
            public void onChanged(@Nullable LoginResult loginResult) {
                if (loginResult == null) {
                    return;
                }
                loadingProgressBar.setVisibility(View.GONE);
                if (loginResult.getError() != null) {
                    showLoginFailed(loginResult.getError());
                }
                if (loginResult.getSuccess() != null) {
                    updateUiWithUser(loginResult.getSuccess());
                }
                setResult(Activity.RESULT_OK);

                //Complete and destroy login activity once successful
                finish();
            }
        });

        TextWatcher afterTextChangedListener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // ignore
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // ignore
            }

            @Override
            public void afterTextChanged(Editable s) {
                loginViewModel.loginDataChanged(usernameET.getText().toString(),
                        passwordET.getText().toString());
            }
        };
        usernameET.addTextChangedListener(afterTextChangedListener);
        passwordET.addTextChangedListener(afterTextChangedListener);
        passwordET.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    loginViewModel.login(usernameET.getText().toString(),
                            passwordET.getText().toString());
                }
                return false;
            }
        });

        btnLogin.setOnClickListener(this);
        btnRegistro.setOnClickListener(this);
    }


    private void updateUiWithUser(LoggedInUserView model) {
        String welcome = getString(R.string.welcome) + model.getDisplayName();
        // TODO : initiate successful logged in experience
        Toast.makeText(getApplicationContext(), welcome, Toast.LENGTH_LONG).show();
    }

    private void showLoginFailed(@StringRes Integer errorString) {
        Toast.makeText(getApplicationContext(), errorString, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnLogin:
                String username = usernameET.getText().toString();
                String password = passwordET.getText().toString();
                User user = new User(UUID.randomUUID().toString(), username, password);

                db.collection("usuarios").document(user.getUserId()).set(user);


                //Saber si el usuario ya esta registrado
                    CollectionReference userRef = db.collection("usuarios");
                    Query query = userRef.whereEqualTo("username",username);
                    query.get().addOnCompleteListener(
                        task -> {
                            if(task.isSuccessful()){
                                for(QueryDocumentSnapshot document : task.getResult()){
                                    Toast.makeText(this, "El usuario ya se encuentra registrado", Toast.LENGTH_SHORT).show();
                                }

                            }
                        }
                );
                loadingProgressBar.setVisibility(View.VISIBLE);
                loginViewModel.login(usernameET.getText().toString(), passwordET.getText().toString());
                break;
            case R.id.btnRegistro:

                this.GoToLoginActivity();

                break;


        }
    }

    private void GoToLoginActivity(){
        Intent intent = new Intent(this, sign_up_activity.class);
        startActivity(intent);
    }
}