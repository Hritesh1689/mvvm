package com.agicent.mvvmdemo.module

import android.content.Context
import android.content.SharedPreferences
import android.view.View
import androidx.databinding.Bindable
import com.agicent.mvvmdemo.Adapter.AddressAdapter
import com.agicent.mvvmdemo.model.UserResponseAddress
import com.agicent.mvvmdemo.viewmodel.UserProfileViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Module
class UserProfileModule (var id_layout:View,var firstlastname : String,
                         var profileimage : String,
                         var usermail : String,
                         var userphone : String,
                         var userwhatsapp : String,
                         var usergst : String,
                         var addressAdapter : AddressAdapter,
                         var allAddresses : ArrayList<UserResponseAddress>){

    @Provides
    fun provideUserViewModel() : UserProfileViewModel=UserProfileViewModel(id_layout,firstlastname,profileimage,usermail,userphone,userwhatsapp,usergst,addressAdapter,allAddresses)



//    @Singleton
//    @Provides
//    @Named("firstlastname")
//    fun provideFirstlastname()=firstlastname
//
//    @Singleton
//    @Provides
//    @Named("profileimage")
//    fun provideProfileimage()=profileimage
//
//    @Singleton
//    @Provides
//    @Named("usermail")
//    fun provideUsermail()=usermail
//
//    @Singleton
//    @Provides
//    @Named("userphone")
//    fun provideUserphone()=userphone
//
//    @Singleton
//    @Provides
//    @Named("userwhatsapp")
//    fun provideuUserwhatsapp()=userwhatsapp
//
//    @Singleton
//    @Provides
//    @Named("usergst")
//    fun provideUsergst()=usergst
//
//    @Singleton
//    @Provides
//    fun provideAddressAdapter()=addressAdapter
//
//    @Singleton
//    @Provides
//    fun provideAllAddresses()=allAddresses

}