package com.example.themural;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.themural.data.model.Item;
import com.example.themural.data.model.User;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListItemFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListItemFragment extends Fragment implements View.OnClickListener {

    //state
    private FirebaseFirestore db;
    private RecyclerView recyclerListItems;
    private Item item;


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

        mostrarPost();
        return root;
    }

    @Override
    public void onClick(View v) {

    }

    public void mostrarPost() {
        db.collection("publicaciones").get().addOnCompleteListener(
                task -> {
                    if (task.isSuccessful()) {
                        if (task.getResult().size() > 0) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                item = document.toObject(Item.class);
                                Log.e(">>>", item.getDescriptionItem());

                       /* String nombre = documento.getString("nameItem");
                        String descripcion = documento.getString("descriptionItem");
                        String id = documento.getString("idItem");
                        String locacion = documento.getString("locationItem");
                        String tipo = documento.getString("typeItem");
                        int precio = Integer.parseInt(documento.getString("priceItem"));
                        int estado = Integer.parseInt(documento.getString("stateItem"));
                        */
                            }
                        }
                    }
                });
    }

}