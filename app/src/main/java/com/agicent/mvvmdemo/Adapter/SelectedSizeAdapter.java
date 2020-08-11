package com.agicent.mvvmdemo.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.agicent.mvvmdemo.R;
import com.agicent.mvvmdemo.databinding.RecyclerItemSelectedSizesBinding;
import com.agicent.mvvmdemo.model.CartItemSizeGroupResponse;
import com.agicent.mvvmdemo.viewmodel.RecyclerSelectedSizeViewModel;

import java.util.ArrayList;

public class SelectedSizeAdapter extends RecyclerView.Adapter<SelectedSizeAdapter.MyViewHolder> {

    private ArrayList<CartItemSizeGroupResponse> listOfCartItems;
    private LayoutInflater layoutInflater;

    public void update(ArrayList<CartItemSizeGroupResponse> selectedItemList) {
        if(selectedItemList==null || selectedItemList.isEmpty())
            this.listOfCartItems.clear();
        else
            this.listOfCartItems=selectedItemList;

        notifyDataSetChanged();
    }

    public SelectedSizeAdapter() {
        listOfCartItems = new ArrayList<>();
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
       if(layoutInflater==null)
           layoutInflater=LayoutInflater.from(parent.getContext());

        RecyclerItemSelectedSizesBinding binding= DataBindingUtil.inflate(layoutInflater, R.layout.recycler_item_selected_sizes,parent,false) ;

        return new SelectedSizeAdapter.MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        CartItemSizeGroupResponse cartItemSizeGroupResponse=listOfCartItems.get(position);
        holder.binding.setRecyclerSelectedSizeViewModel(new RecyclerSelectedSizeViewModel(cartItemSizeGroupResponse,holder.itemView.getContext()));

    }

    @Override
    public int getItemCount() {
        return listOfCartItems.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private RecyclerItemSelectedSizesBinding binding;

        public MyViewHolder(@NonNull RecyclerItemSelectedSizesBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
