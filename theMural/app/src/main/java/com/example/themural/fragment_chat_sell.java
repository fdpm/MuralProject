package com.example.themural;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.themural.adapter.ChatAdapter;
import com.example.themural.data.model.Chat;
import com.example.themural.data.model.Main;
import com.example.themural.data.model.User;
import com.example.themural.ui.login.LoginActivity;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class fragment_chat_sell extends Fragment implements View.OnClickListener, ChatAdapter.OnChatListener {

    private RecyclerView chatSellList;
    private ChatAdapter adapter;

    private FirebaseFirestore db;

    private static Main main;

    public fragment_chat_sell() {

    }

    public static fragment_chat_sell newInstance() {
        fragment_chat_sell fragment = new fragment_chat_sell();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = FirebaseFirestore.getInstance();
        main = LoginActivity.getMain();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_chat_sell, container,false);
        chatSellList = (RecyclerView) root.findViewById(R.id.chatSellList);
        chatSellList.setHasFixedSize(true);
        chatSellList.setOnClickListener(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        chatSellList.setLayoutManager(layoutManager);

        ArrayList<Chat> chat = new ArrayList<>();
        Chat c = new Chat("Juan");
        Chat cc = new Chat("Paco");
        User u = main.getUsers().get(0);
        chat.add(c);
        chat.add(cc);
        u.setChat(chat);
        main.getUsers().set(0,u);
        //LoginActivity.setMain(main);
        //db.collection("usuarios").document(u.getUserId()).set(u);
        adapter = new ChatAdapter(this, u.getChat());
        chatSellList.setAdapter(adapter);

        return root;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onChatClick(int position) {
        fragment_chat_window cwFragment = new fragment_chat_window();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainer, cwFragment);
        transaction.addToBackStack(null);
        Bundle bundle = new Bundle();
        bundle.putString("nombre", adapter.getChat().get(position).getType());
        cwFragment.setArguments(bundle);
        transaction.commit();

    }
}