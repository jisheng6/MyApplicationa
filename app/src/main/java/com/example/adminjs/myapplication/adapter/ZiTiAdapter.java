package com.example.adminjs.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.adminjs.myapplication.util.OnItemClickListener;
import com.example.adminjs.myapplication.R;
import com.example.adminjs.myapplication.bean.ZiTiBean;

import java.util.List;

public class ZiTiAdapter extends RecyclerView.Adapter<ZiTiAdapter.IViewholder>{
    private Context context;
    private List<ZiTiBean>list;

    public ZiTiAdapter(Context context, List<ZiTiBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public IViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.ziti_layout, null);
        return new IViewholder(view);    }

    @Override
    public void onBindViewHolder(final IViewholder holder, int position) {
       holder.tf.setText(list.get(position).getName());
        //判断是否设置了监听器
        if(mOnItemClickListener != null){
            //为ItemView设置监听器
            holder.tf.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = holder.getLayoutPosition();
                    mOnItemClickListener.onItemClick(holder.tf,position);

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

        TextView tf;
        public IViewholder(View itemView) {
            super(itemView);
            tf = itemView.findViewById(R.id.tf);
        }
    }
}
