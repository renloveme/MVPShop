package com.example.mvpshop.ui.cart.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvpshop.R;
import com.example.mvpshop.bean.MyPicture;
import com.youth.banner.Banner;

import java.util.List;

public class CartRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<MyPicture> myPictureList;
    private  RecyclerView recyclerView;
    private Context context;
    private LayoutInflater layoutInflater;
    private Banner mbanner;

    private List<Integer> data;

    public CartRecyclerViewAdapter(RecyclerView recyclerView,Context context){

        this.context=context;
        this.recyclerView=recyclerView;
        layoutInflater = LayoutInflater.from(context);
    }

     static class PiViewHolder extends RecyclerView.ViewHolder{
         ImageView MyPictureImage;
         TextView MyPicturename;
         public PiViewHolder(@NonNull View view) {
             super(view);
             MyPictureImage=view.findViewById(R.id.myPicture_image);
             MyPicturename=view.findViewById(R.id.myPicture_name);
         }
     }

    public CartRecyclerViewAdapter(List<MyPicture> mmyPictureList){
         this.myPictureList=mmyPictureList;
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View view= LayoutInflater.from(parent.getContext())
                 .inflate(R.layout.mypicture_test,parent,false);
         PiViewHolder holder=new PiViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

         MyPicture myPicture=myPictureList.get(position);
        int itemViewType = getItemViewType(position);

        PiViewHolder piViewHolder= (PiViewHolder) holder;
        piViewHolder.MyPictureImage.setImageResource(myPicture.getImageId());
        piViewHolder.MyPicturename.setText(myPicture.getName());
    }

    @Override
    public int getItemCount() {
        return myPictureList.size();
    }
    public void setCratBanner(){

        data.add(R.drawable.t01);
        data.add(R.drawable.t03);
        data.add(R.drawable.t04);



    }
}
