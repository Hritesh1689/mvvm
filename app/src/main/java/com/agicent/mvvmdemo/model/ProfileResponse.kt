package com.agicent.mvvmdemo.model

import java.util.ArrayList

class ProfileResponse (var first_last_name:String,
                       var email_address:String,
                       var phone_number:String,
                       var whatsapp_number:String,
                       var profile_pic:String,
                       var gst_number:String,
                       var auth_token:String,
                       var address:ArrayList<UserResponseAddress>){



}