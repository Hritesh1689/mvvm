package com.agicent.mvvmdemo.Adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.agicent.mvvmdemo.R;
import com.agicent.mvvmdemo.databinding.RecyclerCategoryBinding;
import com.agicent.mvvmdemo.model.CategoryResponse;
import com.agicent.mvvmdemo.viewmodel.RecyclerCategoryViewModel;
import java.util.ArrayList;
public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {

    private ArrayList<CategoryResponse> allCategory;
    private LayoutInflater layoutInflater;

    @NonNull
    @Override
    public CategoryAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null)
            layoutInflater = LayoutInflater.from(parent.getContext());



        RecyclerCategoryBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.recycler_category, parent, false);
        return new CategoryAdapter.MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.MyViewHolder holder, int position) {
        CategoryResponse categoryResponse = allCategory.get(position);
        holder.binding.setRecyclercategorymodel(new RecyclerCategoryViewModel(categoryResponse, holder.itemView.getContext()));
    }

    public void update(ArrayList<CategoryResponse> allCategories) {
        if (allCategories == null || allCategories.isEmpty())
            this.allCategory.clear();
        else
            this.allCategory.addAll(allCategories);
        notifyDataSetChanged();
    }

    public CategoryAdapter() {
        allCategory = new ArrayList<>();
    }

    @Override
    public int getItemCount() {
        return allCategory.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        RecyclerCategoryBinding binding;
        public MyViewHolder(@NonNull RecyclerCategoryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }}
}
