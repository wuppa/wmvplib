package com.wuppa.wmvplibrary;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<M extends BaseModel, V extends BaseView> implements Presenter<M, V> {
    private WeakReference<V> wrf;
    protected M model;

    @Override
    public void registerModel(M model) {
        this.model = model;
    }

    @Override
    public void registerView(V view) {
        wrf = new WeakReference<>(view);
    }

    @Override
    public V getView() {
        return wrf == null ? null : wrf.get();
    }

    @Override
    public void destroy() {
        if (wrf != null) {
            wrf.clear();
            wrf = null;
        }
        onViewDestroy();
    }

    protected abstract void onViewDestroy();
}
