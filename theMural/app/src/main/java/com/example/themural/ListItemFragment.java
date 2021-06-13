package com.example.themural;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.FirebaseFirestore;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListItemFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListItemFragment extends Fragment implements View.OnClickListener{

    //state
    private FirebaseFirestore db;
    private RecyclerView recyclerListItems;


    public ListItemFragment() {
        // Required empty public constructor
    }


    public static ListItemFragment newInstance() {

        ListItemFragment fragment = new ListItemFragment();
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
        View root = inflater.inflate(R.layout.fragment_list_item, container, false);
        recyclerListItems = root.findViewById(R.id.recyclerViewMyPost);
        BottomNavigationView filterOrderNav = root.findViewById(R.id.filterOrderNav);
        BottomNavigationView searchNav = root.findViewById(R.id.searchNav);
//        recyclerListItems.setHasFixedSize(true);

        return root;
    }

    @Override
    public void onClick(View v) {

    }

    public void mostrarPost(){
        db.collection("publicaciones").document()
    }
}