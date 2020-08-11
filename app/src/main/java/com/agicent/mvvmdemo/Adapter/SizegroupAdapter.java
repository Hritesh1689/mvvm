package com.agicent.mvvmdemo.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.agicent.mvvmdemo.R;
import com.agicent.mvvmdemo.databinding.RecyclerItemSizegroupBinding;
import com.agicent.mvvmdemo.model.SizegroupResponse;
import com.agicent.mvvmdemo.viewmodel.RecyclerSizegroupViewModel;

import java.util.ArrayList;

public class SizegroupAdapter extends RecyclerView.Adapter<SizegroupAdapter.MyViewHolder> {

    private LayoutInflater layoutInflater;
    private ArrayList<SizegroupResponse> listOfSizegroup;

    public void update(ArrayList<SizegroupResponse> sizegrouplist) {
        if(sizegrouplist==null || sizegrouplist.isEmpty())
            this.listOfSizegroup.clear();
        else
            this.listOfSizegroup=sizegrouplist;
        notifyDataSetChanged();
    }

    public SizegroupAdapter() {
        listOfSizegroup = new ArrayList<>();
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(layoutInflater==null)
            layoutInflater = LayoutInflater.from(parent.getContext());
        RecyclerItemSizegroupBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.recycler_item_sizegroup, parent, false);
        return new SizegroupAdapter.MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        SizegroupResponse sizegroupResponse=listOfSizegroup.get(position);
        holder.binding.setRecyclerSizegroupViewModel(new RecyclerSizegroupViewModel(sizegroupResponse,holder.itemView.getContext()));

    }

    @Override
    public int getItemCount() {
        return listOfSizegroup.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private RecyclerItemSizegroupBinding binding;

        public MyViewHolder(@NonNull RecyclerItemSizegroupBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
