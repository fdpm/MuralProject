package com.example.themural.adapter;

import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.themural.R;

public class ItemView extends RecyclerView.ViewHolder {

    private ConstraintLayout root;
    private TextView theItemTitle;
    private TextView theDescItem;
    private TextView  theLocationItem;
    private TextView thePriceItem;


    public ItemView(ConstraintLayout root) {
        super(root);
        this.root = root;
        //Ids del xml itemrow
        theItemTitle = root.findViewById(R.id.theItemTitle);
        theDescItem = root.findViewById(R.id.theDescItem);
        theLocationItem = root.findViewById(R.id.theLocationItem);
        thePriceItem = root.findViewById(R.id.thePriceItem);
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
}
