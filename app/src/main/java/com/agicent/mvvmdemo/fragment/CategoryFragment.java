package com.agicent.mvvmdemo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import com.agicent.mvvmdemo.Activity.MainActivity;
import com.agicent.mvvmdemo.R;
import com.agicent.mvvmdemo.databinding.FragmentCategoryBinding;
import com.agicent.mvvmdemo.utils.AndroidUtils;
import com.agicent.mvvmdemo.viewmodel.CategoryViewModel;

public class CategoryFragment extends Fragment {

    private CategoryViewModel categoryViewModel;
    private FragmentCategoryBinding fragmentCategoryBinding;
    private String collection_id;
    private MainActivity context;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getActivity().findViewById(R.id.progress_barwa).setVisibility(View.VISIBLE);
        getActivity().findViewById(R.id.fragment_container).setVisibility(View.GONE);

        fragmentCategoryBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_category, container, false);

        categoryViewModel=new CategoryViewModel(fragmentCategoryBinding.getRoot(), AndroidUtils.SelectedCollection);
        fragmentCategoryBinding.setCategoryModel(categoryViewModel);
        categoryViewModel.setCategories();
        return  fragmentCategoryBinding.getRoot();

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context=(MainActivity)context;
    }
}
