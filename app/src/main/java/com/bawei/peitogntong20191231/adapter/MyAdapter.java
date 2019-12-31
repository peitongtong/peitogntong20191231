package com.bawei.peitogntong20191231.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.peitogntong20191231.R;
import com.bawei.peitogntong20191231.entity.Bean;
import com.bumptech.glide.Glide;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    private Context context;
    private List<Bean.RankingBean> list;

    public MyAdapter(Context context, List<Bean.RankingBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_layout, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context)
                .load(list.get(position).getAvatar())
                .into(holder.touxiang);
        holder.paiming.setText(list.get(position).getRank());
        holder.ming.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.touxiang)
        private ImageView touxiang;
        @BindView(R.id.paiming)
        private TextView paiming;
        @BindView(R.id.ming)
        private TextView ming;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(itemView);
        }
    }
}
