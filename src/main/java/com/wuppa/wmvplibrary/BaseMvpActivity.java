package com.wuppa.wmvplibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseMvpActivity<M extends BaseModel, V extends BaseView, P extends BasePresenter> extends AppCompatActivity implements BaseMvp<M, V, P>, BaseInit {
    protected P presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = createPresenter();
        if (presenter != null) {
            presenter.registerModel(createModel());
            presenter.registerView(createView());
        }

        setContentView(initViewResourceId());
        init();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.destroy();
        }
    }
}
