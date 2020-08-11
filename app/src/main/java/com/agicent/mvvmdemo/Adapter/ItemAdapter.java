package com.agicent.mvvmdemo.Adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.agicent.mvvmdemo.R;
import com.agicent.mvvmdemo.databinding.RecylerItemBinding;
import com.agicent.mvvmdemo.model.ItemResponse;
import com.agicent.mvvmdemo.viewmodel.RecyclerItemViewModel;
import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder> {

    private ArrayList<ItemResponse> list;
    private LayoutInflater layoutInflater;
    @NonNull
    @Override
    public ItemAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(layoutInflater==null)
            layoutInflater = LayoutInflater.from(parent.getContext());
        RecylerItemBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.recyler_item, parent, false);
        return new ItemAdapter.MyViewHolder(binding);
    }

    public ItemAdapter(){
        list=new ArrayList<>();
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.MyViewHolder holder, int position) {
        ItemResponse itemResponse=list.get(position);
        holder.binding.setItemmodel(new RecyclerItemViewModel(itemResponse,holder.itemView.getContext()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void update(ArrayList<ItemResponse> allItems) {
        if(allItems==null || allItems.isEmpty())
            this.list.clear();
        else
            this.list.addAll(allItems);
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        RecylerItemBinding binding;
        public MyViewHolder(@NonNull RecylerItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }}
}
