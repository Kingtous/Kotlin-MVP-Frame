package cn.kingtous.mvp;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;

import cn.kingtous.mvp.net.NetworkProvider;

import java.util.ArrayList;
import java.util.List;

import cn.droidlover.xdroidmvp.net.XApi;

import static android.content.ContentValues.TAG;

/**
 * @author DuLong
 * @Since 19/7/29
 */

public class App extends Application {
    private static List<Activity> activityList = new ArrayList<>();
    private static Context instance ;    //实例对象

    @Override
    public void onCreate() {
        super.onCreate();
        // android 7.0系统解决拍照的问题
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        builder.detectFileUriExposure();

        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                activityList.add(activity);
            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                activityList.remove(activity);
            }
        });
        instance = getApplicationContext();
        // 注册公用网络提供类
        XApi.registerProvider(new NetworkProvider());
    }


    /**
     * 外部获取实例对象
     *
     * @return app
     */
    public static Context getInstance() {
        if(instance == null)
            Log.d(TAG, "未初始化 ");
        return instance;
    }

    /**
     * 移除Activity
     *
     * @param activity act
     */

    public static void removeActivity(Activity activity) {
        if (activity != null && !activity.isFinishing()) {
            activity.finish();
        }
    }

    /**
     * 清除所有的Activity
     */
    public static void removeAllActivity() {
        for (Activity activity : activityList) {
            if (activity != null && !activity.isFinishing()) {
                activity.finish();
            }
        }
    }

}
