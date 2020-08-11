package com.agicent.mvvmdemo.Adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.agicent.mvvmdemo.R;
import com.agicent.mvvmdemo.databinding.RecyclerCollectionBinding;
import com.agicent.mvvmdemo.viewmodel.RecyclerCollectionViewModel;
import com.agicent.mvvmdemo.model.CollectionResponse;
import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder>  {
    private ArrayList<CollectionResponse> list;
    private LayoutInflater layoutInflater;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(layoutInflater==null)
            layoutInflater = LayoutInflater.from(parent.getContext());
        RecyclerCollectionBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.recycler_collection, parent, false);
        return new MyViewHolder(binding);
    }

    public HomeAdapter() {
        list=new ArrayList<>();
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        CollectionResponse collectionResponse=list.get(position);
        holder.binding.setModel(new RecyclerCollectionViewModel(collectionResponse,holder.itemView.getContext()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void update(ArrayList<CollectionResponse> allCollections) {
        if(allCollections==null || allCollections.isEmpty())
            this.list.clear();
        else
            this.list.addAll(allCollections);
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        RecyclerCollectionBinding binding;
         MyViewHolder(RecyclerCollectionBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }}
}
