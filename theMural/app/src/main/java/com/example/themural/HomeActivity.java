package com.example.themural;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

//Actividad principal
public class HomeActivity extends AppCompatActivity {

    //Donde hosteamos las actividades a llamar
    private NewItemFragment newItemFragment;
    private ListItemFragment listItemFragment;
    private BottomNavigationView navigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        navigator = findViewById(R.id.navigator);

        newItemFragment = NewItemFragment.newInstance();
        listItemFragment = ListItemFragment.newInstance();

        showFragment(newItemFragment);
        navigator.setOnNavigationItemSelectedListener(
                (menuItem)->{
                    switch (menuItem.getItemId()){
                        case R.id.listItem:
                            //Aqui se especifica el fragmento a mostrar
                            showFragment(newItemFragment);
                            break;
                        case R.id.addItem:
                            showFragment(listItemFragment);
                            break;
                        case R.id.chatItem:
                            //showFragment();
                            break;
                        case R.id.profileItem:
                            //showFragment();
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