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
import com.example.themural.data.model.Main;
import com.example.themural.data.model.User;
import com.example.themural.sign_up_activity;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.gson.annotations.SerializedName;

import java.util.UUID;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private LoginViewModel loginViewModel;
    private EditText usernameET;
    private EditText passwordET;
    private Button btnLogin;
    private Button btnRegistro;
    private  ProgressBar loadingProgressBar;

    private static Main main;
    private User userdb;

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
        main = new Main();
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
                Intent intent = new Intent();
                String username = usernameET.getText().toString();
                String password = passwordET.getText().toString();
                User user = new User(UUID.randomUUID().toString(), username, password);

                db.collection("usuarios")
                        .whereEqualTo("nickName",username)
                        .whereEqualTo("password",password)
                        .get().addOnCompleteListener(
                                task ->{
                                    if (task.isSuccessful()) {
                                        if(task.getResult().size() > 0){
                                            for(QueryDocumentSnapshot document: task.getResult()){
                                                userdb = document.toObject(User.class);
                                                main.newUser(userdb);
                                                Intent home = new Intent(this, HomeActivity.class);
                                                startActivity(home);
                                                break;
                                            }
                                        }else{
                                            Intent login = new Intent(this, LoginActivity.class);

                                            startActivity(login);
                                        }
                                    }
                                });

                loadingProgressBar.setVisibility(View.VISIBLE);
                loginViewModel.login(usernameET.getText().toString(), passwordET.getText().toString());

                break;
            case R.id.btnRegistro:
                Intent siguiente = new Intent(this, sign_up_activity.class);
                startActivity(siguiente);
                break;


        }
    }

    public static Main getMain(){
        return main;
    }

    public void setMain(Main main){
        this.main = main;
    }

}