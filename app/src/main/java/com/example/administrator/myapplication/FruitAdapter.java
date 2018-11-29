package com.example.administrator.myapplication;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by DELL on 2018/11/19.
 */

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {
    private Context mContext;
    private List<Fruit> mFruitList;

    public FruitAdapter(List<Fruit> fruitList, MainActivity mainActivity) {
        mFruitList = fruitList;

    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //确定要显示的item布局
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_recycler_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取所点击的Item
                int possion = holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(possion);
                //创建Intent 确定要跳转的页面
                Intent intent = new Intent(mContext, Main2Activity.class);
//                //跳转时携带数据,水果名称及对应的图片ID
                intent.putExtra(Main2Activity.FRUIT_NAME, fruit.getName());
                intent.putExtra(Main2Activity.FRUIT_NAME_ID, fruit.getImageId());
                mContext.startActivity(intent);
            }
        });


        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //为Item中的控件设置值
        Fruit fruit = mFruitList.get(position);
        holder.fruitname.setText(fruit.getName());
        holder.fruitImage.setImageResource(fruit.getImageId());
    }

    @Override
    public int getItemCount() {
        return mFruitList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        //跟布局 声明用到的控件
        CardView cardView;
        //图片
        ImageView fruitImage;
        //文字
        TextView fruitname;

        public ViewHolder(View itemView) {
            super(itemView);
            //为上面声明的控件赋值
            cardView = (CardView) itemView.findViewById(R.id.recycler_item_card);
            fruitImage = (ImageView) itemView.findViewById(R.id.fruit_image);
            fruitname = (TextView) itemView.findViewById(R.id.fruit_name);

        }
    }

}