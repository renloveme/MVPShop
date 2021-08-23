package com.example.mvpshop.ui.detail;

import com.example.mvpshop.bean.BaseBean;
import com.example.mvpshop.bean.GoodsDetail;
import com.example.mvpshop.network.RetrofitClient;
import com.example.mvpshop.network.service.GoodsService;

import io.reactivex.rxjava3.core.Flowable;

public class GoodsDetailModel implements GoodsDetailContract.IGoodsDetailModel {
    @Override
    public Flowable<BaseBean<GoodsDetail>> getGoodsDetail(int goodsId) {
        return RetrofitClient.getInstance().getService(GoodsService.class)
                .getGoodDetail(goodsId);
    }
}
