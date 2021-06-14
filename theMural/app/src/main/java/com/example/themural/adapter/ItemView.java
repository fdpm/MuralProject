package com.example.themural.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.themural.R;
import com.example.themural.data.model.Main;

public class ItemView extends RecyclerView.ViewHolder implements View.OnClickListener {

    private ConstraintLayout root;
    private TextView theItemTitle;
    private TextView theDescItem;
    private TextView  theLocationItem;
    private TextView thePriceItem;
    private Main.OnItemListener onItemListener;


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

    @Override
    public void onClick(View v) {
        onItemListener.onItemClick(getAdapterPosition());
    }
}
