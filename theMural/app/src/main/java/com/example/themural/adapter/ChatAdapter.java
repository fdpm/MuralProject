package com.example.themural.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.themural.R;
import com.example.themural.data.model.Chat;
import com.example.themural.data.model.Message;
import com.example.themural.ui.chat.ChatView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter<ChatView> {

    private ArrayList<Chat> chat;
    private OnChatListener onChatListener;

    public ChatAdapter(OnChatListener onChatListener){
        this.onChatListener = onChatListener;
        chat = new ArrayList<>();
        Chat ca = new Chat("pedro");
        ca.addMessage(new Message("hola"));
        chat.add(ca);
    }

    public void addChat(Chat nChat){
        chat.add(nChat);
        this.notifyDataSetChanged();
    }

    public void deleteChat(Chat dChat){
        chat.remove(dChat);
        this.notifyDataSetChanged();
    }

    @NonNull
    @NotNull
    @Override
    public ChatView onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View row = inflater.inflate(R.layout.fragment_chat_sell_view, parent, false);
        ConstraintLayout rowroot = (ConstraintLayout) row;
        ChatView chatView = new ChatView(rowroot, onChatListener);

        return chatView;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ChatView holder, int position) {
        //holder.getChatUserNameText().setText(chat.get(position).get);
        //holder.getChatUserNameText().setText(chat.get(position).get);
    }

    @Override
    public int getItemCount() {
        return chat.size();
    }

    public interface OnChatListener{
        void onChatClick(int position);
    }
}
