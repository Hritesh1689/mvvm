package com.agicent.mvvmdemo.DataRepository;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.agicent.mvvmdemo.Interface.APIComplete;
import com.agicent.mvvmdemo.Interface.ApiClient;
import com.agicent.mvvmdemo.Interface.ApiInterface;
import com.agicent.mvvmdemo.R;
import com.agicent.mvvmdemo.model.ItemDetailsbyIdResponse;
import com.agicent.mvvmdemo.model.NotificationResponse;
import com.agicent.mvvmdemo.utils.AndroidUtils;
import com.google.gson.Gson;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class ItemDetailRepository {

    private ApiInterface apiInterface;
    private Gson gson;
    private String collection_id;
    private String  TAG="CollectionRepository";
    MutableLiveData<ItemDetailsbyIdResponse> itemDetailResponse=new MutableLiveData<>();
    private APIComplete apiComplete;

    public ItemDetailRepository(APIComplete apiComplete) {
        this.apiComplete = apiComplete;
    }



    public  MutableLiveData<ItemDetailsbyIdResponse> getItemDetails(final Context context,String item_id){
        Single<Response<ItemDetailsbyIdResponse>> testObservable= ApiClient.getRxjavaInstanceRestApi(context).create(ApiInterface.class).getItemDetails(item_id);
        testObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Response<ItemDetailsbyIdResponse>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }
                    @Override
                    public void onSuccess(Response<ItemDetailsbyIdResponse> listResponse) {

                        itemDetailResponse.setValue(listResponse.body());
                        apiComplete.complete();
                    }
                    @Override
                    public void onError(Throwable e) {
                    }
                });

        return itemDetailResponse;
    }
}
