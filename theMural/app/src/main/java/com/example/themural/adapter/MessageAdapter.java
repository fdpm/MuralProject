package com.example.themural.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.themural.R;
import com.example.themural.data.model.Message;
import com.example.themural.ui.chat.MessageView;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MessageAdapter extends RecyclerView.Adapter<MessageView> {

    private ArrayList<Message> messages;

    public MessageAdapter(){
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
        View row = inflater.inflate(R.layout.fragment_message_sell_view,parent,false);
        MessageView messageView = new MessageView(row);

        return messageView;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MessageView holder, int position) {
        long val = messages.get(position).getDate();
        Date date=new Date(val);
        SimpleDateFormat df2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dateText = df2.format(date);

        //holder.getMessageUserNameText().setText(messages.get(position).getId());
        holder.getMessageUserNameText().setText("pedro");
        holder.getMessageViewText().setText(messages.get(position).getContent());
        holder.getDateText().setText(dateText);
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }
}
