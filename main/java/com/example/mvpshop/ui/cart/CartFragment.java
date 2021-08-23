package com.example.mvpshop.ui.cart;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvpshop.R;
import com.example.mvpshop.bean.MyPicture;
import com.example.mvpshop.ui.base.BaseFragment;
import com.example.mvpshop.ui.cart.adapter.CartRecyclerViewAdapter;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;

import java.util.ArrayList;
import java.util.List;

public class CartFragment extends BaseFragment {
    private List<MyPicture> myPictureList =new ArrayList<>();
    private CartRecyclerViewAdapter cartRecyclerViewAdapter;
    private Banner mbanner;
    private List<Integer> data;
    @Override
    protected int getLayoutId() {

        return R.layout.fragment_cart;
    }

    @Override
    protected void initViews() {
        initPicture();

        RecyclerView recyclerView =find(R.id.myPicture_recycleView);
       // mbanner=find(R.id.cart_fragment_banner);
       /* mbanner = find(R.id.banner);
        //设置mbanner设配器
        Banner banner = mbanner.setAdapter(new BannerImageAdapter<Integer>(data) {
            @Override
            public void onBindView(BannerImageHolder holder, Integer data, int position, int size) {
                holder.imageView.setImageResource(data);
            }





        });
//是否允许自动轮播
        mbanner.isAutoLoop(true);
//设置指示器
        mbanner.setIndicator(new CircleIndicator(getContext()));
//开始轮播
        mbanner.start();*/


        GridLayoutManager gridLayoutManager=new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(gridLayoutManager);
        CartRecyclerViewAdapter adapter=new CartRecyclerViewAdapter(myPictureList);
        recyclerView.setAdapter(adapter);

    }

    private void initPicture() {
        for(int i=0;i<1;i++){
            MyPicture one=new MyPicture("照片1",R.drawable.t01);
            myPictureList.add(one);
            MyPicture one2=new MyPicture("照片2",R.drawable.t02);
            myPictureList.add(one2);
            MyPicture one3=new MyPicture("照片3",R.drawable.t03);
            myPictureList.add(one3);
            MyPicture one4=new MyPicture("照片4",R.drawable.t04);
            myPictureList.add(one4);
            MyPicture one5=new MyPicture("照片5",R.drawable.t05);
            myPictureList.add(one5);
            MyPicture one6=new MyPicture("照片6",R.drawable.t06);
            myPictureList.add(one6);
            MyPicture one7=new MyPicture("照片7",R.drawable.t07);
            myPictureList.add(one7);
            MyPicture one8=new MyPicture("照片8",R.drawable.t08);
            myPictureList.add(one8);
            MyPicture one9=new MyPicture("照片9",R.drawable.t09);
            myPictureList.add(one9);
            MyPicture one10=new MyPicture("照片10",R.drawable.t10);
            myPictureList.add(one10);
            MyPicture one11=new MyPicture("照片11",R.drawable.t11);
            myPictureList.add(one11);
            MyPicture one12=new MyPicture("照片12",R.drawable.t12);
            myPictureList.add(one12);



        }
    }


}
