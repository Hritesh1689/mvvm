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
import com.agicent.mvvmdemo.databinding.ActivityMainBinding;
import com.agicent.mvvmdemo.databinding.FragmentHomeBinding;
import com.agicent.mvvmdemo.viewmodel.CollectionViewModel;

import java.lang.reflect.Field;

public class CollectionFragment extends Fragment {

    private CollectionViewModel collectionViewModel;
    private FragmentHomeBinding fragmentHomeBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        getActivity().findViewById(R.id.progress_barwa).setVisibility(View.VISIBLE);
        getActivity().findViewById(R.id.fragment_container).setVisibility(View.GONE);

            fragmentHomeBinding = DataBindingUtil.inflate(
                    inflater, R.layout.fragment_home, container, false);
            collectionViewModel=new CollectionViewModel(fragmentHomeBinding.getRoot());
            fragmentHomeBinding.setViewmodel(collectionViewModel);
            collectionViewModel.setCollections();
            return  fragmentHomeBinding.getRoot();
    }
    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }
}
