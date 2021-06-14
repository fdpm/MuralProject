package com.example.themural.ui.chat;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.themural.R;

public class MessageView extends RecyclerView.ViewHolder {

    private TextView messageUserNameText;
    private TextView messageViewText;
    private TextView dateText;

    public MessageView(View root) {
        super(root);

        messageUserNameText = root.findViewById(R.id.messageUserNameText);
        messageViewText = root.findViewById(R.id.messageViewText);
        dateText = root.findViewById(R.id.dateText);
    }

    public TextView getMessageUserNameText() {
        return messageUserNameText;
    }

    public TextView getMessageViewText() {
        return messageViewText;
    }

    public TextView getDateText() {
        return dateText;
    }
}
