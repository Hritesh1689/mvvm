package com.agicent.mvvmdemo.Interface;


import com.agicent.mvvmdemo.model.ItemDetailsbyIdResponse;
import com.agicent.mvvmdemo.model.NotificationResponse;
import com.agicent.mvvmdemo.model.PaymentInfoResponse;
import com.agicent.mvvmdemo.model.ProfileResponse;
import com.google.gson.JsonElement;


import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Single;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("user_login")
    Call<JsonElement> doUserLoginWithPhoneNumber(@Field("phone_number") String phone_number,
                                                 @Field("device_type") String device_type,
                                                 @Field("device_token") String device_token);


    @FormUrlEncoded
    @POST("update_device_token")
    Call<JsonElement> doUpdateDeviceToken(@Field("device_type") String device_type,
                                          @Field("device_token") String device_token);


    @FormUrlEncoded
    @POST("submit_support_request")
    Call<JsonElement> SendSupportMessage(@Field("feedback") String feedback
    );



    @GET("get_my_cart")
    Call<JsonElement> getMyCartItems();

    @FormUrlEncoded
    @POST("user_signup")
    Call<JsonElement> doUserSignup(@Field("first_last_name") String name,
                                   @Field("email_address") String email_address,
                                   @Field("phone_number") String phone_no,
                                   @Field("whatsapp_number") String whatsapp_number,
                                   @Field("profile_pic") String profile_pic,
                                   @Field("gst_number") String gst,
                                   @Field("address1") String address1,
                                   @Field("address2") String address2,
                                   @Field("city") String city,
                                   @Field("state") String state,
                                   @Field("pincode") String pincode,
                                   @Field("land_mark") String land_mark,
                                   @Field("is_default") String is_default,
                                   @Field("device_type") String device_type,
                                   @Field("device_token") String device_token,
                                   @Field("retailer_type") String retailer_type, @Field("latitude") String latitude, @Field("longitude") String longitude, @Field("referred_by_brand") String referred_by_brand);

    @FormUrlEncoded
    @POST("update_profile")
    Call<JsonElement> doUserUpdation(@Field("first_last_name") String name,
                                     @Field("email_address") String email_address,
                                     @Field("phone_number") String phone_no,
                                     @Field("whatsapp_number") String whatsapp_number,
                                     @Field("profile_pic") String profile_pic,
                                     @Field("gst_number") String gst);


    @FormUrlEncoded
    @POST("delete_address")
    Call<JsonElement> deleteTheAddress(@Field("address_id") String id);

    @FormUrlEncoded
    @POST("save_address")
    Call<JsonElement> SavetheAddress(@Field("address_id") String id,
                                     @Field("address1") String address1,
                                     @Field("address2") String address2,
                                     @Field("city") String city,
                                     @Field("state") String state,
                                     @Field("pincode") String pincode,
                                     @Field("land_mark") String land_mark,
                                     @Field("is_default") String is_default);


    @FormUrlEncoded
    @POST("update_notification_setting")
    Call<JsonElement> updateTheNotificationSetting(@Field("notification_status") String notification_status
    );

    @Multipart
    @POST("upload_pic")
    Call<JsonElement> doPicUpdation(@Part MultipartBody.Part file);

    @GET("get_profile_details")
    Call<JsonElement> getProfileDetails();



    @GET("get_contact_info")
    Call<JsonElement> getContactInfo();

    @FormUrlEncoded
    @POST("get_category")
    Call<JsonElement> getCategories(@Field("collection_id") String collection_id);

    @GET("get_collections_offers")
    Call<JsonElement> getCollectionsOffers();

    @FormUrlEncoded
    @POST("get_items_by_category")
    Call<JsonElement> getItemsByCategory(@Field("collection_id") String collection_id,
                                         @Field("category_id") String category_id, @Field("page_no") String page_no);

    @FormUrlEncoded
    @POST("get_item_details")
    Call<JsonElement> getItemInformation(@Field("item_id") String item_id);

    @FormUrlEncoded
    @POST("get_item_details")
    Single<Response<ItemDetailsbyIdResponse>> getItemDetails(@Field("item_id") String item_id);


    @FormUrlEncoded
    @POST("get_filters_by_collection_category")
    Call<JsonElement> getFilterInfoForPopup(@Field("collection_id") String collection_id,
                                            @Field("category_id") String category_id);

    @GET("get_tags")
    Call<JsonElement> getTags();

    @GET("check_retailer_verification")
    Call<JsonElement> VerifyRetailer();

    @FormUrlEncoded
    @POST("get_items_by_tags")
    Call<JsonElement> getItemByTags(@Field("tags") String tags, @Field("page_no") String page_no);

    @GET("get_shipping_info")
    Call<JsonElement> getShippingDetails();

    @GET("get_cart_count")
    Call<JsonElement> get_cart_count();


    @FormUrlEncoded
    @POST("delete_cart_item")
    Call<JsonElement> deleteParticularCartItem(@Field("cart_id") String cart_id);


    @FormUrlEncoded
    @POST("confirm_order")
    Call<JsonElement> doOrderConfirmation(@Field("address_id") String address_id,
                                          @Field("transporter_name") String transporter_name,
                                          @Field("additional_remark") String additional_remark);

    @FormUrlEncoded
    @POST("mark_default_address")
    Call<JsonElement> doSetDefaultAddress(@Field("address_id") String address_id);


    @FormUrlEncoded
    @POST("get_my_order")
    Call<JsonElement> getAllOrders(@Field("order_type") String order_type, @Field("timezone") String timezone);


    @FormUrlEncoded
    @POST("get_items_by_filter")
    Call<JsonElement> getItemsByFilter(@Field("brands") String brands,
                                       @Field("colors") String colors,
                                       @Field("group_sizes") String group_sizes,
                                       @Field("price_range") String price_range, @Field("collection_id") String collection_id, @Field("category_id") String category_id, @Field("tag_name") String tag_name, @Field("page_no") String page_no);


    @FormUrlEncoded
    @POST("get_filters_by_tags")
    Call<JsonElement> getAllFilterByTag(@Field("tags") String tags
    );


    @FormUrlEncoded
    @POST("cancel_order")
    Call<JsonElement> doCancelOrder(@Field("order_number") String order_number);



    @FormUrlEncoded
    @POST("get_my_notifications")
    Call<JsonElement> getAllNotification(@Field("timezone") String timezone);

    @FormUrlEncoded
    @POST("get_my_notifications")
    Single<Response<NotificationResponse>> getNotifications(@Field("timezone") String timezone);


    @GET("get_profile_details")
    Observable<ProfileResponse> getProfileDetail();



    @GET("get_payment_info")
    Observable<PaymentInfoResponse> getPaymentInfo();

    @GET("get_referred_by_brands")
    Call<JsonElement> getAllVendors();


}
