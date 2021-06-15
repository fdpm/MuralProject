package com.example.themural.ui.chat;

import android.view.View;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.themural.R;

public class MessageView extends RecyclerView.ViewHolder {

    private TextView messageUserNameText;
    private TextView messageViewText;
    private TextView dateText;

    private TextView messageUserNameText2;
    private TextView messageViewText2;

    private ConstraintLayout constraintLayout;

    public MessageView(View root) {
        super(root);

        messageUserNameText = root.findViewById(R.id.messageUserNameText);
        messageViewText = root.findViewById(R.id.messageViewText);
        dateText = root.findViewById(R.id.dateText);
        constraintLayout = root.findViewById(R.id.constL);

        messageUserNameText2 = root.findViewById(R.id.messageUserNameText2);
        messageViewText2 = root.findViewById(R.id.messageViewText2);

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

    public TextView getMessageUserNameText2() {
        return messageUserNameText2;
    }

    public TextView getMessageViewText2() {
        return messageViewText2;
    }

    public ConstraintLayout getConstraintLayout() {
        return constraintLayout;
    }
}
