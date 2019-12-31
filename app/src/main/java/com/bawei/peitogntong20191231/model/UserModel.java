package com.bawei.peitogntong20191231.model;

import com.bawei.peitogntong20191231.contract.UserContract;
import com.bawei.peitogntong20191231.utils.OkHttpUtils;

public class UserModel implements UserContract.IModel {
    @Override
    public void getUser(String Url, ModelCallBack modelCallBack) {
        OkHttpUtils.getInstance().doGet(Url, new OkHttpUtils.OkCallBack() {
            @Override
            public void success(String result) {
                modelCallBack.success(result);
            }

            @Override
            public void error(Throwable throwable) {
                modelCallBack.error(throwable);
            }
        });
    }
}
