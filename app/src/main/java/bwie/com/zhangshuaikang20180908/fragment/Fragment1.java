package bwie.com.zhangshuaikang20180908.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import bwie.com.zhangshuaikang20180908.R;
import bwie.com.zhangshuaikang20180908.api.Api;
import bwie.com.zhangshuaikang20180908.bean.HomeBean;
import bwie.com.zhangshuaikang20180908.utils.OkHttpUtils;
import bwie.com.zhangshuaikang20180908.utils.RequestCallback;
import okhttp3.Call;
import okhttp3.Response;

public class Fragment1 extends Fragment {
    @BindView(R.id.home_list)
    XRecyclerView homeList;
    Unbinder unbinder;
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment01, container, false);

        unbinder = ButterKnife.bind(this, view);
        initView();
        initData();
        return view;
    }

    private void initData() {
        OkHttpUtils.getInstance().postData(Api.HOME_URL, new HashMap<String, String>(), new RequestCallback() {
            @Override
            public void failure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) {
                if(200==response.code()){
                    try {
                        String result = response.body().string();
                        if(!TextUtils.isEmpty(result)){
                            parseResult(result);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private void parseResult(String result) {


    }

    private void initView() {
        homeList.setLayoutManager(new LinearLayoutManager(getActivity()));

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
