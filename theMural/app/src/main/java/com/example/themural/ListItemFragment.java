package com.example.themural;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import com.example.themural.data.model.Item;

import com.example.themural.data.model.Main;

import com.example.themural.ui.login.LoginActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListItemFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListItemFragment extends Fragment implements View.OnClickListener, Main.OnItemListener, fragment_post_item.OnfilterCategory {

    //state
    private FirebaseFirestore db;
    private RecyclerView recyclerListItems;

    private BottomNavigationView filterOrderNav;
    private BottomNavigationView searchNav;
    private Button buttonSeller;

    private Item item;
    private ArrayList<Item> posts;

    //private LinearLayoutManager layoutManager;

    //El adaptador es el main
    private Main adapter;
    private String category;

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
        item = new Item();
        posts = new ArrayList<>();
        adapter = LoginActivity.getMain();
        /*
        recyclerListItems.findViewById(R.id.recyclerListItems);
        layoutManager = new LinearLayoutManager(this.getContext());
        recyclerListItems.setLayoutManager(layoutManager);
        adapter = new Main(this.);
        recyclerListItems.setAdapter(adapter);

         */



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_list_item, container, false);
        recyclerListItems = root.findViewById(R.id.recyclerListItems);
        filterOrderNav = root.findViewById(R.id.filterOrderNav);
        searchNav = root.findViewById(R.id.searchNav);
        buttonSeller = root.findViewById(R.id.buttonSeller);
//        recyclerListItems.setHasFixedSize(true);


        //recyclerListItems = (RecyclerView) root.findViewById(R.id.recyclerListItems);
        recyclerListItems.setHasFixedSize(true);
        recyclerListItems.setOnClickListener(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerListItems.setLayoutManager(layoutManager);
        searchNav.setOnClickListener(this);
        //buttonSeller.setOnClickListener(this);

        showPost();
        filterOrderNav.setOnNavigationItemSelectedListener((upMenuItem)->{
            switch (upMenuItem.getItemId()){
                case R.id.filterItem:
                    // Crea el nuevo fragmento y la transacción.
                    Fragment support = new fragment_post_item();
                    FragmentTransaction transactionSupport = getFragmentManager().beginTransaction();
                    transactionSupport.replace(R.id.fragmentContainer, support);
                    transactionSupport.addToBackStack(null);
                    // Commit a la transacción
                    transactionSupport.commit();
                    break;
                case R.id.sortItem:
                    adapter.reverse();
                    recyclerListItems.setAdapter(adapter);
                    break;
            }
            return true;
        });

        return root;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.searchNav:

                break;
            case R.id.buttonSeller:
                Log.e("hello moto", "sizasiza");
        }
    }


    public void showPost() {
        adapter.refreshPosts();
        db.collection("publicaciones").get().addOnCompleteListener(
                task -> {
                    if (task.isSuccessful()) {
                        if (task.getResult().size() > 0) {
                            //ArrayList<Item> theItems = task.getResult().toObjects(ArrayList<Item.class>);
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                item = document.toObject(Item.class);

                                adapter.newPost(item);


                            }
                        }
                    }
                });
        adapter.filter(category);
        recyclerListItems.setAdapter(adapter);

    }

    @Override
    public void onItemClick(int position) {
        fragment_detail_item cwFragment = new fragment_detail_item();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainer, cwFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void filterCategory(String category) {
        this.category = category;
    }
}