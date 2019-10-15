package com.example.aslamshop;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;

import com.example.aslamshop.model.ShoppingItem;

import java.util.LinkedList;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.ItemViewHolder>{

    private LayoutInflater mInflater;
    private final LinkedList<ShoppingItem> mItemList;

    public AdapterClass(Context context, LinkedList<ShoppingItem> mItemList) {
        this.mInflater = LayoutInflater.from(context);
        this.mItemList = mItemList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mItemView = mInflater.inflate(R.layout.card, viewGroup, false);
        return new ItemViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, int i) {
        ShoppingItem current = mItemList.get(i);
        itemViewHolder.mItemHeader.setText(current.getTitle());
        itemViewHolder.mItemDescription.setText(current.getDescription());
        //itemViewHolder.mItemQuantity.setText(current.getQuantity());
        itemViewHolder.mItemPrice.setText(current.getPrice());
        itemViewHolder.mItemImage.setImageDrawable(current.getImg());
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        final AdapterClass mAdapter;
        public final TextView mItemHeader;
        public final TextView mItemPrice;
        public final ImageView mItemImage;
        public final TextView mItemDescription;
        public final TextView mItemQuantity;
        public ShoppingItem item;

        public ItemViewHolder(@NonNull View item, AdapterClass mAdapter) {
            super(item);
            mItemHeader = itemView.findViewById(R.id.cardHeader);
            mItemPrice = itemView.findViewById(R.id.cardPrice);
            mItemImage = itemView.findViewById(R.id.imageofitem);
            mItemDescription = itemView.findViewById(R.id.cardDescription);
            mItemQuantity = itemView.findViewById(R.id.cardQuantity);
            this.mAdapter = mAdapter;
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case (R.id.increasequantity):
                    TextView view = v.findViewById(R.id.cardQuantity);
                    int quantity = Integer.parseInt(view.getText().toString());
                    view.setText(quantity + 1);
                    break;
                case (R.id.decreasequantity):
                    view = v.findViewById(R.id.cardQuantity);
                    quantity = Integer.parseInt(view.getText().toString());
                    view.setText(quantity - 1);
                    break;
            }
        }
    }
}
