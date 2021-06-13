package com.example.themural;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.themural.data.model.User;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.FirebaseFirestore;

//Actividad principal
public class HomeActivity extends AppCompatActivity {

    //Donde hosteamos las actividades a llamar
    private NewItemFragment newItemFragment;
    private ListItemFragment listItemFragment;
    private fragment_post_details postItem;
    private fragment_chat_sell chatSell;
    private fragment_chat_purchase chatPurchase;
    private fragment_profile profile;



    private BottomNavigationView navigator;

    //Firebase
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        navigator = findViewById(R.id.navigator);

        newItemFragment = NewItemFragment.newInstance();
        listItemFragment = ListItemFragment.newInstance();
        postItem = fragment_post_details.newInstance();
        chatSell = fragment_chat_sell.newInstance();
        chatPurchase = fragment_chat_purchase.newInstance();
        profile = fragment_profile.newInstance();


        showFragment(newItemFragment);
        navigator.setOnNavigationItemSelectedListener(
                (menuItem)->{
                    switch (menuItem.getItemId()){
                        case R.id.listItem:
                            //Aqui se especifica el fragmento a mostrar
                            showFragment(listItemFragment);
                            break;
                        case R.id.addItem:
                            showFragment(postItem);
                            break;
                        case R.id.chatItem:
                            showFragment(chatSell);
                            break;
                        case R.id.profileItem:
                            showFragment(profile);
                            break;
                    }
                    return true;
                }
        );
    }

    public void showFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        //Aqui se carga un fragmento por vez
        transaction.replace(R.id.fragmentContainer, fragment);
        transaction.commit();

    }



}