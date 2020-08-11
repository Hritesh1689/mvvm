package com.agicent.mvvmdemo.Adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.agicent.mvvmdemo.R;
import com.agicent.mvvmdemo.databinding.RecyclerItemAvailableColorBinding;
import com.agicent.mvvmdemo.model.ColorsbyId;
import com.agicent.mvvmdemo.viewmodel.RecyclerColorViewModel;

import java.util.ArrayList;

public class ColorsAdapter extends RecyclerView.Adapter<ColorsAdapter.MyViewHolder> {

    private ArrayList<ColorsbyId> listOfColors;
    private LayoutInflater layoutInflater;


    public void update(ArrayList<ColorsbyId> colorslist) {
        if( colorslist==null || colorslist.isEmpty())
            this.listOfColors.clear();
        else
            this.listOfColors=colorslist;

        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if(layoutInflater==null)
            layoutInflater=LayoutInflater.from(parent.getContext());
        RecyclerItemAvailableColorBinding binding= DataBindingUtil.inflate(layoutInflater, R.layout.recycler_item_available_color,parent,false);

        return new ColorsAdapter.MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        ColorsbyId colorsbyId=listOfColors.get(position);
        holder.binding.setRecyclerColorViewModel(new RecyclerColorViewModel(colorsbyId,holder.itemView.getContext()));

    }

    public ColorsAdapter() {
        listOfColors = new ArrayList<>();
    }

    @Override
    public int getItemCount() {
        return listOfColors.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

         RecyclerItemAvailableColorBinding binding;
        public MyViewHolder(@NonNull RecyclerItemAvailableColorBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
