package com.agicent.mvvmdemo.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.agicent.mvvmdemo.R;
import com.agicent.mvvmdemo.databinding.RecyclerItemSelectedColorBinding;
import com.agicent.mvvmdemo.model.ColorQuantityResponse;
import com.agicent.mvvmdemo.viewmodel.RecyclerSelectedColorViewModel;

import java.util.ArrayList;

public class SelectedColorAdapter extends RecyclerView.Adapter<SelectedColorAdapter.MyViewHolder> {

    private ArrayList<ColorQuantityResponse> listOfColorQuantitiy;
    private LayoutInflater layoutInflater;
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(layoutInflater==null)
            layoutInflater=LayoutInflater.from(parent.getContext());

        RecyclerItemSelectedColorBinding binding= DataBindingUtil.inflate(layoutInflater, R.layout.recycler_item_selected_color,parent,false);


        return new SelectedColorAdapter.MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ColorQuantityResponse colorQuantityResponse=listOfColorQuantitiy.get(position);
        holder.binding.setRecyclerSelectedColorViewModel(new RecyclerSelectedColorViewModel(colorQuantityResponse,holder.itemView.getContext()));
    }

    @Override
    public int getItemCount() {
        return listOfColorQuantitiy.size();
    }

    public void update(ArrayList<ColorQuantityResponse> colorQuantityList) {

        if( colorQuantityList==null || colorQuantityList.isEmpty())
            this.listOfColorQuantitiy.clear();
        else
            this.listOfColorQuantitiy=colorQuantityList;

        notifyDataSetChanged();
    }

    public SelectedColorAdapter() {
        listOfColorQuantitiy = new ArrayList<>();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        private RecyclerItemSelectedColorBinding binding;
        public MyViewHolder(@NonNull RecyclerItemSelectedColorBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
