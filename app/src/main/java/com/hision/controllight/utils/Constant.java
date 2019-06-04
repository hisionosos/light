package com.hision.controllight.utils;

import android.os.Environment;

import java.io.File;

public class Constant {
    /**
     * 网络请求返回码
     */

//    ERROR_400001("unAuth error", 400001),
//    ERROR_500001("Sending verification code failed", 500001),
//    ERROR_500002("Get sts code error", 500002),
//    ERROR_500003("SN already bind by another user", 500003),
//    ERROR_500004("SN already unbind by another user", 500004),
//    ERROR_500006("SN is not belonging to current user", 500006),
//    ERROR_500007("Push message to device failed", 500007),
//    ERROR_500008("Push message already acked", 500008),
//    ERROR_500009("Duplicated request", 500009),
//    ERROR_500010("Telephone already registered", 500010),
//    ERROR_999999("Service unavailable now, try later.", 999999);

    public final static int SUCCESS = 0;
    public final static int TIMEOUT = 401;
    public final static int SERVICEERROR = 500;
    public final static int ERROR_400001 = 400001;
    public final static int ERROR_500001 = 500001;
    public final static int ERROR_500002 = 500002;
    public final static int ERROR_500003 = 500003;
    public final static int ERROR_500004 = 500004;
    public final static int ERROR_500006 = 500006;
    public final static int ERROR_500007 = 500007;
    public final static int ERROR_500008 = 500008;
    public final static int ERROR_500009 = 500009;
    public final static int ERROR_500010 = 500010;
    public final static int ERROR_999999 = 999999;

    //oss個人文件夾路徑
    public final static String common_path = "user/" + SharedPreferencesUtils.getParam("uuid","") + "/";
    public final static String SD_PATH = Environment.getExternalStorageDirectory() + File.separator;

    //Activity跳转请求码
    public final static int REQUEST_CHOOSE_OSS_CODE = 2001;
    public final static int REQUEST_CHOOSE_IMG_CODE = 2002;
    public final static int REQUEST_CHOOSE_OSS_LOGO = 2003;
    public final static int REQUEST_CHOOSE_OSS_LOGO_BACK = 2004;

    //JPush相关
    public final static int JPUSH_ALIAS = 3000;
    public final static String JPUSH_TYPE_MAINTAIN = "maintain";
    public final static String JPUSH_TYPE_PLAYLIST = "playlist";
    public final static String JPUSH_TYPE_CALLBACK_SYNC = "callback-sync";
    public final static String JPUSH_TYPE_OPERACTION = "operaction";
    public final static String JPUSH_TYPE_CALLBACK = "callback";
    public final static String JPUSH_TYPE_EXCEPTION = "exception";
    public final static String JPUSH_TYPE_NOTIFICATION = "notification";

    //蓝牙回调
    public final static int REQUEST_BT_ENABLE_CODE = 8000;
    public final static int CONFIG_NETWORK_CODE = 8001;

    public static final String CONFIT_DISCONNECTED = "10000001";
    public static final String CONFIT_CONNECTED = "0";
    public static final String CONFIT_CONNECTING = "1";



    //与LOGO灯约定的字段信息
    public final static String LOGO_BIND_SERVICE = "10000000-0000-1000-8000-008000000000";
    public final static String WIFI_SSID_CHARACTERISTIC = "10000000-0000-1000-8000-008000000001";
    public final static String WIFI_PASSWORD_CHARACTERISTIC = "10000000-0000-1000-8000-008000000002";
    public final static String DEVICE_BIND_CHARACTERISTIC = "10000000-0000-1000-8000-008000000003";
    public final static String DEVICE_SN_CHARACTERISTIC = "10000000-0000-1000-8000-008000000004";


    //广播字段
    public final static String OSSRECEIVER = "oss_token";
    public final static String LOGIN_FLAG = "login_flag";
    public final static String WIFI_PWD = "wifi_pwd";
    public final static String WIFI_SSID = "wifi_ssid";
    public final static String CONFIG_WIFI_INFO = "config_wifi_info";
    public final static String APP_LANGUAGE = "app_language";


    //EventBus

    public final static String LOCAL_LANGUAGE = "local";
    public final static String JPUSH_DOWNLOAD_SUCCESS = "jpush_download_success";
    public final static String JPUSH_DELETE_SUCCESS = "jpush_delete_success";
    public final static String JPUSH_PLAYLIST_APPEND_SUCCESS = "jpush_playlist_append_success";
    public final static String JPUSH_PLAYLIST_DELETE_SUCCESS = "jpush_playlist_delete_success";
    public final static String JPUSH_PLAYSTATUS_SUCCESS = "jpush_playstatus_success";
    public final static String FRESH_DEVICES_LIST = "fresh_devices_list";
    public final static String FRESH_OSS_LIST = "fresh_oss_list";


    //设备播放状态
    public final static String LOGO_PLAYSTATUS_PLAYING = "playing";
    public final static String LOGO_PLAYSTATUS_PAUSE = "paused";
    public final static String LOGO_PLAYSTATUS_STOP = "stopped";

    //裁剪图片标准尺寸
    public final static int LOGO_IMAGE_WIDTH = 720;
    public final static int LOGO_IMAGE_HEIGHT = 1080;

    public static final String VIDEO_DIR = "logo_video";
    public static final String IMAGE_DIR = "logo_edit";
}
