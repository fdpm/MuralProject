package com.example.themural.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.themural.R;

public class ItemView extends RecyclerView.ViewHolder {

    private ConstraintLayout root;
    private TextView titleItem;
    private TextView descriptionItem;
    private TextView  locationItem;
    private TextView priceItem;


    public ItemView(ConstraintLayout root) {
        super(root);
        this.root = root;
        //Ids del xml itemrow
        titleItem = root.findViewById(R.id.theItemTiltle);
        descriptionItem = root.findViewById(R.id.theDescItem);
        locationItem = root.findViewById(R.id.theLocationItem);
        priceItem = root.findViewById(R.id.thePriceItem);
    }

    public ConstraintLayout getRoot() {
        return root;
    }

    public TextView getTitleItem() {
        return titleItem;
    }

    public TextView getDescriptionItem() {
        return descriptionItem;
    }

    public TextView getLocationItem() {
        return locationItem;
    }

    public TextView getPriceItem() {
        return priceItem;
    }
}
