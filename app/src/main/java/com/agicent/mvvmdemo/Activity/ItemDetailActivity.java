package com.agicent.mvvmdemo.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.agicent.mvvmdemo.R;
import com.agicent.mvvmdemo.databinding.ActivityItemDetailBinding;
import com.agicent.mvvmdemo.viewmodel.ItemDetailViewModel;

public class ItemDetailActivity extends AppCompatActivity {

    private ActivityItemDetailBinding activityItemDetailBinding;
    private ItemDetailViewModel itemDetailViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityItemDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_item_detail);
//        activityItemDetailBinding.setLifecycleOwner(lifecycleOwner);
        itemDetailViewModel=new ItemDetailViewModel(activityItemDetailBinding.getRoot());

        activityItemDetailBinding.setItemDetailViewModel(itemDetailViewModel);

        itemDetailViewModel.getItemDetails();
    }
}
