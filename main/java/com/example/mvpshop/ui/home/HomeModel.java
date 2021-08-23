package com.example.mvpshop.ui.home;

import com.example.mvpshop.bean.BaseBean;
import com.example.mvpshop.bean.Goods;
import com.example.mvpshop.network.RetrofitClient;
import com.example.mvpshop.network.service.GoodsService;

import java.util.List;

import io.reactivex.rxjava3.core.Flowable;

public class HomeModel implements HomeContract.IHomeModel {
    @Override
    public Flowable<BaseBean<List<Goods>>> getdata() {
       return RetrofitClient.getInstance().getService(GoodsService.class)
                .getGoods();
       //return null;
    }
}
