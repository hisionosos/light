package com.hision.controllight;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import com.lzy.okgo.OkGo;
import java.util.logging.Level;



/**
 * Created by Administrator on 2018\4\25 0025.
 */

public class MyApplication extends Application {

    private static Context mContext;
    private static MyApplication application = null;
    public static String userToken = null;
    public static String userUuid = null;

    public static MyApplication getApplication(){
        return application;
    }
    public static Context getContext() {
        return mContext;
    }
    private BroadcastReceiver receiver;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        application = this;
        init();
    }


    private void init(){

        IntentFilter filter = new IntentFilter();
        filter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION);
        filter.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION);
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(receiver, filter);

        OkGo.init(this);
        OkGo.getInstance().debug("OkGo", Level.INFO, true);



    }



}
