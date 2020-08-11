package com.agicent.mvvmdemo.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.agicent.mvvmdemo.R;
import com.agicent.mvvmdemo.databinding.RecyclerNotificationBinding;
import com.agicent.mvvmdemo.model.NotificationContentResponse;
import com.agicent.mvvmdemo.viewmodel.RecyclerNotificationViewModel;

import java.util.ArrayList;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.MyViewHolder> {

    private ArrayList<NotificationContentResponse>  notificationlist;
    private LayoutInflater layoutInflater;
    @NonNull
    @Override
    public NotificationAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null)
            layoutInflater = LayoutInflater.from(parent.getContext());
        RecyclerNotificationBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.recycler_notification, parent, false);
        return new NotificationAdapter.MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationAdapter.MyViewHolder holder, int position) {
        NotificationContentResponse notificationContentResponse = notificationlist.get(position);
        holder.binding.setRecyclerNotificationViewModel(new RecyclerNotificationViewModel(notificationContentResponse, holder.itemView.getContext()));

    }

    public NotificationAdapter() {
        notificationlist = new ArrayList<>();
    }

    @Override
    public int getItemCount() {
        return notificationlist.size();
    }

    public void update(ArrayList<NotificationContentResponse> notificationlist) {

        if (notificationlist == null || notificationlist.isEmpty())
            this.notificationlist.clear();
        else
            this.notificationlist.addAll(notificationlist);
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private RecyclerNotificationBinding binding;

        public MyViewHolder(@NonNull RecyclerNotificationBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
