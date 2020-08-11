package com.agicent.mvvmdemo.viewmodel;

import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;


import androidx.databinding.library.baseAdapters.BR;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;


import com.agicent.mvvmdemo.Activity.MainActivity;
import com.agicent.mvvmdemo.Adapter.ItemAdapter;

import com.agicent.mvvmdemo.DataRepository.ItemRespository;
import com.agicent.mvvmdemo.Interface.APIComplete;

import com.agicent.mvvmdemo.R;
import com.agicent.mvvmdemo.model.AllItemResponse;

import com.agicent.mvvmdemo.model.ItemResponse;
import com.nostra13.universalimageloader.core.DisplayImageOptions;

import java.util.ArrayList;

public class ItemViewModel extends BaseObservable implements APIComplete {

    private View id__layout;
    private MutableLiveData<AllItemResponse> itemResponse;
    private ItemRespository itemRepository;
    private ArrayList<ItemResponse> allItems;
    private String collection_id,category_id;
    public static DisplayImageOptions options;
    private static boolean throughInterface=false;
    private ItemAdapter itemAdapter;


    public  ItemViewModel(View id__layout,String collection_id,String category_id) {
        this.id__layout = id__layout;
        this.collection_id=collection_id;
        this.category_id=category_id;
        itemAdapter=new ItemAdapter();
    }



    @BindingAdapter({"itemAdapter","allItems"})
    public static void bind(RecyclerView recyclerView, ItemAdapter itemAdapter, ArrayList<ItemResponse> allItems){
        recyclerView.setAdapter(itemAdapter);
        itemAdapter.update(allItems);
    }

    @Bindable
    public ArrayList<ItemResponse> getAllItems() {
        return allItems;
    }
    @Bindable
    public ItemAdapter getItemAdapter() {
        return itemAdapter;
    }

    @Override
    public void complete() {
        throughInterface=true;
        allItems=itemResponse.getValue().getItems();
        notifyPropertyChanged(BR.allItems);

        MainActivity context=(MainActivity)id__layout.getContext();
        context.findViewById(R.id.progress_barwa).setVisibility(View.GONE);
        context.findViewById(R.id.fragment_container).setVisibility(View.VISIBLE);
    }

    public void setItems(String source){
        if(itemResponse!=null){
            return;
        }
        itemRepository=new ItemRespository(this,collection_id,category_id);
        itemResponse=itemRepository.getItemResponse(id__layout.getContext(),source);
    }


}
