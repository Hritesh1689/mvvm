package com.agicent.mvvmdemo.DataRepository;

import android.content.Context;
import android.util.Log;
import androidx.lifecycle.MutableLiveData;

import com.agicent.mvvmdemo.Interface.APIComplete;
import com.agicent.mvvmdemo.Interface.ApiClient;
import com.agicent.mvvmdemo.Interface.ApiInterface;
import com.agicent.mvvmdemo.R;
import com.agicent.mvvmdemo.model.AllCategoryResponse;
import com.agicent.mvvmdemo.model.NotificationResponse;
import com.agicent.mvvmdemo.utils.AndroidUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.android.schedulers.AndroidSchedulers;


import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotificationRepository {

    private ApiInterface apiInterface;
    private Gson gson;
    private String collection_id;
    private String  TAG="CollectionRepository";
    MutableLiveData<NotificationResponse> allNotificationResponse=new MutableLiveData<>();
    private APIComplete apiComplete;

    public NotificationRepository(APIComplete apiComplete) {
        this.apiComplete = apiComplete;
    }

    public  MutableLiveData<NotificationResponse> getNotificationResponse2(final Context context){
        gson=new Gson();
        apiInterface = ApiClient.getRetrofitInstanceRestApi(context).create(ApiInterface.class);
        Call<JsonElement> call = apiInterface.getAllNotification(AndroidUtils.getTimeZoneId());
        call.enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                if (response.isSuccessful()) {
                    if (response.code() == 200) {
                        if (response.body() != null) {
                            JSONObject jsonObject = null;
                            try {
                                jsonObject = new JSONObject(response.body().toString());
                                allNotificationResponse.setValue(gson.fromJson(jsonObject.toString(), NotificationResponse.class));
                                apiComplete.complete();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            } } }
                } else {
                    Log.e(TAG,"something wrong");
                }
            }
            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {
                AndroidUtils.showToast(context, context.getResources().getString(R.string.failure_msg));
            }
        });
        return allNotificationResponse;
    }

    public  MutableLiveData<NotificationResponse> getNotificationResponse(final Context context){
        Single<Response<NotificationResponse>> testObservable= ApiClient.getRxjavaInstanceRestApi(context).create(ApiInterface.class).getNotifications(AndroidUtils.getTimeZoneId());
        testObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Response<NotificationResponse>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }
                    @Override
                    public void onSuccess(Response<NotificationResponse> listResponse) {

                        allNotificationResponse.setValue(listResponse.body());
                        apiComplete.complete();
                    }
                    @Override
                    public void onError(Throwable e) {
                    }
                });

        return allNotificationResponse;
    }
}
