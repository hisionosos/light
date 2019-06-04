package com.hision.controllight.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.hision.controllight.R;
import com.hision.controllight.adapter.DeviceListAdapter;
import com.hision.controllight.bean.LogoInfosBean;
import com.hision.controllight.views.SlidingMenu;
import com.hision.controllight.views.xrecycleview.XRecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.id_menu)
    SlidingMenu idMenu;
    @BindView(R.id.device_list)
    XRecyclerView deviceList;

    private DeviceListAdapter adapter;
    private ArrayList<LogoInfosBean> listDevice = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        deviceList.setLayoutManager(layoutManager);

        for (int i = 0; i < 3; i++) {
            LogoInfosBean bean = new LogoInfosBean();
            bean.setAddress("sasas");
            bean.setName("123344545");
            bean.setSn("frfrgegerg");
            listDevice.add(bean);
        }
        adapter = new DeviceListAdapter(this,listDevice);
        deviceList.setAdapter(adapter);

        deviceList.setPullRefreshEnabled(false);
        deviceList.setLoadingMoreEnabled(false);

        adapter.notifyDataSetChanged();
    }


    public void toggleMenu(View view) {
        idMenu.toggle();
    }
}
