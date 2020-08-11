@file:JvmName("MyProfile")
package com.agicent.mvvmdemo.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import com.agicent.mvvmdemo.Adapter.AddressAdapter
import com.agicent.mvvmdemo.DataRepository.getUserProfile
import com.agicent.mvvmdemo.Interface.APIComplete
import com.agicent.mvvmdemo.component.DaggerUserProfileComponent
import com.agicent.mvvmdemo.component.UserProfileComponent
import com.agicent.mvvmdemo.databinding.ActivityUserProfileBinding
import com.agicent.mvvmdemo.model.ProfileResponse
import com.agicent.mvvmdemo.module.UserProfileModule
import com.agicent.mvvmdemo.viewmodel.UserProfileViewModel
import javax.inject.Inject

class UserProfileActivity : AppCompatActivity()  {

     lateinit var userProfileComponent:UserProfileComponent
     private lateinit var profileResponse : MutableLiveData<ProfileResponse>
     @Inject
     lateinit var userProfileViewModel:UserProfileViewModel
     var addressAdapter : AddressAdapter = AddressAdapter()
     private  var activityUserProfileBinding:ActivityUserProfileBinding? = null


     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityUserProfileBinding=DataBindingUtil.setContentView(this, com.agicent.mvvmdemo.R.layout.activity_user_profile)
         getProfileDetails()
     }


     fun getProfileDetails() {
         Log.e("successfull","getting profile details")
         profileResponse=this.getUserProfile(this,object :APIComplete{
             override fun complete() {
                 userProfileComponent=DaggerUserProfileComponent.builder().userProfileModule(UserProfileModule(activityUserProfileBinding!!.root,profileResponse.value?.first_last_name.toString(),profileResponse.value?.profile_pic.toString(),profileResponse.value?.email_address.toString(),profileResponse.value?.phone_number.toString(),profileResponse.value?.whatsapp_number.toString(),profileResponse.value?.gst_number.toString(),addressAdapter!!,profileResponse.value!!.address)).build()
                 userProfileComponent.inject(this@UserProfileActivity)
                 activityUserProfileBinding?.userProfileViewModel=userProfileViewModel
             }
         })
     }

}
