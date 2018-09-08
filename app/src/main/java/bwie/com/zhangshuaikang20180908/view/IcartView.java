package bwie.com.zhangshuaikang20180908.view;


import bwie.com.zhangshuaikang20180908.bean.HomeBean;

public interface IcartView {
    void success(HomeBean cartBean);
    void failure(String msg);
}
