package com.example.themural;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.themural.adapter.ChatAdapter;

public class fragment_chat_sell extends Fragment implements View.OnClickListener, ChatAdapter.OnChatListener {

    private RecyclerView chatSellList;
    private ChatAdapter adapter;

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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_chat_sell, container,false);
        chatSellList = root.findViewById(R.id.chatSellList);
        chatSellList.setHasFixedSize(true);
        chatSellList.setOnClickListener(this);
        adapter = new ChatAdapter(this);
        chatSellList.setAdapter(adapter);
        //LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //chatSellList.setLayoutManager(layoutManager);

        return root;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onChatClick(int position) {
        //Intent intent = new Intent(this, .class);
        //intent.putExtra("selectedChat", );
        //startActivity(intent);
    }
}