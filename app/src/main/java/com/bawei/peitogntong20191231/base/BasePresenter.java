package com.bawei.peitogntong20191231.base;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<M extends BaseModel,V extends BaseView> {
    private M model;
    private WeakReference<V> weakReference;
    private BasePresenter(){
        model = initModel();
    }

    protected abstract M initModel();

    public void attach(V v){
        weakReference = new WeakReference<>(v);
    }
    public void detach(){
        if (weakReference != null) {
            weakReference.clear();
            weakReference = null;
        }
    }
}
