package com.example.themural;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.themural.data.model.Chat;
import com.example.themural.data.model.Item;
import com.example.themural.data.model.Main;
import com.example.themural.data.model.User;
import com.example.themural.ui.login.LoginActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.concurrent.atomic.AtomicReference;


public class fragment_my_posts extends Fragment implements View.OnClickListener{

    private FirebaseFirestore db;
    private RecyclerView recyclerViewMyPost;
    private BottomNavigationView navigationMyPost;
    private Main main;

    public fragment_my_posts() {
        // Required empty public constructor
    }


    public static fragment_my_posts newInstance() {
        fragment_my_posts fragment = new fragment_my_posts();
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
        View root = inflater.inflate(R.layout.fragment_my_posts, container, false);
        recyclerViewMyPost = root.findViewById(R.id.recyclerViewMyPost);
        recyclerViewMyPost.setHasFixedSize(true);
        navigationMyPost = root.findViewById(R.id.navigationMyPost);
        navigationMyPost.setOnClickListener(this);

        mostrar();

        return root;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.navigationMyPost:
                Fragment profile = new fragment_profile();
                FragmentTransaction transactionProfile = getFragmentManager().beginTransaction();
                transactionProfile.replace(R.id.fragmentContainer, profile);
                transactionProfile.addToBackStack(null);
                transactionProfile.commit();
                break;
        }

    }

    public void mostrar() {
        final Item[] item = {new Item()};
        AtomicReference<User> userdb = new AtomicReference<>(new User());
        db.collection("publicaciones").get().addOnCompleteListener(
                task -> {
                    if (task.isSuccessful()) {
                        if (task.getResult().size() > 0) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                item[0] = document.toObject(Item.class);
                                if (item[0].getIdItem().contains(main.getUsers().get(0).getUserId())) {
                                    main.newMyPost(item[0]);
                                }
                            }
                        }
                    }
                });
        recyclerViewMyPost.setAdapter(main);
    }


}