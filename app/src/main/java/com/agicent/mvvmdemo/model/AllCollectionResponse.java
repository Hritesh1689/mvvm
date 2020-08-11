package com.agicent.mvvmdemo.model;

import java.util.ArrayList;

public class AllCollectionResponse {

    ArrayList<CollectionResponse> collections;
    ArrayList<OffersResponseItem> offers;

    public AllCollectionResponse(ArrayList<CollectionResponse> collections, ArrayList<OffersResponseItem> offers) {
        this.collections = collections;
        this.offers = offers;
    }

    public ArrayList<CollectionResponse> getCollections() {
        return collections;
    }

    public void setCollections(ArrayList<CollectionResponse> collections) {
        this.collections = collections;
    }

    public ArrayList<OffersResponseItem> getOffers() {
        return offers;
    }

    public void setOffers(ArrayList<OffersResponseItem> offers) {
        this.offers = offers;
    }
}
