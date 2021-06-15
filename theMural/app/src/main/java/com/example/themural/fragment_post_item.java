package com.example.themural;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.themural.data.model.Main;
import com.example.themural.ui.login.LoginActivity;
import com.google.firebase.firestore.FirebaseFirestore;


public class fragment_post_item extends Fragment implements View.OnClickListener {

    private FirebaseFirestore db;
    private Button buttonBooks;
    private Button buttonTools;
    private Button buttonLivingPlace;
    private Button buttonDevices;
    private Button buttonMonitoring;
    private Button buttonVehicles;
    private Main main;
    private OnfilterCategory observer;

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
        main = LoginActivity.getMain();
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
                main.setCategory("Libro");
//                observer.filterCategory("Libro");
                Fragment support = new ListItemFragment();
                FragmentTransaction transactionSupport = getFragmentManager().beginTransaction();
                transactionSupport.replace(R.id.fragmentContainer, support);
                transactionSupport.addToBackStack(null);
                // Commit a la transacción
                transactionSupport.commit();
                break;
            case R.id.buttonTools:
                main.setCategory("Herramientas");
                Fragment support2 = new ListItemFragment();
                FragmentTransaction transactionSupport2 = getFragmentManager().beginTransaction();
                transactionSupport2.replace(R.id.fragmentContainer, support2);
                transactionSupport2.addToBackStack(null);
                // Commit a la transacción
                transactionSupport2.commit();
                break;

            case R.id.buttonLivingPlace:
                main.setCategory("Viviendas");
                Fragment support3 = new ListItemFragment();
                FragmentTransaction transactionSupport3 = getFragmentManager().beginTransaction();
                transactionSupport3.replace(R.id.fragmentContainer, support3);
                transactionSupport3.addToBackStack(null);
                // Commit a la transacción
                transactionSupport3.commit();
                break;
            case R.id.buttonDevices:
                main.setCategory("Dispositivos");
                Fragment support4 = new ListItemFragment();
                FragmentTransaction transactionSupport4 = getFragmentManager().beginTransaction();
                transactionSupport4.replace(R.id.fragmentContainer, support4);
                transactionSupport4.addToBackStack(null);
                // Commit a la transacción
                transactionSupport4.commit();
                break;
            case R.id.buttonMonitoring:
                main.setCategory("Monitorias");
//                observer.filterCategory("Monitorias");
                Fragment support5 = new ListItemFragment();
                FragmentTransaction transactionSupport5 = getFragmentManager().beginTransaction();
                transactionSupport5.replace(R.id.fragmentContainer, support5);
                transactionSupport5.addToBackStack(null);
                // Commit a la transacción
                transactionSupport5.commit();
                break;
            case R.id.buttonVehicles:
                main.setCategory("Vehiculos");
                Fragment support6 = new ListItemFragment();
                FragmentTransaction transactionSupport6 = getFragmentManager().beginTransaction();
                transactionSupport6.replace(R.id.fragmentContainer, support6);
                transactionSupport6.addToBackStack(null);
                // Commit a la transacción
                transactionSupport6.commit();
                break;

        }

    }

    public void setObserver(OnfilterCategory observer){
        this.observer = observer;
    }

    public interface OnfilterCategory {
        void filterCategory(String category);
    }
}