package com.example.themural;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.themural.ui.login.LoginActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.FirebaseFirestore;

public class fragment_support extends Fragment implements View.OnClickListener{

    private FirebaseFirestore db;
    private BottomNavigationView navigationSupport;
    private EditText editTextMultiple;

    public fragment_support(){

    }

    public static fragment_support newInstance() {
        fragment_support fragment = new fragment_support();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        db = FirebaseFirestore.getInstance();
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_support, container, false);
        navigationSupport = root.findViewById(R.id.navigationSupport);
        editTextMultiple = root.findViewById(R.id.mensajeETM);
        String mensaje = "Esta aplicación se hizo como proyecto final del curso de Aplicaciones" +
                "moviles donde los desarrolladores fueron estudiantes del mismo curso. Para más información" +
                " o ayuda comunicarse al correo: " +
                "juan.castillo11@u.icesi.edu.co";
        editTextMultiple.setText(mensaje);
        navigationSupport.setOnClickListener(this);
        return root;
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.navigationSupport:
                Fragment profile = new fragment_profile();
                FragmentTransaction transactionProfile = getFragmentManager().beginTransaction();
                transactionProfile.replace(R.id.fragmentContainer, profile);
                transactionProfile.addToBackStack(null);
                transactionProfile.commit();
                break;
        }

    }
}
