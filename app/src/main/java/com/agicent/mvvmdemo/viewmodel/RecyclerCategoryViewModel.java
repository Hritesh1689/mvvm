package com.agicent.mvvmdemo.viewmodel;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.agicent.mvvmdemo.Activity.MainActivity;
import com.agicent.mvvmdemo.R;
import com.agicent.mvvmdemo.fragment.CategoryFragment;
import com.agicent.mvvmdemo.fragment.ItemFragment;
import com.agicent.mvvmdemo.model.CategoryResponse;
import com.agicent.mvvmdemo.utils.AndroidUtils;
import com.agicent.mvvmdemo.utils.ConstantUtils;
import com.bumptech.glide.Glide;

public class RecyclerCategoryViewModel extends BaseObservable {
    private CategoryResponse categoryResponse;
    private MainActivity context;


    @Bindable
    public String getCategoryname() {
        return categoryResponse.getCategory_name();
    }

    public RecyclerCategoryViewModel(CategoryResponse categoryResponse, Context context) {
        this.categoryResponse = categoryResponse;
        this.context=(MainActivity) context;
    }

    @Bindable
    public String getImageUrl() {
        return categoryResponse.getCategory_pic();
    }

    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext()).load(imageUrl).into(view);
    }

    public void onItemClick(Integer index) {
        Bundle args = new Bundle();
        args.putString(ConstantUtils.SOURCE_STRING ,ConstantUtils.SEARCH_BY_CATEGORY);
        AndroidUtils.SelectedCategor=categoryResponse.getCategory_id();
        ItemFragment itemFragment=new ItemFragment();
        itemFragment.setArguments(args);
        loadFragment(itemFragment, ConstantUtils.item_fragment_tag,context);

    }

    public  void loadFragment(Fragment fragment, String tag, MainActivity context) {
        FragmentTransaction fragmentTransaction = context.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment, tag).commit();
    }


}
