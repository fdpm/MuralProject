package com.example.themural;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.example.themural.ui.login.LoginActivity;
import com.google.firebase.firestore.FirebaseFirestore;

public class fragment_support extends Fragment implements View.OnClickListener{

    private EditText mensaje;
    private FirebaseFirestore db;

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
        mensaje = root.findViewById(R.id.mensajeET);
        mensaje.setText("para soporte contactarse con: juancamilocast10@gmail.com");
        return root;
    }



    @Override
    public void onClick(View v) {

    }
}
