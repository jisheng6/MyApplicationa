package com.example.adminjs.myapplication.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.adminjs.myapplication.bean.ColorBean;
import com.example.adminjs.myapplication.util.OnItemClickListener;
import com.example.adminjs.myapplication.R;

import java.util.List;

public class ColorAdapter extends RecyclerView.Adapter<ColorAdapter.IViewholder>{
    private Context context;
    private List<ColorBean>list;

    public ColorAdapter(Context context, List<ColorBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public IViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.color_layout, null);
        return new IViewholder(view);    }

    @Override
    public void onBindViewHolder(final IViewholder holder, int position) {
       holder.color.setBackgroundColor(Color.parseColor(list.get(position).getColor()));
        //判断是否设置了监听器
        if(mOnItemClickListener != null){
            //为ItemView设置监听器
            holder.color.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = holder.getLayoutPosition();
                    mOnItemClickListener.onItemClick(holder.color,position);

                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }
    private OnItemClickListener mOnItemClickListener;
    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener){
        this.mOnItemClickListener = mOnItemClickListener;
    }
    class IViewholder extends RecyclerView.ViewHolder{

        TextView color;
        public IViewholder(View itemView) {
            super(itemView);
            color = itemView.findViewById(R.id.color);
        }
    }
}
