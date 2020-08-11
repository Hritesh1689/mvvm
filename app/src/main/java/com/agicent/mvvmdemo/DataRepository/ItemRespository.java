package com.agicent.mvvmdemo.DataRepository;

import android.content.Context;
import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import com.agicent.mvvmdemo.Interface.APIComplete;
import com.agicent.mvvmdemo.Interface.ApiClient;
import com.agicent.mvvmdemo.Interface.ApiInterface;
import com.agicent.mvvmdemo.R;
import com.agicent.mvvmdemo.model.AllItemResponse;
import com.agicent.mvvmdemo.utils.AndroidUtils;
import com.agicent.mvvmdemo.utils.ConstantUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemRespository {

    private ApiInterface apiInterface;
    private Gson gson;
    private String collection_id,category_id;
    private String  TAG="CollectionRepository";
    MutableLiveData<AllItemResponse> allItemResponse=new MutableLiveData<>();
    private APIComplete apiComplete;

    public ItemRespository(APIComplete apiComplete,String collection_id,String category_id) {
        this.apiComplete = apiComplete;
        this.collection_id=collection_id;
        this.category_id=category_id;
    }

    public  MutableLiveData<AllItemResponse> getItemResponse(final Context context,String source){
        gson=new Gson();
        apiInterface = ApiClient.getRetrofitInstanceRestApi(context).create(ApiInterface.class);
        Call<JsonElement> call;
        if(source.equalsIgnoreCase(ConstantUtils.SEARCH_BY_CATEGORY))
               call = apiInterface.getItemsByCategory(collection_id,category_id,"1");
        else
             call = apiInterface.getItemByTags(AndroidUtils.BY_TAG,"1");
        call.enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                if (response.isSuccessful()) {
                    if (response.code() == 200) {
                        if (response.body() != null) {
                            JSONObject jsonObject = null;
                            try {
                                jsonObject = new JSONObject(response.body().toString());
                                allItemResponse.setValue(gson.fromJson(jsonObject.toString(), AllItemResponse.class));
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
        return allItemResponse;
    }
}
