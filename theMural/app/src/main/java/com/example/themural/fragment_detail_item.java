package com.example.themural;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.FirebaseFirestore;


public class fragment_detail_item extends Fragment implements View.OnClickListener{

    private FirebaseFirestore db;
    private BottomNavigationView navigationDetailProfile;
    private TextView tittleDetailItem;
    private ImageView imageDetailItem;
    private TextView priceDetailItem;
    private TextView placeDetailItem;
    private TextView statusDetailItem;
    private Button buttonContactSeller;

    public fragment_detail_item() {
        // Required empty public constructor
    }


    public static fragment_detail_item newInstance() {
        fragment_detail_item fragment = new fragment_detail_item();
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
        View root = inflater.inflate(R.layout.fragment_detail_item, container, false);
        navigationDetailProfile = root.findViewById(R.id.navigationDetailProfile);
        tittleDetailItem = root.findViewById(R.id.tittleDetailItem);
        imageDetailItem = root.findViewById(R.id.imageDetailItem);
        priceDetailItem = root.findViewById(R.id.priceDetailItem);
        placeDetailItem = root.findViewById(R.id.placeDetailItem);
        statusDetailItem = root.findViewById(R.id.statusDetailItem);
        buttonContactSeller = root.findViewById(R.id.buttonContactSeller);

        buttonContactSeller.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonEditProfile:

                break;
        }

    }
}