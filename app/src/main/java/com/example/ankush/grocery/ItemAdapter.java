package com.example.ankush.grocery;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder> {

    int[] imageArray;
    int[] priceArray;
    String[] modelNames;
    public  int totalSum = 0;
    Context mContext;

    public ItemAdapter() {}

    public ItemAdapter(Context context, int[] imageArray, int[] priceArray, String[] modelNames) {
        this.imageArray = imageArray;
        this.priceArray = priceArray;
        this.modelNames = modelNames;
        mContext = context;
    }

    @Override
    public ItemAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ItemAdapter.MyViewHolder holder, final int position) {
        holder.itemImageView.setImageResource(imageArray[position]);
        holder.itemPrice.setText("Rs "+Integer.toString(priceArray[position]));
        holder.modelName.setText(modelNames[position]);
        holder.cartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    totalSum = totalSum + priceArray[position];
                    Toast.makeText(mContext, "Added.... Total Amount : Rs "+totalSum, Toast.LENGTH_SHORT).show();
                    holder.cartButton.setBackgroundResource(R.drawable.ic_check_box_black_24dp);
            }
        });
    }

    @Override
    public int getItemCount() {
        return imageArray.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImageView;
        TextView itemPrice, modelName;
        Button cartButton;
        public MyViewHolder(View itemView) {
            super(itemView);

            itemImageView = itemView.findViewById(R.id.item_imageview);
            itemPrice = itemView.findViewById(R.id.item_price);
            cartButton = itemView.findViewById(R.id.addtocart);
            modelName = itemView.findViewById(R.id.model_name);
        }
    }
}
