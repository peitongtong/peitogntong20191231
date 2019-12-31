package com.bawei.peitogntong20191231.contract;

import com.bawei.peitogntong20191231.entity.Bean;

import java.util.List;

public interface UserContract {
    interface IModel{
        void getUser(String Url,ModelCallBack modelCallBack);
        interface ModelCallBack{
            void success(String bean);
            void error(Throwable throwable);
        }
    }
    interface IView{
        void success(String bean);
        void error(Throwable throwable);
    }
    interface IPresenter{
        void getUser(String Url);
    }
}
