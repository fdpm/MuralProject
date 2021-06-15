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
import com.example.themural.data.model.Main;
import com.example.themural.ui.login.LoginActivity;

public class fragment_chat_sell extends Fragment implements View.OnClickListener, ChatAdapter.OnChatListener {

    private RecyclerView chatSellList;
    private ChatAdapter adapter;

    private Main main;

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

        adapter = new ChatAdapter(this, main.getUsers().get(0).getChat());
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
        //bundle.put
        transaction.commit();

    }
}