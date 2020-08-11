package com.agicent.mvvmdemo.viewmodel

import android.view.View
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.lifecycle.ViewModel
import com.agicent.mvvmdemo.Activity.PaymentInfoActivity
import com.agicent.mvvmdemo.databinding.ActivityPaymentInfoBinding

class PaymentInfoViewModel constructor(
        var paymentInfoBinding: ActivityPaymentInfoBinding,
        @Bindable var companyname : String?,
        @Bindable var accountno : String?,
        @Bindable var ifsccode : String?,
        @Bindable var bankname : String?,
        @Bindable var branchname : String?,
        @Bindable var paytmno : String?
) : BaseObservable(){

    init {
        paymentInfoBinding.progressBar?.visibility=View.GONE
        paymentInfoBinding.layoutRoot?.visibility=View.VISIBLE
    }

    fun onBackPress(){
        (paymentInfoBinding.root?.context as PaymentInfoActivity).onBackPressed()
    }



}