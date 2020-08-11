package com.agicent.mvvmdemo.viewmodel;

import android.view.View;
import android.widget.ImageView;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.library.baseAdapters.BR;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.agicent.mvvmdemo.Activity.ItemDetailActivity;
import com.agicent.mvvmdemo.Adapter.ColorsAdapter;
import com.agicent.mvvmdemo.Adapter.SelectedSizeAdapter;
import com.agicent.mvvmdemo.Adapter.SizegroupAdapter;
import com.agicent.mvvmdemo.DataRepository.ItemDetailRepository;
import com.agicent.mvvmdemo.Interface.APIComplete;
import com.agicent.mvvmdemo.model.CartItemSizeGroupResponse;
import com.agicent.mvvmdemo.model.ColorsbyId;
import com.agicent.mvvmdemo.model.ItemDetailsbyIdResponse;
import com.agicent.mvvmdemo.model.ItemPicResponseById;
import com.agicent.mvvmdemo.model.SizegroupResponse;
import com.agicent.mvvmdemo.utils.AndroidUtils;
import com.bumptech.glide.Glide;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;

public class ItemDetailViewModel extends BaseObservable implements APIComplete {

    private View root;
    private ItemDetailActivity context;
    private SelectedSizeAdapter selectedSizeAdapter;
    private static boolean throughInterface=false,isPicLoaded=false;
    private ColorsAdapter colorsAdapter;
    private SizegroupAdapter sizegroupAdapter;
    private ArrayList<ColorsbyId> colorslist;
    private ArrayList<SizegroupResponse> sizegrouplist;
    private ArrayList<CartItemSizeGroupResponse>  selectedItemList;
    private ArrayList<ItemPicResponseById> itempiclist;
    public String shortDescription="";
    public String gstPercentage="";
    public String priceBeforeDiscount="";
    public String priceAfterDiscount="";
    public String designCode="";
    public String itemName="";
    public String categoryName="";
    public String brandName="";
    public String fabricName="";
    public String fitName="";


    @Bindable
    public String getDiscountPercent() {
        return "("+discountPercent+"% OFF)";
    }

    public String discountPercent="";

    @Bindable
    public String getShortDescription() {
        return shortDescription;
    }

    @Bindable
    public String getGstPercentage() {
        return "+GST "+gstPercentage+"%";
    }

    @Bindable
    public String getPriceBeforeDiscount() {
        return priceBeforeDiscount+"/-";
    }

    @Bindable
    public String getPriceAfterDiscount() {
        return priceAfterDiscount+"/-";
    }
    @Bindable
    public String getDesignCode() {
        return designCode;
    }
    @Bindable
    public String getItemName() {
        return "("+itemName+")";
    }
    @Bindable
    public String getCategoryName() {
        return categoryName;
    }
    @Bindable
    public String getBrandName() {
        return brandName;
    }
    @Bindable
    public String getFabricName() {
        return fabricName;
    }
    @Bindable
    public String getFitName() {
        return fitName;
    }

    private ItemDetailRepository itemDetailRepository;
    private MutableLiveData<ItemDetailsbyIdResponse> itemDetailByIdResponse;
    private ItemDetailsbyIdResponse itemDetailsbyIdResponse1;
    private String item_id;



    @Bindable
    public ArrayList<ItemPicResponseById> getItempiclist() {
        return itempiclist;
    }

    @Bindable
    public ArrayList<ColorsbyId> getColorslist() {
        return colorslist;
    }


    @Bindable
    public ArrayList<SizegroupResponse> getSizegrouplist() {
        return sizegrouplist;
    }

    @Bindable
    public ArrayList<CartItemSizeGroupResponse> getSelectedItemList() {
        return selectedItemList;
    }

    @Bindable
    public SelectedSizeAdapter getSelectedSizeAdapter() {
        return selectedSizeAdapter;
    }
    @Bindable
    public ColorsAdapter getColorsAdapter() {
        return colorsAdapter;
    }
    @Bindable
    public SizegroupAdapter getSizegroupAdapter() {
        return sizegroupAdapter;
    }

    @BindingAdapter({"itempiclist"})
    public static void loadImageInCarousel(CarouselView view, final ArrayList<ItemPicResponseById> itempiclist) {
        if(throughInterface) {

            ImageListener imageListener = new ImageListener() {
                @Override
                public void setImageForPosition(int position, ImageView imageView) {
                    if (itempiclist != null) {
                        if (itempiclist.get(position) != null) {
                            if (itempiclist.get(position).getImg_2x() != null && !itempiclist.get(position).getImg_2x().isEmpty()){
                                Glide.with(imageView.getContext()).load(itempiclist.get(position).getImg_2x()).into(imageView);
                                throughInterface=false;

                        }}
                    }
                }
            };
            view.setImageListener(imageListener);
            view.setPageCount(itempiclist.size());
        }
    }

    @BindingAdapter({"colorsAdapter","colorslist"})
    public static void bind(RecyclerView recyclerView, ColorsAdapter colorsAdapter, ArrayList<ColorsbyId> colorslist){
        recyclerView.setAdapter(colorsAdapter);
        colorsAdapter.update(colorslist);
    }

    @BindingAdapter({"sizegroupAdapter","sizegrouplist"})
    public static void bind(RecyclerView recyclerView, SizegroupAdapter sizegroupAdapter, ArrayList<SizegroupResponse> sizegrouplist){
        recyclerView.setAdapter(sizegroupAdapter);
        sizegroupAdapter.update(sizegrouplist);
    }

    @BindingAdapter({"selectedSizeAdapter","selectedItemList"})
    public static void bind(RecyclerView recyclerView, SelectedSizeAdapter selectedSizeAdapter, ArrayList<CartItemSizeGroupResponse> selectedItemList){
        recyclerView.setAdapter(selectedSizeAdapter);
        selectedSizeAdapter.update(selectedItemList);
    }

    public ItemDetailViewModel(View root) {
        this.root=root;
        context=(ItemDetailActivity) root.getContext();

        this.item_id= AndroidUtils.SelectedItem;

        selectedSizeAdapter=new SelectedSizeAdapter();
        colorsAdapter=new ColorsAdapter();
        sizegroupAdapter=new SizegroupAdapter();
    }

    public void getItemDetails() {
        if(itemDetailByIdResponse!=null){
            return;
        }
        itemDetailRepository=new ItemDetailRepository(this);
        itemDetailByIdResponse=itemDetailRepository.getItemDetails(context,item_id);

    }

    @Override
    public void complete() {
        throughInterface=true;
        itemDetailsbyIdResponse1=itemDetailByIdResponse.getValue();
        shortDescription=itemDetailsbyIdResponse1.getShort_description();
        gstPercentage=itemDetailsbyIdResponse1.getGst_percentage();
        priceBeforeDiscount=itemDetailsbyIdResponse1.getMin_item_price();
        priceAfterDiscount=itemDetailsbyIdResponse1.getMin_item_price_after_discount();
        designCode=itemDetailsbyIdResponse1.getDesign_number();
        itemName=itemDetailsbyIdResponse1.getItem_name();
        categoryName=itemDetailsbyIdResponse1.getCategory_name();
        brandName=itemDetailsbyIdResponse1.getBrand_name();
        fabricName=itemDetailsbyIdResponse1.getFabric();
        discountPercent=itemDetailsbyIdResponse1.getActive_discount_in_percent();
        fitName=itemDetailsbyIdResponse1.getFit();
        itempiclist=itemDetailByIdResponse.getValue().getItem_images();
        colorslist=itemDetailByIdResponse.getValue().getItem_colors();
        sizegrouplist=itemDetailByIdResponse.getValue().getItem_size_groups();
        selectedItemList=itemDetailByIdResponse.getValue().getCart_items_size_group_color_quatity();

        notifyPropertyChanged(BR.itempiclist);
        notifyPropertyChanged(BR.shortDescription);
        notifyPropertyChanged(BR.gstPercentage);
        notifyPropertyChanged(BR.priceBeforeDiscount);
        notifyPropertyChanged(BR.designCode);
        notifyPropertyChanged(BR.itemName);
        notifyPropertyChanged(BR.categoryName);
        notifyPropertyChanged(BR.brandName);
        notifyPropertyChanged(BR.fabricName);
        notifyPropertyChanged(BR.fitName);
        notifyPropertyChanged(BR.priceAfterDiscount);
        notifyPropertyChanged(BR.colorslist);
        notifyPropertyChanged(BR.sizegrouplist);
        notifyPropertyChanged(BR.selectedItemList);
        notifyPropertyChanged(BR.discountPercent);
    }

    public void onbackpress(){
        context.onBackPressed();
    }
}
