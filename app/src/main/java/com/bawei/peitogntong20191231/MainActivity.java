package com.bawei.peitogntong20191231;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.bawei.peitogntong20191231.adapter.MyAdapter;
import com.bawei.peitogntong20191231.base.BaseActivity;
import com.bawei.peitogntong20191231.entity.Bean;
import com.bawei.peitogntong20191231.utils.OkHttpUtils;
import com.google.gson.Gson;

import java.util.List;
/*
* 裴童童
* 2019.12.31
* */
public class MainActivity extends BaseActivity {
    @BindView(R.id.rv)
    RecyclerView rv;
    @BindView(R.id.tiao)
    TextView tiao;

    @Override
    protected void initData() {
        ButterKnife.bind(this);
        String Url = "http://blog.zhaoliang5156.cn/api/news/ranking.json";
        OkHttpUtils.getInstance().doGet(Url, new OkHttpUtils.OkCallBack() {
            @Override
            public void success(String result) {
                Bean bean = new Gson().fromJson(result, Bean.class);
                List<Bean.RankingBean> ranking = bean.getRanking();
                rv.setAdapter(new MyAdapter(MainActivity.this,ranking));
            }

            @Override
            public void error(Throwable throwable) {

            }
        });
    }

    @Override
    protected void initView() {

        rv.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }
}
