package com.bawei.peitogntong20191231.utils;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class OkHttpUtils {
    private static OkHttpUtils okHttpUtils;
    private Handler handler = new Handler();
    private RequestQueue requestQueue;

    public static OkHttpUtils getInstance(){
        if (okHttpUtils==null){
            synchronized (OkHttpUtils.class){
                if (okHttpUtils==null){
                    okHttpUtils = new OkHttpUtils();
                }
            }
        }
        return okHttpUtils;
    }
    public void doGet(String Url,OkCallBack okCallBack){
        Request request = new Request.Builder()
                .url(Url)
                .get()
                .build();
      new OkHttpClient().newCall(request).enqueue(new Callback() {
          @Override
          public void onFailure(@NotNull Call call, @NotNull IOException e) {
              if (okCallBack != null) {
                  okCallBack.error(e);
              }
          }

          @Override
          public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
              String result = response.body().toString();
              if (okCallBack != null) {
                  handler.post(new Runnable() {
                      @Override
                      public void run() {
                            okCallBack.success(result);
                      }
                  });
              }
          }
      });
    }
    public interface OkCallBack{
        void success(String result);
        void error(Throwable throwable);
    }
    public boolean hasNet(Context context){
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        if (info!=null&&info.isConnected()){
            return true;
        }else {
            return false;
        }

    }
}
