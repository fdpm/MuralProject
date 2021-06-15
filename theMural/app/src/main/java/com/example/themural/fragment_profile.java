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

import com.example.themural.data.model.Main;
import com.example.themural.ui.login.LoginActivity;
import com.google.firebase.firestore.FirebaseFirestore;


public class fragment_profile extends Fragment implements View.OnClickListener {

    private FirebaseFirestore db;
    private TextView textView3;
    private Button buttonEditProfile;
    private Button buttonViewPostsProfile;
    private Button buttonSupportProfile;
    private Button buttonLogOut;

    private static Main main;

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
        main = LoginActivity.getMain();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_profile, container, false);
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
            case R.id.buttonViewPostsProfile:
                Fragment myPosts = new fragment_my_posts();
                FragmentTransaction transactionMyPost = getFragmentManager().beginTransaction();
                transactionMyPost.replace(R.id.fragmentContainer, myPosts);
                transactionMyPost.addToBackStack(null);

                // Commit a la transacción
                transactionMyPost.commit();
                break;

            case R.id.buttonEditProfile:
                // Crea el nuevo fragmento y la transacción.
                Fragment edit = new fragment_edit_profile();
                FragmentTransaction transactionEdit = getFragmentManager().beginTransaction();
                transactionEdit.replace(R.id.fragmentContainer, edit);
                transactionEdit.addToBackStack(null);

                // Commit a la transacción
                transactionEdit.commit();
                break;
            case R.id.buttonSupportProfile:
                // Crea el nuevo fragmento y la transacción.
                Fragment support = new fragment_support();
                FragmentTransaction transactionSupport = getFragmentManager().beginTransaction();
                transactionSupport.replace(R.id.fragmentContainer, support);
                transactionSupport.addToBackStack(null);

                // Commit a la transacción
                transactionSupport.commit();
                break;
            case R.id.buttonLogOut:
                main.getUsers().clear();
                main.getPosts().clear();
                main.getMyPost().clear();
                Intent login = new Intent(v.getContext(), LoginActivity.class);
                startActivity(login);
                break;

        }
    }
}