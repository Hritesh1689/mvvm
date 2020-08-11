package com.agicent.mvvmdemo.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import com.agicent.mvvmdemo.DataRepository.getPaymentDetail
import com.agicent.mvvmdemo.Interface.APIComplete
import com.agicent.mvvmdemo.R
import com.agicent.mvvmdemo.component.DaggerPaymentInfoComponent
import com.agicent.mvvmdemo.component.PaymentInfoComponent
import com.agicent.mvvmdemo.databinding.ActivityPaymentInfoBinding
import com.agicent.mvvmdemo.model.PaymentInfoResponse
import com.agicent.mvvmdemo.module.PaymentInfoModule
import com.agicent.mvvmdemo.viewmodel.PaymentInfoViewModel
import javax.inject.Inject

class PaymentInfoActivity : AppCompatActivity() {

    lateinit var paymentInfoBinding:ActivityPaymentInfoBinding
    @Inject
   lateinit var paymentInfoViewModel:PaymentInfoViewModel
    lateinit var paymentInfoComponent:PaymentInfoComponent
    lateinit var paymentResponse:MutableLiveData<PaymentInfoResponse>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        paymentInfoBinding=DataBindingUtil.setContentView(this,R.layout.activity_payment_info)
        getPaymentDetails()
    }

    private fun getPaymentDetails() {
        paymentResponse=this.getPaymentDetail(this,object:APIComplete{
            override fun complete() {
                paymentInfoComponent=DaggerPaymentInfoComponent.builder().paymentInfoModule(PaymentInfoModule(paymentInfoBinding,paymentResponse.value?.company_name,paymentResponse.value?.account_number,paymentResponse.value?.ifsc_code,paymentResponse.value?.bank_name,paymentResponse.value?.branch,paymentResponse.value?.paytm_number)).build()
                paymentInfoComponent.inject(this@PaymentInfoActivity)
                paymentInfoBinding?.paymentInfoViewModel=paymentInfoViewModel
            }
        })
    }
}
