package com.trimph.everything;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.simple.eventbus.EventBus;
import org.simple.eventbus.Subscriber;
import org.simple.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);
    }

    //没有指定标签
    @Subscriber
    public void loadUser(String user){

    }

    //指定了tag 只有Post了指定的tag 方法才会执行
    @Subscriber(tag = "MyFirstTag")
    public void User(String user){

    }

    //指定了tag 只有Post了指定的tag 方法才会执行  指定在独立线程中
    @Subscriber(tag = "MyFirstTag",mode = ThreadMode.ASYNC)
    public void Users(String user){

    }
    //指定了tag 只有Post了指定的tag 方法才会执行  运行在执行Post方法的线程中
    @Subscriber(tag = "MyFirstTag",mode = ThreadMode.POST)
    public void Users3(String user){

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
