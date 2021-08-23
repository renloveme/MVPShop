package com.example.mvpshop.ui.home;

import com.example.mvpshop.bean.BaseBean;
import com.example.mvpshop.bean.Goods;
import com.example.mvpshop.ui.home.HomeContract;

import java.util.List;

import io.reactivex.rxjava3.core.Flowable;

public class LocalModel implements HomeContract.IHomeModel {
    @Override
    public Flowable<BaseBean<List<Goods>>> getdata() {
        return null;
    }
}
