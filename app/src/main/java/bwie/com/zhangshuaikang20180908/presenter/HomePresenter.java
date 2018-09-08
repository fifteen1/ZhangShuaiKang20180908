package bwie.com.zhangshuaikang20180908.presenter;

import java.util.HashMap;

import bwie.com.zhangshuaikang20180908.bean.HomeBean;
import bwie.com.zhangshuaikang20180908.model.HomeModel;
import bwie.com.zhangshuaikang20180908.view.IcartView;

public class HomePresenter {
    private HomeModel homeModel;
    private IcartView icartView;
    public HomePresenter(IcartView icartView){
        homeModel = new HomeModel();
        attachView(icartView);
    }
    public void attachView(IcartView icartView){
        this.icartView = icartView;
    }

    public void getCart(HashMap<String,String> params,String url){
        homeModel.getCart(params, url, new HomeModel.CartCallback() {
            @Override
            public void success(HomeBean homeBean) {
                if (icartView != null) {
                    icartView.success(homeBean);
                }
            }
            @Override
            public void fail(String msg) {
                if (icartView != null) {
                    icartView.failure(msg);
                }
            }
        });
    }
    public void datachView(){
        this.icartView = null;
    }
}
