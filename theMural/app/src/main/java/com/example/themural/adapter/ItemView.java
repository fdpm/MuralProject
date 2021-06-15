package com.example.themural.adapter;

import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.themural.HomeActivity;
import com.example.themural.R;
import com.example.themural.data.model.Main;
import com.example.themural.fragment_chat_sell;

public class ItemView extends RecyclerView.ViewHolder implements View.OnClickListener {

    private ConstraintLayout root;

    private TextView theItemTitle;
    private TextView theDescItem;
    private TextView  theLocationItem;
    private TextView thePriceItem;
    private TextView theItemType;
    private TextView buttonSeller;
    private TextView telET;

    private Main.OnItemListener onItemListener;


    public ItemView(ConstraintLayout root, Main.OnItemListener onItemListener) {
        super(root);
        this.root = root;
        //Ids del xml itemrow
        theItemTitle = root.findViewById(R.id.theItemTitle);
        theDescItem = root.findViewById(R.id.theDescItem);
        theLocationItem = root.findViewById(R.id.theLocationItem);
        thePriceItem = root.findViewById(R.id.thePriceItem);
        theItemType = root.findViewById(R.id.theItemType);
        buttonSeller = root.findViewById(R.id.buttonSeller);
        telET = root.findViewById(R.id.telET);
        buttonSeller.setOnClickListener(this);
    }

    public ConstraintLayout getRoot() {
        return root;
    }

    public TextView getTitleItem() {
        return theItemTitle;
    }

    public TextView getDescriptionItem() {
        return theDescItem;
    }

    public TextView getLocationItem() {
        return theLocationItem;
    }

    public TextView getPriceItem() {
        return thePriceItem;
    }

    public TextView getTheItemType() {
        return theItemType;
    }

    public TextView getButtonSeller() {
        return buttonSeller;
    }

    public TextView getTelET() {
        return telET;
    }

    public void setTelET(TextView telET) {
        this.telET = telET;
    }

    public void setButtonSeller(TextView buttonSeller) {
        this.buttonSeller = buttonSeller;
    }

    @Override
    public void onClick(View v) {
//        onItemListener.onItemClick(getAdapterPosition());
        switch (v.getId()) {
            case R.id.buttonSeller:

                Toast.makeText(root.getContext(), "producto: "+theItemTitle.getText(), Toast.LENGTH_SHORT).show();
            break;
        }
    }
}
