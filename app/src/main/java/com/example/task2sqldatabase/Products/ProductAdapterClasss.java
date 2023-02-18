package com.example.task2sqldatabase.Products;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.task2sqldatabase.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ProductAdapterClasss extends RecyclerView.Adapter<ProductAdapterClasss.Productviewholder> {
    Context context;
    ArrayList<ModelProducts> productarraylist;

    public ProductAdapterClasss(Context context, ArrayList<ModelProducts> productarraylist) {
        this.context = context;
        this.productarraylist = productarraylist;
    }

    @NonNull
    @Override
    public Productviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_single_card, parent, false);
        return new Productviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Productviewholder holder, int position) {

//        holder.pname.setText(productarraylist.get(position).getProductName());
//        holder.pprice.setText("\u20B9"+productarraylist.get(position).getProductPrice());
//        holder.pdiscout.setText(productarraylist.get(position).getProductDiscount());
//        holder.pdiscoutprice.setText(productarraylist.get(position).getProductDiscountPrice());
//        holder.pdescriprion.setText(productarraylist.get(position).getProductDescription());


    }

    @Override
    public int getItemCount() {
        return productarraylist.size();
    }

    public class Productviewholder extends RecyclerView.ViewHolder {

        TextView pname, pprice, pdiscout, pdiscoutprice, pdescriprion;

        public Productviewholder(@NonNull View itemView) {
            super(itemView);
            pname = itemView.findViewById(R.id.product_name_c_id);
            pprice = itemView.findViewById(R.id.product_price_c_id);
            pdiscout = itemView.findViewById(R.id.product_discout_c_id);
            pdiscoutprice = itemView.findViewById(R.id.product_disprice_id);
            pdescriprion = itemView.findViewById(R.id.product_description_c_id);
            pprice.setPaintFlags(pprice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }
    }
}
