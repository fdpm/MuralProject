package com.example.themural;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.firestore.FirebaseFirestore;


public class fragment_post_item extends Fragment implements View.OnClickListener {

    private FirebaseFirestore db;
    private Button buttonBooks;
    private Button buttonTools;
    private Button buttonLivingPlace;
    private Button buttonDevices;
    private Button buttonMonitoring;
    private Button buttonVehicles;

    public fragment_post_item() {
        // Required empty public constructor
    }



    public static fragment_post_item newInstance() {
        fragment_post_item fragment = new fragment_post_item();
        Bundle args = new Bundle();
        //args.putString(ARG_PARAM1, param1);
        //args.putString(ARG_PARAM2, param2);
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
        View root = inflater.inflate(R.layout.fragment_post_item, container, false);
        buttonBooks = root.findViewById(R.id.buttonBooks);
        buttonTools = root.findViewById(R.id.buttonTools);
        buttonLivingPlace = root.findViewById(R.id.buttonLivingPlace);
        buttonDevices = root.findViewById(R.id.buttonDevices);
        buttonMonitoring = root.findViewById(R.id.buttonMonitoring);
        buttonVehicles = root.findViewById(R.id.buttonVehicles);

        buttonBooks.setOnClickListener(this);
        buttonTools.setOnClickListener(this);
        buttonLivingPlace.setOnClickListener(this);
        buttonDevices.setOnClickListener(this);
        buttonMonitoring.setOnClickListener(this);
        buttonVehicles.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonBooks:

                break;
        }

    }
}