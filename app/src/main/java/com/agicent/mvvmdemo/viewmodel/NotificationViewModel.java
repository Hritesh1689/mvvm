package com.agicent.mvvmdemo.viewmodel;

import android.view.View;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.library.baseAdapters.BR;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.agicent.mvvmdemo.Activity.NotificationActivity;
import com.agicent.mvvmdemo.Adapter.NotificationAdapter;
import com.agicent.mvvmdemo.DataRepository.NotificationRepository;
import com.agicent.mvvmdemo.Interface.APIComplete;
import com.agicent.mvvmdemo.model.NotificationContentResponse;
import com.agicent.mvvmdemo.model.NotificationResponse;
import java.util.ArrayList;

public class NotificationViewModel extends BaseObservable implements APIComplete {

    private View id_layout;
    private MutableLiveData<NotificationResponse> notificationResponse;
    private NotificationRepository notificationRepository;
    private ArrayList<NotificationContentResponse> notificationlist;
    private static boolean throughInterface=false;
    private NotificationAdapter notificationAdapter;
    private NotificationActivity context;


    @Bindable
    public ArrayList<NotificationContentResponse> getNotificationlist() {
        return notificationlist;
    }

    @Bindable
    public NotificationAdapter getNotificationAdapter() {
        return notificationAdapter;
    }


    @BindingAdapter({"notificationAdapter","notificationlist"})
    public static void bind(RecyclerView recyclerView, NotificationAdapter notificationAdapter, ArrayList<NotificationContentResponse> notificationlist){
        recyclerView.setAdapter(notificationAdapter);
        notificationAdapter.update(notificationlist);
    }

    public NotificationViewModel(View id_layout) {
        this.id_layout=id_layout;
        notificationAdapter=new NotificationAdapter();
        context=(NotificationActivity) id_layout.getContext();

    }

    public void getAllNotifications() {
        if(notificationResponse!=null){
            return;
        }
        notificationRepository=new NotificationRepository(this);
        notificationResponse=notificationRepository.getNotificationResponse(id_layout.getContext());
    }

    @Override
    public void complete() {
        throughInterface=true;
        notificationlist=notificationResponse.getValue().getNotifications();
        notifyPropertyChanged(BR.notificationlist);
    }

    public void onbackpress(){
        context.onBackPressed();
    }
}
