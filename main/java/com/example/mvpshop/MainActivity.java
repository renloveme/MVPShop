package com.example.mvpshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.mvpshop.bean.MyPicture;
import com.example.mvpshop.ui.base.BaseActivity;
import com.example.mvpshop.ui.cart.CartFragment;
import com.example.mvpshop.ui.home.HomeFragment;
import com.example.mvpshop.ui.ming.MingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity  {


    private List<MyPicture> myPictureList =new ArrayList<>();
    private Fragment[] fragments;

    private int lastFragmentIndex =0;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {

        setTheme(R.style.Theme_AppCompat);
        Log.e("MainActivity","initview");
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.main_buttom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        fragments=new Fragment[]{new HomeFragment(),new CartFragment(),
        new MingFragment()};
        getSupportFragmentManager().beginTransaction()
                .add(R.id.main_frame,fragments[0])
                .commit();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_AppCompat);
        super.onCreate(savedInstanceState);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener=
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    switch (menuItem.getItemId()){
                        case R.id.buttom_home:
                            switchFragment(0);
                            return true;
                        case R.id.buttom_cart:
                            switchFragment(1);
                            return true;
                        case R.id.buttom_ming:
                            switchFragment(2);
                            return true;

                    }
                    return false;
                }
            };




    private void switchFragment(int to){
        Log.e("MainActivity","switchFragment to="+to);
        if(lastFragmentIndex ==to){
            Log.e("MainActivity","switchFragment return");
            return;
        }
        FragmentTransaction fragmentTransaction =getSupportFragmentManager().beginTransaction();
        if(!fragments[to].isAdded()){
            Log.e("MainActivity","switchFragment add");

            fragmentTransaction.add(R.id.main_frame,fragments[to]);

        }else {
            Log.e("MainActivity","switchFragment show");
            fragmentTransaction.show(fragments[to]);
        }
        fragmentTransaction.hide(fragments[lastFragmentIndex])
        .commitAllowingStateLoss();
        lastFragmentIndex =to;
    }


   /* @Override
    public void onNavigationItemReselected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.buttom_home:
                switchFragment(0);
                break;
            case R.id.buttom_cart:
                switchFragment(1);
                break;
            case R.id.buttom_ming:
                switchFragment(2);
                break;
    }*/
}
