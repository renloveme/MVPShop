package com.example.mvpshop.ui.home;

import android.util.Log;

import com.example.mvpshop.bean.BaseBean;
import com.example.mvpshop.bean.Goods;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class HomePresenter implements HomeContract.IHomePresenter {
    private HomeContract.IHomeView homeView;
    private HomeContract.IHomeModel homeModel;

    public HomePresenter(HomeContract.IHomeView homeView ){
        this.homeView=homeView;
         homeModel = new HomeModel();
    }
    @Override
    public void getdata() {
         homeModel.getdata()
                 .subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
         .subscribe(new Consumer<BaseBean<List<Goods>>>() {
             @Override
             public void accept(BaseBean<List<Goods>> listBaseBean) throws Throwable {
                 Log.e("HomePresenter","goodsSuccess");
                 homeView.getGoodsSuccess(listBaseBean.getData());
             }
         }, new Consumer<Throwable>() {
             @Override
             public void accept(Throwable throwable) throws Throwable {
                 Log.e("HomePresenter","goodsError");
                 homeView .getGoodsError(throwable);

             }
         });
    }
}
