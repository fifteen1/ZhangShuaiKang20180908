package bwie.com.zhangshuaikang20180908.model;

import android.os.Handler;
import android.text.TextUtils;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;

import bwie.com.zhangshuaikang20180908.bean.HomeBean;
import bwie.com.zhangshuaikang20180908.utils.OkHttpUtils;
import bwie.com.zhangshuaikang20180908.utils.RequestCallback;
import okhttp3.Call;
import okhttp3.Response;

public class HomeModel {
    Handler handler = new Handler();
    public void getCart(HashMap<String, String> params, String url, final CartCallback cartCallback) {
        OkHttpUtils.getInstance().postData(url, params, new RequestCallback() {
            @Override
            public void failure(Call call, IOException e) {
                if (cartCallback != null) {
                    cartCallback.fail("网络有异常，请稍后再试");
                }
            }

            @Override
            public void onResponse(Call call, Response response) {
                try {
                    String jsonResult = response.body().string();
                    if (!TextUtils.isEmpty(jsonResult)) {
                        parseResult(jsonResult, cartCallback);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
    });
    }

    private void parseResult(String jsonResult, final CartCallback cartCallback) {
        final HomeBean homeBean = new Gson().fromJson(jsonResult,HomeBean.class);
        if(cartCallback!=null&&homeBean!=null){
            handler.post(new Runnable() {
                @Override
                public void run() {
                    cartCallback.success(homeBean);
                }
            });

        }
    }
    public interface CartCallback{
        void success(HomeBean homeBean);
        void fail(String msg);
    }
}
