package com.example.dell.xiaoshixuncaseone.presenter;

import com.example.dell.xiaoshixuncaseone.bean.MaBean;
import com.example.dell.xiaoshixuncaseone.callback.MaCallback;
import com.example.dell.xiaoshixuncaseone.model.MaModel;
import com.example.dell.xiaoshixuncaseone.view.MaView;

public class MaPresenterimpel  implements MaPresenter,MaCallback{

    private MaModel maModel;
    private MaView maView;

    public MaPresenterimpel(MaModel maModel, MaView maView) {
        this.maModel = maModel;
        this.maView = maView;
    }

    @Override
    public void Sueecss(MaBean maBean) {
        maView.Sueecss(maBean);
    }

    @Override
    public void Fail(String s) {
        maView.Fail(s);
    }

    @Override
    public void MaData() {
        maModel.MaData(this);
    }
}
