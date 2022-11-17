package com.example.coffeeshoffee.Adapters;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coffeeshoffee.Models.CartModels;
import com.example.coffeeshoffee.Models.MainModel;
import com.example.coffeeshoffee.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CartAdapters extends RecyclerView.Adapter<CartAdapters.viewholder> {

    ArrayList<CartModels> list;
    Context context;

    public CartAdapters(ArrayList<CartModels> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cart_samplefood, parent, false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {

        final CartModels model = list.get(position);
        holder.cartfoodimage.setImageResource(model.getCartimage());
        holder.cartfoodname.setText(model.getCartname());
        holder.cartfoodprice.setText(model.getCartprice());
        holder.cartorderNumber.setText(model.getCartorderNumber());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{

        ImageView cartfoodimage;
        TextView cartfoodname, cartfoodprice, cartorderNumber;

        public viewholder(@NonNull View itemView) {
            super(itemView);

            cartfoodimage = itemView.findViewById(R.id.cartfoodimage);
            cartfoodname = itemView.findViewById(R.id.cartfoodname);
            cartfoodprice = itemView.findViewById(R.id.cartfoodprice);
            cartorderNumber = itemView.findViewById(R.id.cartorderNumber);
        }
    }
}
