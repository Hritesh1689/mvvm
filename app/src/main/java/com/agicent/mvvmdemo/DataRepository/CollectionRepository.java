package com.agicent.mvvmdemo.DataRepository;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.agicent.mvvmdemo.Interface.APIComplete;
import com.agicent.mvvmdemo.Interface.ApiClient;
import com.agicent.mvvmdemo.Interface.ApiInterface;
import com.agicent.mvvmdemo.R;
import com.agicent.mvvmdemo.model.AllCollectionResponse;
import com.agicent.mvvmdemo.utils.AndroidUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CollectionRepository {
    private ApiInterface apiInterface;
    private Gson gson;
    private String  TAG="CollectionRepository";
    MutableLiveData<AllCollectionResponse> allCollectionResponse=new MutableLiveData<>();
    private  APIComplete apiComplete;

    public CollectionRepository(APIComplete apiComplete) {
        this.apiComplete = apiComplete;
    }

    public MutableLiveData<AllCollectionResponse> getCollectionResponse(final Context context){
        gson=new Gson();
        apiInterface = ApiClient.getRetrofitInstanceRestApi(context).create(ApiInterface.class);
        Call<JsonElement> call = apiInterface.getCollectionsOffers();
        call.enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                if (response.isSuccessful()) {
                    if (response.code() == 200) {
                        if (response.body() != null) {
                            JSONObject jsonObject = null;
                            try {
                                jsonObject = new JSONObject(response.body().toString());
                                allCollectionResponse.setValue(gson.fromJson(jsonObject.toString(), AllCollectionResponse.class));
                                apiComplete.complete();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            } } }
                } else {
                    Log.e(TAG,"something wrong");
                } }
            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {
                AndroidUtils.showToast(context, context.getResources().getString(R.string.failure_msg));
            }
        });
        return allCollectionResponse;
    }

}
