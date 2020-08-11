package com.agicent.mvvmdemo.component

import com.agicent.mvvmdemo.Activity.PaymentInfoActivity
import com.agicent.mvvmdemo.module.PaymentInfoModule
import dagger.Component


@Component(modules = [PaymentInfoModule::class])
interface PaymentInfoComponent {
    fun  inject(paymentInfoActivity: PaymentInfoActivity)
}