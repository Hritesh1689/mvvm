package com.agicent.mvvmdemo.viewmodel;

import android.content.Context;
import android.widget.ImageView;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;

import com.agicent.mvvmdemo.Activity.NotificationActivity;
import com.agicent.mvvmdemo.model.NotificationContentResponse;
import com.bumptech.glide.Glide;

import org.ocpsoft.prettytime.PrettyTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class RecyclerNotificationViewModel extends BaseObservable {

    private NotificationContentResponse notificationContentResponse;
    private NotificationActivity context;
    private SimpleDateFormat date1;
    private PrettyTime prettyTime;


    @Bindable
    public String getNotificationTitle() {
        return notificationContentResponse.getTitle();
    }

    @Bindable
    public String getNotificationContent() {
        return notificationContentResponse.getDetail();
    }

    @Bindable
    public String getNotificationDate() {

        date1=new SimpleDateFormat("dd-MM-yyyy hh:mm aa", Locale.US);
        Date date = null;
        try {
            date = date1.parse(notificationContentResponse.getSent_on());
            prettyTime = new PrettyTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return prettyTime.format(date);
    }

    @Bindable
    public String getImageUrl() {
        return notificationContentResponse.getPicture();
    }

    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext()).load(imageUrl).into(view);
    }

    public RecyclerNotificationViewModel(NotificationContentResponse notificationContentResponse, Context context) {
        this.notificationContentResponse = notificationContentResponse;
        this.context=(NotificationActivity) context;
    }
}
