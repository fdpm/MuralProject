package com.example.themural;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.firestore.FirebaseFirestore;


public class fragment_profile extends Fragment implements View.OnClickListener {

    private FirebaseFirestore db;
    private TextView textView3;
    private Button buttonEditProfile;
    private Button buttonViewPostsProfile;
    private Button buttonSupportProfile;
    private Button buttonLogOut;


    public fragment_profile() {
        // Required empty public constructor
    }



    public static fragment_profile newInstance() {
        fragment_profile fragment = new fragment_profile();
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
        View root = inflater.inflate(R.layout.fragment_profile, container, false);
        textView3 = root.findViewById(R.id.textView3);
        buttonEditProfile = root.findViewById(R.id.buttonEditProfile);
        buttonViewPostsProfile = root.findViewById(R.id.buttonViewPostsProfile);
        buttonSupportProfile = root.findViewById(R.id.buttonSupportProfile);
        buttonLogOut = root.findViewById(R.id.buttonLogOut);

        buttonEditProfile.setOnClickListener(this);
        buttonViewPostsProfile.setOnClickListener(this);
        buttonSupportProfile.setOnClickListener(this);
        buttonLogOut.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonEditProfile:
                // Crea el nuevo fragmento y la transacción.
                Fragment nuevoFragmento = new fragment_edit_profile();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragmentContainer, nuevoFragmento);
                transaction.addToBackStack(null);

                // Commit a la transacción
                transaction.commit();
                break;
        }
    }
}