package bwie.com.zhangshuaikang20180908;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hjm.bottomtabbar.BottomTabBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import bwie.com.zhangshuaikang20180908.fragment.Fragment1;
import bwie.com.zhangshuaikang20180908.fragment.Fragment2;
import bwie.com.zhangshuaikang20180908.fragment.Fragment3;
import bwie.com.zhangshuaikang20180908.fragment.Fragment4;
import bwie.com.zhangshuaikang20180908.fragment.Fragment5;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btb)
    BottomTabBar btb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        btb.init(getSupportFragmentManager())
                .setImgSize(100, 100)
                .setFontSize(0)
                .setTabPadding(1, 1, 1)
                .setChangeColor(Color.RED, Color.DKGRAY)
                .addTabItem("首页", R.drawable.ac0, Fragment1.class)
                .addTabItem("分类", R.drawable.abw, Fragment2.class)
                .addTabItem("发现", R.drawable.aby, Fragment3.class)
                .addTabItem("购物车", R.drawable.abu, Fragment4.class)
                .addTabItem("我的", R.drawable.ac2, Fragment5.class)
                .isShowDivider(false);

    }
}
