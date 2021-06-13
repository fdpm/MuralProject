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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_chat_sell#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_chat_sell extends Fragment implements View.OnClickListener, ChatAdapter.OnChatListener {

    private RecyclerView chatSellList;
    private ChatAdapter adapter;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragment_chat_sell() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static fragment_chat_sell newInstance() {
        fragment_chat_sell fragment = new fragment_chat_sell();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
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


        return inflater.inflate(R.layout.fragment_chat_sell, container, false);
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