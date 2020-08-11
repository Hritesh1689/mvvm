package com.agicent.mvvmdemo.viewmodel

import android.annotation.SuppressLint
import android.content.res.Resources
import android.graphics.Color
import android.view.View
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.agicent.mvvmdemo.Activity.NotificationActivity
import com.agicent.mvvmdemo.Activity.UserProfileActivity
import com.agicent.mvvmdemo.Adapter.AddressAdapter
import com.agicent.mvvmdemo.Interface.ApiClient.mContext
import com.agicent.mvvmdemo.R
import com.agicent.mvvmdemo.model.UserResponseAddress
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView
import javax.inject.Inject
import javax.inject.Singleton

class UserProfileViewModel   constructor(
                                   var id_layout:View,
                             @Bindable var firstlastname : String?,
                             @Bindable var profileimage : String?,
                             @Bindable var usermail : String?,
                             @Bindable var userphone : String?,
                             @Bindable var userwhatsapp : String?,
                             @Bindable var usergst : String?,
                             @Bindable var addressAdapter : AddressAdapter?,
                             @Bindable var allAddresses : ArrayList<UserResponseAddress>?
                             ) : BaseObservable() {


    var ApiComplete=false

    init {
        ApiComplete=true
    }
    //private  var context:UserProfileActivity =id_layout?.context as UserProfileActivity

    companion object{
        @SuppressLint("ResourceType")
        @JvmStatic
        @BindingAdapter("profileimage")
        fun loadImage(view: CircleImageView, profileimage: String?) {
            if(profileimage!=null) {
                if(!profileimage.equals(""))
                   Glide.with(view.context).load(profileimage).into(view)
            }
        }

        @JvmStatic
        @BindingAdapter("addressAdapter", "allAddresses")
        fun bind(recyclerView: RecyclerView, addressAdapter: AddressAdapter?, allAddresses: java.util.ArrayList<UserResponseAddress>?) {
            recyclerView.adapter = addressAdapter
            if(allAddresses!=null)
              addressAdapter?.update(allAddresses)
        }

    }

    @Bindable
    fun isApiComplete():Boolean=ApiComplete


    fun onBackPress(){
        (id_layout.context as UserProfileActivity).onBackPressed()
    }


}

