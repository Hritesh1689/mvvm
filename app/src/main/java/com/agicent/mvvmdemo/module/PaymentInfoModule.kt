package com.agicent.mvvmdemo.module

import android.view.View
import androidx.databinding.Bindable
import com.agicent.mvvmdemo.databinding.ActivityPaymentInfoBinding
import com.agicent.mvvmdemo.viewmodel.PaymentInfoViewModel
import dagger.Module
import dagger.Provides

@Module
class PaymentInfoModule (var paymentInfoBinding: ActivityPaymentInfoBinding,
                          var companyname : String?,
                          var accountno : String?,
                          var ifsccode : String?,
                          var bankname : String?,
                          var branchname : String?,
                          var paytmno : String?) {

    @Provides
    fun providePymentInfoViewModel() :PaymentInfoViewModel= PaymentInfoViewModel(paymentInfoBinding,companyname,accountno,ifsccode,bankname,branchname,paytmno)

}