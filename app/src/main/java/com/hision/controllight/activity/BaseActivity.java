package com.hision.controllight.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.hision.controllight.utils.AppManager;
import com.hision.controllight.utils.AppUtils;
import com.hision.controllight.views.HttpProgressDialog;
import com.lzy.okgo.OkGo;

import butterknife.ButterKnife;

public abstract class BaseActivity extends Activity {

    /***是否显示标题栏*/
    private  boolean isshowtitle = false;
    /***是否显示状态栏*/
    private  boolean isshowstate = true;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(AppUtils.updateLanguage(newBase));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(!isshowtitle){
            requestWindowFeature(Window.FEATURE_NO_TITLE);
        }

        if(!isshowstate){
            getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN ,
                    WindowManager.LayoutParams. FLAG_FULLSCREEN);
        }
        setContentView(initLayout());
        ButterKnife.bind(this);

        initView(savedInstanceState);
        initData();
        AppManager.getAppManager().addActivity(this);

    }


    public void setTitleBar(boolean ishow) {
        isshowtitle = ishow;
    }

    public void setTopBar(boolean ishow) {
        isshowstate=ishow;
    }


    @Override
    protected void onDestroy() {
        // 结束Activity&从堆栈中移除
        AppManager.getAppManager().finishActivity(this);
        OkGo.getInstance().cancelTag(this);
        super.onDestroy();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (isShouldHideInput(v, ev)) {
                hideSoftInput(v.getWindowToken());
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    private boolean isShouldHideInput(View v, MotionEvent ev) {
        if (v != null && (v instanceof EditText)) {
            int[] l = {0, 0};
            v.getLocationInWindow(l);
            int left = l[0], top = l[1], right = left + v.getWidth(), bottom = top + v.getHeight();
            if (ev.getX() > left && ev.getX() < right && ev.getY() > top && ev.getY() < bottom) {
                return false;// 忽略
            } else
                return true;
        }
        return false;
    }

    private void hideSoftInput(IBinder token) {
        if (token != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(token, InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    private HttpProgressDialog dialog = null;

    private String message = "";
    public void setMessage(String message){
        this.message = message;
    }
    public void showLoadingDialog(){
        if (null == dialog){
            dialog = new HttpProgressDialog(this,message);
            dialog.setCanceledOnTouchOutside(false);
        }

        dialog.show();

    }

    public void hideLoadingDialog(){
        if (null != dialog){
            dialog.dismiss();
            dialog = null;
        }
    }


    public abstract void initView(@Nullable Bundle savedInstanceState);

    public abstract void initData();

    public abstract int initLayout();

}
