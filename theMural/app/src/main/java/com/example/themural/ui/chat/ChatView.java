package com.example.themural.ui.chat;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.themural.R;
import com.example.themural.adapter.ChatAdapter;

import org.jetbrains.annotations.NotNull;

public class ChatView extends RecyclerView.ViewHolder implements View.OnClickListener {

    //private ConstraintLayout root;
    private TextView chatUserNameText;
    private TextView lastMessageText;
    private ChatAdapter.OnChatListener onChatListener;

    public ChatView(View root, ChatAdapter.OnChatListener onChatListener){
        super(root);
        //this.root=root;
        chatUserNameText = root.findViewById(R.id.chatUserNameText);
        lastMessageText = root.findViewById(R.id.lastMessageText);
        this.onChatListener = onChatListener;
        root.setOnClickListener(this);
    }
/*
    public ConstraintLayout getRoot(){
        return root;
    }*/

    public TextView getChatUserNameText(){
        return chatUserNameText;
    }

    public TextView getLastMessageText(){
        return lastMessageText;
    }

    @Override
    public void onClick(View v) {
        onChatListener.onChatClick(getAdapterPosition());
    }
}
