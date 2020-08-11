package com.agicent.mvvmdemo.viewmodel;

import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.library.baseAdapters.BR;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.agicent.mvvmdemo.Activity.MainActivity;
import com.agicent.mvvmdemo.Adapter.CategoryAdapter;
import com.agicent.mvvmdemo.DataRepository.CategoryRepository;
import com.agicent.mvvmdemo.Interface.APIComplete;
import com.agicent.mvvmdemo.R;
import com.agicent.mvvmdemo.model.AllCategoryResponse;
import com.agicent.mvvmdemo.model.CategoryResponse;
import com.nostra13.universalimageloader.core.DisplayImageOptions;

import java.util.ArrayList;

public class CategoryViewModel extends BaseObservable implements APIComplete {

    private View id__layout;
    private MutableLiveData<AllCategoryResponse> CategoryResponse;
    private CategoryRepository categoryRepository;
    private ArrayList<com.agicent.mvvmdemo.model.CategoryResponse> allCategories;
    private String collection_id;
    public static DisplayImageOptions options;
    private static boolean throughInterface=false;
    private CategoryAdapter categoryAdapter;


    public  CategoryViewModel(View id__layout,String collection_id) {
        this.id__layout = id__layout;
        this.collection_id=collection_id;
        categoryAdapter=new CategoryAdapter();
    }

    @Bindable
    public CategoryAdapter getCategoryAdapter() {
        return categoryAdapter;
    }

    @BindingAdapter({"categoryAdapter","allCategories"})
    public static void bind(RecyclerView recyclerView, CategoryAdapter categoryAdapter, ArrayList<CategoryResponse> allCategories){
        recyclerView.setAdapter(categoryAdapter);
        categoryAdapter.update(allCategories);
    }

    @Bindable
    public ArrayList<CategoryResponse> getAllCategories() {
        return allCategories;
    }

    @Override
    public void complete() {
        throughInterface=true;
        allCategories=CategoryResponse.getValue().getCategories();
        notifyPropertyChanged(BR.allCategories);
        MainActivity context=(MainActivity)id__layout.getContext();
        context.findViewById(R.id.progress_barwa).setVisibility(View.GONE);
        context.findViewById(R.id.fragment_container).setVisibility(View.VISIBLE);
    }

    public void setCategories(){
        if(CategoryResponse!=null){
            return;
        }
        categoryRepository=new CategoryRepository(this,collection_id);
        CategoryResponse=categoryRepository.getCategoryResponse(id__layout.getContext());
    }

}
