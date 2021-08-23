package com.example.mvpshop.ui.home;

import com.example.mvpshop.bean.BaseBean;
import com.example.mvpshop.bean.Goods;

import java.util.List;

import io.reactivex.rxjava3.core.Flowable;

public interface HomeContract {

    interface IHomePresenter{
        void  getdata();

    }
    interface IHomeModel{
        Flowable<BaseBean<List<Goods>>> getdata();
    }
    interface  IHomeView{

        void getGoodsSuccess(List<Goods> goods);

        void getGoodsError(Throwable throwable);
    }
}
