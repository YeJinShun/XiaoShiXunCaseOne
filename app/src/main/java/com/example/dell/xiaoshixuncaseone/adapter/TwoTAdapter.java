package com.example.dell.xiaoshixuncaseone.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dell.xiaoshixuncaseone.R;
import com.example.dell.xiaoshixuncaseone.TwoActivity;
import com.example.dell.xiaoshixuncaseone.bean.TwoBeam;

import java.util.ArrayList;

public class TwoTAdapter extends RecyclerView.Adapter<TwoTAdapter.HolderView> {

    private ArrayList<TwoBeam.ResultBean.DataBean> list;
    private Context context;

    public TwoTAdapter(ArrayList<TwoBeam.ResultBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public HolderView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.tow_titem, null);
        HolderView holderView = new HolderView(view);
        return holderView;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderView holderView, final int i) {
        TwoBeam.ResultBean.DataBean bean = list.get(i);
        holderView.name.setText(bean.getUpdatetime());
        holderView.title.setText(bean.getContent());
        Glide.with(context).load(bean.getUrl()).into(holderView.img);
        holderView.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (click!=null){
                    click.click(i);
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }


    public class HolderView extends RecyclerView.ViewHolder {

        private final ImageView img;
        private final TextView name;
        private final TextView title;

        public HolderView(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.two_timg);
            name = itemView.findViewById(R.id.two_tname);
            title = itemView.findViewById(R.id.two_ttitle);


        }
    }
    public  interface Click{
        void click(int i);
    }
    private Click click;

    public void setClick(Click click) {
        this.click = click;
    }
}
