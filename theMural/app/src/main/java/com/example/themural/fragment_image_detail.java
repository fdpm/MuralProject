package com.example.themural;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.firestore.FirebaseFirestore;


public class fragment_image_detail extends Fragment implements View.OnClickListener{

    private FirebaseFirestore db;
    private ImageView imageViewItem;
    private Button buttonPostImageItem;
    private Button buttonPostItem;



    public fragment_image_detail() {
        // Required empty public constructor
    }


    public static fragment_image_detail newInstance() {
        fragment_image_detail fragment = new fragment_image_detail();
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
        View root = inflater.inflate(R.layout.fragment_image_detail, container, false);
        imageViewItem = root.findViewById(R.id.imageViewItem);
        buttonPostImageItem = root.findViewById(R.id.buttonPostImageItem);
        buttonPostItem = root.findViewById(R.id.buttonPostItem);

        buttonPostImageItem.setOnClickListener(this);
        buttonPostItem.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View v) {

    }
}