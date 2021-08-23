package com.example.mvpshop.ui.detail;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.example.mvpshop.R;
import com.example.mvpshop.bean.GoodsDetail;
import com.example.mvpshop.ui.base.BaseActivity;

public class GoodsDetailActivity extends BaseActivity implements View.OnClickListener, GoodsDetailContract.IGoodsDetailView {//

    public static final String GOODS_ID="goods_id";
    private GoodsDetailPresenter goodsDetailPresenter;
    private Toolbar toolbar;



    @Override
    protected int getLayoutId() {
        return R.layout.activity_goods_detail;
    }
private TextView detailContent;
    @Override
    protected void initViews() {
         toolbar =find(R.id.detail_toobal);
        toolbar.setNavigationOnClickListener(this);
        detailContent= find(R.id.detail_content);
        int goodId =getIntent().getIntExtra(GOODS_ID,0);

         goodsDetailPresenter = new GoodsDetailPresenter(this);
         goodsDetailPresenter.getGoodsDetail(goodId);

    }

    @Override
    public void onClick(View v) {
        finish();
    }

    @Override
    public void getGoodsDetailSuccess(GoodsDetail goodsDetail) {
toolbar.setTitle(goodsDetail.getName());
detailContent.setText(goodsDetail.getDescription());

    }

    @Override
    public void getGoodsDetailError(Throwable throwable) {
        Toast.makeText(this,"获取商品失败",Toast.LENGTH_SHORT).show();
    }
}
