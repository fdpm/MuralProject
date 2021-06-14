package com.example.themural;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.themural.adapter.MessageAdapter;
import com.example.themural.data.model.Message;

public class fragment_chat_window extends Fragment implements  View.OnClickListener{

    private TextView personTitleText;
    private TextView messageText;
    private Button sendMessageButton;
    private RecyclerView messageList;

    private MessageAdapter messageAdapter;

    public fragment_chat_window() {

    }

    public static fragment_chat_window newInstance() {
        fragment_chat_window fragment = new fragment_chat_window();
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

        View root = inflater.inflate(R.layout.fragment_chat_window, container, false);
        messageList = (RecyclerView) root.findViewById(R.id.messageList);
        messageList.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        messageList.setLayoutManager(layoutManager);

        personTitleText = root.findViewById(R.id.personTitleText);
        messageText = root.findViewById(R.id.messageText);
        sendMessageButton = root.findViewById(R.id.sendMessageButton);
        sendMessageButton.setOnClickListener(this);

        messageAdapter = new MessageAdapter();
        messageList.setAdapter(messageAdapter);

        return root;
    }

    @Override
    public void onClick(View v) {
        switch ((v.getId())){
            case R.id.sendMessageButton:
                if (!messageText.getText().toString().isEmpty()){
                    String textMessage = messageText.getText().toString();
                    Message nMessage = new Message(textMessage);
                    System.out.println(nMessage.getContent());
                    messageAdapter.addMessage(nMessage);
                }
                break;

        }
    }
}