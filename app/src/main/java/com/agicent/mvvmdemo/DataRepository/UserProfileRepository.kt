package com.agicent.mvvmdemo.DataRepository

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.agicent.mvvmdemo.Activity.PaymentInfoActivity
import com.agicent.mvvmdemo.Activity.UserProfileActivity
import com.agicent.mvvmdemo.Interface.APIComplete
import com.agicent.mvvmdemo.Interface.ApiClient
import com.agicent.mvvmdemo.Interface.ApiInterface
import com.agicent.mvvmdemo.R
import com.agicent.mvvmdemo.model.PaymentInfoResponse
import com.agicent.mvvmdemo.model.ProfileResponse
import com.agicent.mvvmdemo.utils.AndroidUtils
import com.google.gson.Gson
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

var profileDetailResponse:MutableLiveData<ProfileResponse> =MutableLiveData()
var paymentInfoResponses:MutableLiveData<PaymentInfoResponse> =MutableLiveData()

var gson:Gson? = null
var apiInterface : ApiInterface? = null
var TAG : String = ""

fun UserProfileActivity.getUserProfile(context: Context,apiComplete:APIComplete) :MutableLiveData<ProfileResponse> {
    var testObservable: Observable<ProfileResponse> = ApiClient.getRxjavaInstanceRestApi(context).create(ApiInterface::class.java).profileDetail
    testObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(object:Observer<ProfileResponse>{
        override fun onComplete() {
        }
        override fun onNext(t: ProfileResponse) {
            profileDetailResponse.value=t
           apiComplete.complete()
            AndroidUtils.showToast(context,"API success")
        }
        override fun onSubscribe(d: Disposable) {
        }
        override fun onError(e: Throwable) {
        }
    })
    return profileDetailResponse
}


fun PaymentInfoActivity.getPaymentDetail(context: Context,apiComplete:APIComplete) :MutableLiveData<PaymentInfoResponse> {
    var testObservable: Observable<PaymentInfoResponse> = ApiClient.getRxjavaInstanceRestApi(context).create(ApiInterface::class.java).paymentInfo
    testObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(object:Observer<PaymentInfoResponse>{
        override fun onComplete() {
        }
        override fun onNext(t: PaymentInfoResponse) {
            paymentInfoResponses.value=t
            apiComplete.complete()
            AndroidUtils.showToast(context,"API success")
        }
        override fun onSubscribe(d: Disposable) {
        }
        override fun onError(e: Throwable) {
        }
    })
    return paymentInfoResponses
}



