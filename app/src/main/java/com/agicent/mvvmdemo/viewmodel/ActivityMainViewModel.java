package com.agicent.mvvmdemo.viewmodel;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.MutableLiveData;

import com.agicent.mvvmdemo.Activity.MainActivity;
import com.agicent.mvvmdemo.Activity.NotificationActivity;
import com.agicent.mvvmdemo.Activity.PaymentInfoActivity;
import com.agicent.mvvmdemo.Activity.UserProfileActivity;
import com.agicent.mvvmdemo.Adapter.AutoCompleteTextViewArrayAdapter;
import com.agicent.mvvmdemo.DataRepository.MainRepository;
import com.agicent.mvvmdemo.Interface.APIComplete;
import com.agicent.mvvmdemo.R;
import com.agicent.mvvmdemo.databinding.ActivityMainBinding;
import com.agicent.mvvmdemo.fragment.ItemFragment;
import com.agicent.mvvmdemo.model.TagResponse;
import com.agicent.mvvmdemo.utils.AndroidUtils;
import com.agicent.mvvmdemo.utils.AppUtils;
import com.agicent.mvvmdemo.utils.ConstantUtils;

import java.util.ArrayList;


public class ActivityMainViewModel extends BaseObservable implements APIComplete {
    private AutoCompleteTextViewArrayAdapter adapter;
    private boolean drawableVisible=false;
    private MutableLiveData<TagResponse> tagResponse;
    private MainRepository mainRepository;
    private ArrayList<String> taglist;
    private ActivityMainBinding activityMainBinding;

    @Bindable
    public boolean isCrossIconVisible() {
        return CrossIconVisible;
    }

    private  boolean CrossIconVisible=false;
    private MainActivity context;

    public ActivityMainViewModel(ActivityMainBinding activityMainBinding) {
        this.activityMainBinding=activityMainBinding;
        this.context=(MainActivity) activityMainBinding.getRoot().getContext();
    }

    @Bindable
    public boolean isDrawableVisible() {
        return drawableVisible;
    }

    public void menuClicked() {
        MainActivity context=(MainActivity) activityMainBinding.getRoot().getContext();
        DrawerLayout drawerLayout=activityMainBinding.drawerLayouta;
         if(drawableVisible) {
             drawerLayout.openDrawer(Gravity.LEFT);
             drawableVisible=false;
         } else {
             drawableVisible = true;
             drawerLayout.closeDrawers();
         }
         notifyPropertyChanged(BR.drawableVisible);
    }


    public void clickListener(View view){
        final AutoCompleteTextView edit_text=context.findViewById(view.getId());
        edit_text.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {

                    String entered_text = edit_text.getText().toString();
                    if (entered_text.trim().isEmpty()) {

                        AndroidUtils.showToast(activityMainBinding.getRoot().getContext(), "Please enter text to search.");
                    } else {
                        //check connectivity $ call itemfragment source-> searchByTag
                        if (AppUtils.isNetworkAvailable(activityMainBinding.getRoot().getContext())) {
                            Bundle bundle = new Bundle();
                            bundle.putString(ConstantUtils.SOURCE_STRING, ConstantUtils.SEARCH_BY_TAGS);
                            AndroidUtils.BY_TAG=entered_text;
                            ItemFragment itemFragment = new ItemFragment();
                            itemFragment.setArguments(bundle);
                            edit_text.dismissDropDown();
                            loadFragment(itemFragment, "itemFragment",context);
                        } else {
                            AndroidUtils.showToast(activityMainBinding.getRoot().getContext(), activityMainBinding.getRoot().getContext().getResources().getString(R.string.no_internet_connection));
                        } } }
                return false;
            }
        });



        //to show suggestions
        edit_text.setThreshold(1);
        adapter = new AutoCompleteTextViewArrayAdapter(context, R.layout.simple_drop_down_autocomplete_textview, taglist);
        edit_text.setAdapter(adapter);
        edit_text.setDropDownHeight(ViewGroup.LayoutParams.WRAP_CONTENT);

        edit_text.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selected_option = (String) adapterView.getItemAtPosition(i);
                edit_text.setText(selected_option);
                AndroidUtils.hideKeyBoard(context);
                edit_text.setSelection(edit_text.getText().length());

                //check connectivity $ call itemfragment source-> searchByTag
                if (AppUtils.isNetworkAvailable(context)) {
                    AndroidUtils.BY_TAG=selected_option;
                    Bundle bundle = new Bundle();
                    bundle.putString(ConstantUtils.SOURCE_STRING, ConstantUtils.SEARCH_BY_TAGS);
                    ItemFragment itemFragment = new ItemFragment();
//                    setClickable(false);
//                    app_icon.setVisibility(View.VISIBLE);
                    itemFragment.setArguments(bundle);
                    loadFragment(itemFragment, "itemFragment",context);
                } else {
                    AndroidUtils.showToast(context, context.getResources().getString(R.string.no_internet_connection));
                }
            }
        });

        edit_text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                CrossIconVisible=true;
                edit_text.setSelection(edit_text.getText().length());
                adapter.notifyDataSetChanged();
                if (edit_text.getText().toString().trim().length() > 0) {
                    CrossIconVisible=true;
                } else
                    CrossIconVisible=false;


            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        //notifyPropertyChanged(BR.CrossIconVisible);


    }

    public  void loadFragment(Fragment fragment, String tag, MainActivity context) {
        FragmentTransaction fragmentTransaction = context.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment, tag).commit();
    }

   public void onCrossClick(){

   }

    public void getAllTags() {
        if(tagResponse!=null){
            return;
        }
        mainRepository=new MainRepository(this);
        tagResponse=mainRepository.getTagResponse(activityMainBinding.getRoot().getContext());
        //notifyPropertyChanged(BR.tagResponse);
    }


    public  void  openNotifications(){

        context.startActivity(new Intent(context, NotificationActivity.class));

    }

    public void OnProfileClick(){

        activityMainBinding.getRoot().getContext().startActivity(new Intent(context,UserProfileActivity.class));
        activityMainBinding.drawerLayouta.closeDrawers();

    }

    public void OnPaymentClick(){
        activityMainBinding.getRoot().getContext().startActivity(new Intent(context, PaymentInfoActivity.class));
        activityMainBinding.drawerLayouta.closeDrawers();
    }

    @Override
    public void complete() {
        taglist=tagResponse.getValue().getTags();
         }
}
