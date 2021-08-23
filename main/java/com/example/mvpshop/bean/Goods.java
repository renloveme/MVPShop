package com.example.mvpshop.bean;

import androidx.annotation.NonNull;

import java.util.List;

public class Goods {
    private int goodsId;
    private int spanSize;
    private List<String> banners;
    private String imageUrl;
    private String text;

    public void setGoodsId(int goodsiId) {
        this.goodsId = goodsiId;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setSpanSize(int spanSize) {
        this.spanSize = spanSize;
    }

    public int getSpanSize() {
        return spanSize;
    }

    public void setBanners(List<String> banners) {
        this.banners = banners;
    }

    public List<String> getBanners() {
        return banners;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @NonNull
    @Override
    public String toString() {
        return "Goods{"+
                "goodId="+goodsId+
                ",spanSize="+spanSize+
                ",banners="+banners+
                ",imgUrl="+imageUrl+'\''+
                ",text='"+text+'\''+'}';
    }
}
