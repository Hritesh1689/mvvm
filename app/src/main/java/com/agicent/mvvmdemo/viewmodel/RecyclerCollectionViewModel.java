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
import com.agicent.mvvmdemo.model.CollectionResponse;
import com.agicent.mvvmdemo.utils.AndroidUtils;
import com.agicent.mvvmdemo.utils.ConstantUtils;
import com.bumptech.glide.Glide;

public class RecyclerCollectionViewModel extends BaseObservable {
    public String imageUrl;
    public MainActivity context;
    public CollectionResponse collectionResponse;

    @Bindable
    public String getImageUrl() {
        imageUrl=collectionResponse.getCollection_pic();
        return imageUrl;
    }

    public RecyclerCollectionViewModel(CollectionResponse collectionResponse, Context context) {
        this.collectionResponse = collectionResponse;
        this.context=(MainActivity)context;
    }

    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext()).load(imageUrl).into(view);
    }

    public void onItemClick(Integer index) {
        Bundle args = new Bundle();
        args.putString("collection_id" ,collectionResponse.getCollection_id());
        AndroidUtils.SelectedCollection=collectionResponse.getCollection_id();
        CategoryFragment categoryFragment=new CategoryFragment();
        categoryFragment.setArguments(args);
        loadFragment(categoryFragment, ConstantUtils.category_fragment_tag,context);

    }

    public  void loadFragment(Fragment fragment, String tag, MainActivity context) {
        FragmentTransaction fragmentTransaction = context.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment, tag).commit();
    }

}
