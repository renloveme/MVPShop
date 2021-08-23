package com.example.mvpshop.network.service;

import com.example.mvpshop.bean.BaseBean;
import com.example.mvpshop.bean.Goods;
import com.example.mvpshop.bean.GoodsDetail;

import java.util.List;

import io.reactivex.rxjava3.core.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GoodsService {


    @GET("edu-lance/edu-lance.github.io/blob/master/goods_detail")
    Flowable<BaseBean<GoodsDetail>> getGoodDetail(@Query("goodsId")int goodsId);

    @GET("edu-lance/edu-lance.github.io/blob/master/goods_list")
    Flowable<BaseBean<List<Goods>>> getGoods();
}
