package com.example.mvpshop.ui.home;

import android.content.Intent;
import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.mvpshop.R;
import com.example.mvpshop.bean.Goods;
import com.example.mvpshop.bean.GoodsDetail;
import com.example.mvpshop.ui.base.BaseFragment;
import com.example.mvpshop.ui.detail.GoodsDetailActivity;
import com.example.mvpshop.ui.home.adapter.HomeRecyclerViewAdapter;
import com.example.mvpshop.ui.home.adapter.HomeSpanSizeLookup;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener,HomeContract.IHomeView,HomeRecyclerViewAdapter.OnItemClickListener{

    private static final String TAG = "HomeFragment";
    private HomeRecyclerViewAdapter homeRecyclerViewAdapter;
    private  HomePresenter homePresenter;
    private HomeSpanSizeLookup homeSpanSizeLookup;
    private SwipeRefreshLayout swipeRefreshLayout;
    @Override
    protected int getLayoutId() {

        return R.layout.fragment_home;
    }

    @Override
    protected void initViews() {
         swipeRefreshLayout =find(R.id.home_swiperefresh);
        //swipeRefreshLayout.setOnRefreshListener((SwipeRefreshLayout.OnRefreshListener) this);
        swipeRefreshLayout.setOnRefreshListener(this);


        RecyclerView recyclerView =find(R.id.home_recyclerview);
        GridLayoutManager gridLayoutManager =new GridLayoutManager(getActivity(),4);
        List<Goods>goods =new ArrayList<>();
         homeSpanSizeLookup = new HomeSpanSizeLookup(goods);
        gridLayoutManager.setSpanSizeLookup(homeSpanSizeLookup);
        recyclerView.setLayoutManager(gridLayoutManager);

         homeRecyclerViewAdapter = new HomeRecyclerViewAdapter(recyclerView,getActivity(), goods);
         homeRecyclerViewAdapter.setOnItemClickListener(this);  //
        recyclerView.setAdapter(homeRecyclerViewAdapter);

        homePresenter = new HomePresenter(this);


        homePresenter.getdata();


    }


    @Override
    public void onRefresh() {
        swipeRefreshLayout.setRefreshing(false);
        homePresenter.getdata();
    }

    @Override
    public void getGoodsSuccess(List<Goods> goods) {
        homeSpanSizeLookup.setGoods(goods);
        homeRecyclerViewAdapter.setGoods(goods);

    }

    @Override
    public void getGoodsError(Throwable throwable) {

    }

    @Override
    public void OnItemClick(Goods goods) {  //
        Log.i(TAG,"onItemclick"+goods);
        Intent intent=new Intent(getActivity(), GoodsDetailActivity.class);
        intent.putExtra(GoodsDetailActivity.GOODS_ID,goods.getGoodsId());
        startActivity(intent);
    }
}
