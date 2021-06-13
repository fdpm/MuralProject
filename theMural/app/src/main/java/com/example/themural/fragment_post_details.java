package com.example.themural;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.themural.data.model.Item;
import com.example.themural.data.model.Main;
import com.example.themural.ui.login.LoginActivity;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Random;


public class fragment_post_details extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private FirebaseFirestore db;
    private EditText titleItem;
    private EditText descriptionItem;
    private EditText locationItem;
    private CheckBox checkBoxUsed;
    private CheckBox checkBoxNew;
    private CheckBox checkBoxNone;
    private EditText priceItem;
    private Button buttonContinueDetail;
    private Spinner spinnertype;

    private Item item;
    private Main main;
    private LoginActivity login;

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
        item = new Item();
        main = LoginActivity.getMain();


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

        spinnertype = root.findViewById(R.id.spinnerType);

        String[] opciones = {"Libro","Herramientas","Viviendas","Dispositivos","Monitorias","Vehiculos"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_spinner_item, opciones);
        spinnertype.setAdapter(adapter);


        buttonContinueDetail.setOnClickListener(this);







        return root;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonContinueDetail:
                tomarDatos();
                db.collection("publicaciones").document(item.getIdItem()).set(item);
                break;
        }

    }

    public void tomarDatos(){
        Random r = new Random();
        int valor = r.nextInt(Integer.MAX_VALUE);
        item.setTypeItem(spinnertype.getSelectedItem().toString());
        item.setDescriptionItem(descriptionItem.getText().toString());
        item.setIdItem(main.getUsers().get(0).getUserId()+"."+valor);
        item.setLocationItem(locationItem.getText().toString());
        item.setPriceItem(Integer.parseInt(priceItem.getText().toString()));
        if(checkBoxUsed.isChecked()){
            item.setStateItem(0);
        }else if(checkBoxNew.isChecked()){
            item.setStateItem(1);
        }else if(checkBoxNone.isChecked()){
            item.setStateItem(2);
        }
        main.newPost(item);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}