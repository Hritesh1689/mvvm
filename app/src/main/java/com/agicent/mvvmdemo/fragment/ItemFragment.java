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
import com.agicent.mvvmdemo.databinding.FragmentItemBinding;
import com.agicent.mvvmdemo.utils.AndroidUtils;
import com.agicent.mvvmdemo.utils.ConstantUtils;
import com.agicent.mvvmdemo.viewmodel.ItemViewModel;

public class ItemFragment extends Fragment {

    private ItemViewModel itemViewModel;
    private FragmentItemBinding fragmentItemBinding;
    private MainActivity context;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        getActivity().findViewById(R.id.progress_barwa).setVisibility(View.VISIBLE);
        getActivity().findViewById(R.id.fragment_container).setVisibility(View.GONE);

        fragmentItemBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_item, container, false);

        itemViewModel=new ItemViewModel(fragmentItemBinding.getRoot(), AndroidUtils.SelectedCollection,AndroidUtils.SelectedCategor);
        fragmentItemBinding.setItemModel(itemViewModel);

        if(getArguments().getString(ConstantUtils.SOURCE_STRING, "").equalsIgnoreCase(ConstantUtils.SEARCH_BY_CATEGORY))
        itemViewModel.setItems(ConstantUtils.SEARCH_BY_CATEGORY);
        else
            itemViewModel.setItems(ConstantUtils.SEARCH_BY_TAGS);
        return  fragmentItemBinding.getRoot();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context=(MainActivity)context;
    }
}
