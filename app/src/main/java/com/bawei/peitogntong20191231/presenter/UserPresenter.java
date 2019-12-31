package com.bawei.peitogntong20191231.presenter;

import com.bawei.peitogntong20191231.contract.UserContract;
import com.bawei.peitogntong20191231.entity.Bean;
import com.bawei.peitogntong20191231.model.UserModel;

public class UserPresenter implements UserContract.IPresenter {
    private UserModel model;
    private UserContract.IView view;

    public UserPresenter(UserContract.IView view) {
        this.view = view;
        model = new UserModel();
    }

    @Override
    public void getUser(String Url) {
        model.getUser(Url, new UserContract.IModel.ModelCallBack() {


            @Override
            public void success(String bean) {
                view.success(bean);
            }

            @Override
            public void error(Throwable throwable) {
                view.error(throwable);
            }
        });
    }
}
