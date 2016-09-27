package com.yc.BaiSiBuDeJie.base;

import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;

import com.yc.BaiSiBuDeJie.R;
import com.yc.BaiSiBuDeJie.utils.SharedPreferencesMgr;

public abstract class BaseActivity extends AppCompatActivity {
    protected abstract void findView();

    protected abstract void setViewSize();

    protected abstract void initValue();

    protected abstract void bindEvent();

    protected abstract void addActivity();

    protected abstract void removeActivity();

    protected void init() {
        findView();
        setViewSize();
        initValue();
        bindEvent();
        addActivity();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        removeActivity();
    }

    @Override
    public void finish() {
        super.finish();
        removeActivity();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(SharedPreferencesMgr.getInt("theme", 0) == 1) {
            setTheme(R.style.theme_2);
        } else {
            setTheme(R.style.theme_1);
        }
    }
}
