package com.agicent.mvvmdemo.viewmodel;

import android.view.View;
import android.widget.ImageView;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;

import androidx.databinding.library.baseAdapters.BR;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.agicent.mvvmdemo.Activity.MainActivity;
import com.agicent.mvvmdemo.Adapter.HomeAdapter;

import com.agicent.mvvmdemo.DataRepository.CollectionRepository;
import com.agicent.mvvmdemo.Interface.APIComplete;
import com.agicent.mvvmdemo.R;
import com.agicent.mvvmdemo.model.AllCollectionResponse;
import com.agicent.mvvmdemo.model.CollectionResponse;
import com.agicent.mvvmdemo.model.OffersResponseItem;
import com.bumptech.glide.Glide;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;

public class CollectionViewModel extends BaseObservable implements APIComplete {

    private MutableLiveData<AllCollectionResponse> CollectionResponse;
    private CollectionRepository collectionRepository;
    private ArrayList<CollectionResponse> allCollections;
    private ArrayList<OffersResponseItem> offerimages;
    private View id__layout;
    private HomeAdapter homeAdapter;

    private static boolean throughInterface=false;


    @Bindable
    public ArrayList<OffersResponseItem> getOfferimages() {
        return offerimages;
    }

    @Bindable
    public HomeAdapter getHomeAdapter() {
        return homeAdapter;
    }

    @BindingAdapter({"homeAdapter","allCollections"})
    public static void bind(RecyclerView recyclerView,HomeAdapter homeAdapter,ArrayList<CollectionResponse> AllCollections){
        recyclerView.setAdapter(homeAdapter);
        homeAdapter.update(AllCollections);
    }

    public CollectionViewModel(View id__layout) {
        this.id__layout = id__layout;
        homeAdapter=new HomeAdapter();
    }

    @BindingAdapter({"offerimages"})
    public static void loadImageInCarousel(CarouselView view, final ArrayList<OffersResponseItem> offerimages) {
        if(throughInterface) {
            ImageListener imageListener = new ImageListener() {
                @Override
                public void setImageForPosition(int position, ImageView imageView) {
                    if (offerimages != null) {
                        if (offerimages.get(position) != null) {
                            if (offerimages.get(position).getOffer_image() != null && !offerimages.get(position).getOffer_image().isEmpty())
                                Glide.with(imageView.getContext()).load(offerimages.get(position).getOffer_image()).into(imageView);
                        }
                    }
                }
            };
            view.setImageListener(imageListener);
            view.setPageCount(offerimages.size());
        }
    }

    public void setCollections(){
        throughInterface=false;
        if(CollectionResponse!=null){
            return;
        }
        collectionRepository=new CollectionRepository(this);
        CollectionResponse=collectionRepository.getCollectionResponse(id__layout.getContext());
    }


    @Bindable
    public ArrayList<com.agicent.mvvmdemo.model.CollectionResponse> getAllCollections() {
        return allCollections;
    }

    @Override
    public void complete() {
        throughInterface=true;
        allCollections=CollectionResponse.getValue().getCollections();
        offerimages=CollectionResponse.getValue().getOffers();
        notifyPropertyChanged(BR.allCollections);
        notifyPropertyChanged(BR.offerimages);

        MainActivity context=(MainActivity)id__layout.getContext();
        context.findViewById(R.id.progress_barwa).setVisibility(View.GONE);
        context.findViewById(R.id.fragment_container).setVisibility(View.VISIBLE);
    }

}
