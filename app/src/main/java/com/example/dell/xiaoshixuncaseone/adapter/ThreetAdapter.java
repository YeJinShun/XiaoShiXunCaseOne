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
import com.bumptech.glide.request.RequestOptions;
import com.example.dell.xiaoshixuncaseone.R;
import com.example.dell.xiaoshixuncaseone.bean.Bean;
import com.example.dell.xiaoshixuncaseone.bean.MaBean;

import java.util.ArrayList;

public class ThreetAdapter extends RecyclerView.Adapter<ThreetAdapter.ViewHolder> {

    private ArrayList<Bean> list;
    private Context context;

    public ThreetAdapter(ArrayList<Bean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ThreetAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.one_item, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ThreetAdapter.ViewHolder viewHolder, final int i) {
        Bean bean = list.get(i);
        viewHolder.name.setText(bean.getName());
        viewHolder.title.setText(bean.getTitle());
        Glide.with(context).load(bean.getImg()).apply(RequestOptions.circleCropTransform())
                .into(viewHolder.img);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
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

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView title;
        private final TextView name;
        private final ImageView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.one_img);
            name = itemView.findViewById(R.id.one_name);
            title = itemView.findViewById(R.id.one_title);
        }
    }
    public interface Click{
        void     click(int i);
    }
    private Click click;

    public void setClick(Click click) {
        this.click = click;
    }
}
