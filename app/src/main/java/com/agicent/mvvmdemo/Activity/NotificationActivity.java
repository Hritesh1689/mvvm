package com.agicent.mvvmdemo.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.agicent.mvvmdemo.R;
import com.agicent.mvvmdemo.databinding.ActivityNotificationBinding;
import com.agicent.mvvmdemo.viewmodel.NotificationViewModel;

public class NotificationActivity extends AppCompatActivity {

    private ActivityNotificationBinding activityNotificationBinding;
    private NotificationViewModel notificationViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityNotificationBinding = DataBindingUtil.setContentView(this, R.layout.activity_notification);
        notificationViewModel=new NotificationViewModel(activityNotificationBinding.getRoot());
        activityNotificationBinding.setNotificationModel(notificationViewModel);

        notificationViewModel.getAllNotifications();
    }
}
