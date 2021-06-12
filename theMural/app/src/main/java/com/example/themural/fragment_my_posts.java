package com.example.themural;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.FirebaseFirestore;


public class fragment_my_posts extends Fragment implements View.OnClickListener{

    private FirebaseFirestore db;
    private RecyclerView recyclerViewMyPost;
    private BottomNavigationView navigationMyPost;

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

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_my_posts, container, false);
        recyclerViewMyPost = root.findViewById(R.id.recyclerViewMyPost);
        recyclerViewMyPost.setHasFixedSize(true);
        navigationMyPost = root.findViewById(R.id.navigationMyPost);

        return root;
    }

    @Override
    public void onClick(View v) {

    }
}