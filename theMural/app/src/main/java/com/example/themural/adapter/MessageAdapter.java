package com.example.themural.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.themural.R;
import com.example.themural.data.model.Main;
import com.example.themural.data.model.Message;
import com.example.themural.ui.chat.MessageView;
import com.example.themural.ui.login.LoginActivity;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MessageAdapter extends RecyclerView.Adapter<MessageView> {

    private ArrayList<Message> messages;

    private Main main;

    public MessageAdapter(){
        main = LoginActivity.getMain();
        //messages = main.getUsers().get(0).getChat().
        messages = new ArrayList<>();
    }

    public void addMessage(Message nMessage){
        messages.add(nMessage);
        this.notifyDataSetChanged();
    }

    public void deleteMessage(Message dMessage){
        messages.remove(dMessage);
        this.notifyDataSetChanged();
    }

    @NonNull
    @NotNull
    @Override
    public MessageView onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View row = inflater.inflate(R.layout.fragment_message_sell_view_to,parent,false);

        MessageView messageView = new MessageView(row);

        return messageView;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MessageView holder, int position) {

        String nombre = main.getUsers().get(0).getName();

        long val = messages.get(position).getDate();
        Date date=new Date(val);
        SimpleDateFormat df2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dateText = df2.format(date);

        if(messages.get(position).getFrom().equals(nombre)){
            holder.getMessageUserNameText().setText(messages.get(position).getFrom());
            holder.getMessageViewText().setText(messages.get(position).getContent());
            holder.getDateText().setText(dateText);
            holder.getMessageUserNameText2().setVisibility(View.INVISIBLE);
            holder.getMessageViewText2().setVisibility(View.INVISIBLE);
            holder.getConstraintLayout().setBackgroundColor(Color.parseColor("#87F48C"));
            holder.getDateText().setBackgroundColor(Color.parseColor("#87F48C"));
        }else{
            holder.getMessageUserNameText2().setText(messages.get(position).getFrom());
            holder.getMessageViewText2().setText(messages.get(position).getContent());
            holder.getDateText().setText(dateText);
            holder.getMessageUserNameText().setVisibility(View.INVISIBLE);
            holder.getMessageViewText().setVisibility(View.INVISIBLE);
            holder.getConstraintLayout().setBackgroundColor(Color.parseColor("#FFC107"));
            holder.getDateText().setBackgroundColor(Color.parseColor("#FFC107"));
        }

    }

    @Override
    public int getItemCount() {
        return messages.size();
    }
}
