package com.wuppa.wmvplibrary;

public interface Presenter<M extends BaseModel, V extends BaseView> {
    void registerModel(M model);

    void registerView(V view);

    V getView();

    void destroy();
}
