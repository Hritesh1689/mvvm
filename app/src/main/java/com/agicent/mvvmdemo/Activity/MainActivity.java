package com.agicent.mvvmdemo.Activity;

//Created by Hritesh Upadhyaya
//having implementation of
//1.MVVM
//2.DataBinding
//3.LiveData
//4.Rxjava
//5.Retrofit
//6.KOTLIN
//7.Dagger
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.os.Bundle;
import com.agicent.mvvmdemo.R;
import com.agicent.mvvmdemo.databinding.BarLayoutHomeFilterBinding;
import com.agicent.mvvmdemo.fragment.CategoryFragment;
import com.agicent.mvvmdemo.fragment.CollectionFragment;
import com.agicent.mvvmdemo.fragment.ItemFragment;
import com.agicent.mvvmdemo.utils.ConstantUtils;
import com.agicent.mvvmdemo.viewmodel.ActivityMainViewModel;
import com.agicent.mvvmdemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainViewModel activityMainViewModel;
    private ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        activityMainViewModel=new ActivityMainViewModel(activityMainBinding);
        activityMainBinding.setViewmodel(activityMainViewModel);

        activityMainViewModel.getAllTags();

        loadFragment(new CollectionFragment(), ConstantUtils.home_fragment_tag);
    }

    public  void loadFragment(Fragment fragment, String tag) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment, tag).commit();
    }

    @Override
    public void onBackPressed() {
        Fragment categoryFragment =  getSupportFragmentManager().findFragmentByTag(ConstantUtils.category_fragment_tag);
        Fragment itemFragment =  getSupportFragmentManager().findFragmentByTag(ConstantUtils.item_fragment_tag);

        if (categoryFragment instanceof CategoryFragment)
            loadFragment(new CollectionFragment(), ConstantUtils.home_fragment_tag);
        else if(itemFragment instanceof ItemFragment)
            loadFragment(new CategoryFragment(), ConstantUtils.category_fragment_tag);
        else
            super.onBackPressed();
    }
}

