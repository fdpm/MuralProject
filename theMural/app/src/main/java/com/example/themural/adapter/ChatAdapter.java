package com.example.themural.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.themural.R;
import com.example.themural.data.model.Chat;
import com.example.themural.data.model.Main;
import com.example.themural.data.model.Message;
import com.example.themural.ui.chat.ChatView;
import com.example.themural.ui.login.LoginActivity;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter<ChatView> {

    private ArrayList<Chat> chat;
    private OnChatListener onChatListener;

    //private Main main;

    public ChatAdapter(OnChatListener onChatListener, ArrayList<Chat> chat){
        this.onChatListener = onChatListener;
        //main = LoginActivity.getMain();
        this.chat = chat;

        //main.getUsers().get(0).getChat()

        //dummy
        //Chat ca = new Chat("pedro");
        //ca.addMessage(new Message("hola", "pedro"));
        //chat.add(ca);
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

        ChatView chatView = new ChatView(row, onChatListener);


        return chatView;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ChatView holder, int position) {
        holder.getChatUserNameText().setText(chat.get(position).getType());
        if (!chat.get(position).getMessage().isEmpty()){
            holder.getLastMessageText().setText(chat.get(position).getMessage().get(0).getContent());
        }else{
            holder.getLastMessageText().setText("Nuevo chat");
        }

    }

    @Override
    public int getItemCount() {
        return chat.size();
    }

    public interface OnChatListener{
        void onChatClick(int position);
    }
}
