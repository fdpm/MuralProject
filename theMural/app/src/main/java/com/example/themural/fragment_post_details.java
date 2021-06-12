package com.example.themural;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.firebase.firestore.FirebaseFirestore;


public class fragment_post_details extends Fragment implements View.OnClickListener{

    private FirebaseFirestore db;
    private EditText titleItem;
    private EditText descriptionItem;
    private EditText locationItem;
    private CheckBox checkBoxUsed;
    private CheckBox checkBoxNew;
    private CheckBox checkBoxNone;
    private EditText priceItem;
    private Button buttonContinueDetail;



    public fragment_post_details() {
        // Required empty public constructor
    }



    public static fragment_post_details newInstance() {
        fragment_post_details fragment = new fragment_post_details();
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
        View root = inflater.inflate(R.layout.fragment_post_details_item, container, false);
        titleItem = root.findViewById(R.id.titleItem);
        descriptionItem = root.findViewById(R.id.descriptionItem);
        locationItem = root.findViewById(R.id.locationItem);
        checkBoxUsed = root.findViewById(R.id.checkBoxUsed);
        checkBoxNew = root.findViewById(R.id.checkBoxNew);
        checkBoxNone = root.findViewById(R.id.checkBoxNone);
        priceItem = root.findViewById(R.id.priceItem);
        buttonContinueDetail = root.findViewById(R.id.buttonContinueDetail);

        buttonContinueDetail.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonContinueDetail:

                break;
        }

    }
}