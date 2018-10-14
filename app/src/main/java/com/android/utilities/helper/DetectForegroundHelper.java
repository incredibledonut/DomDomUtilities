package com.android.utilities.helper;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import com.android.utilities.util.LogUtil;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Dominic Sham on 6/10/2016.
 */
public class DetectForegroundHelper implements Application.ActivityLifecycleCallbacks {

    public static final long CHECK_DELAY = 500;
    public static final String TAG = DetectForegroundHelper.class.getName();
    private static DetectForegroundHelper instance;
    private boolean foreground = false, paused = true;
    private Handler handler = new Handler();
    private List<Listener> listeners = new CopyOnWriteArrayList<Listener>();
    private Runnable check;

    /**
     * Its not strictly necessary to use this method - _usually_ invoking
     * get with a Context gives us a path to retrieve the Application and
     * initialise, but sometimes (e.g. in test harness) the ApplicationContext
     * is != the Application, and the docs make no guarantees.
     *
     * @param application
     * @return an initialised DetectForegroundHelper instance
     */
    public static DetectForegroundHelper init(Application application) {
        if (instance == null) {
            instance = new DetectForegroundHelper();
            application.registerActivityLifecycleCallbacks(instance);
        }
        return instance;
    }

    public static DetectForegroundHelper get(Application application) {
        if (instance == null) {
            init(application);
        }
        return instance;
    }

    public static DetectForegroundHelper get(Context ctx) {
        if (instance == null) {
            Context appCtx = ctx.getApplicationContext();
            if (appCtx instanceof Application) {
                init((Application) appCtx);
            }
            throw new IllegalStateException(
                    "DetectForegroundHelper is not initialised and " +
                            "cannot obtain the Application object");
        }
        return instance;
    }

    public static DetectForegroundHelper get() {
        if (instance == null) {
            throw new IllegalStateException(
                    "DetectForegroundHelper is not initialised - invoke " +
                            "at least once with parameterised init/get");
        }
        return instance;
    }

    public boolean isForeground() {
        return foreground;
    }

    public boolean isBackground() {
        return !foreground;
    }

    public void addListener(Listener listener) {
        listeners.add(listener);
    }

    public void removeListener(Listener listener) {
        listeners.remove(listener);
    }

    @Override
    public void onActivityResumed(Activity activity) {
        paused = false;
        boolean wasBackground = !foreground;
        foreground = true;

        if (check != null)
            handler.removeCallbacks(check);

        if (wasBackground) {
            LogUtil.d("went foreground");
            for (Listener l : listeners) {
                try {
                    l.onBecameForeground();
                } catch (Exception exc) {
                    exc.printStackTrace();
                    LogUtil.d("Listener threw exception!");
                }
            }
        } else {
            LogUtil.d("still foreground");
        }
    }

    @Override
    public void onActivityPaused(Activity activity) {
        paused = true;

        if (check != null)
            handler.removeCallbacks(check);

        handler.postDelayed(check = new Runnable() {
            @Override
            public void run() {
                if (foreground && paused) {
                    foreground = false;
                    LogUtil.d("went background");
                    for (Listener l : listeners) {
                        try {
                            l.onBecameBackground();
                        } catch (Exception exc) {
                            exc.printStackTrace();
                            LogUtil.d("Listener threw exception!");
                        }
                    }
                } else {
                    LogUtil.d("still foreground");
                }
            }
        }, CHECK_DELAY);
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
    }

    @Override
    public void onActivityStarted(Activity activity) {
    }

    @Override
    public void onActivityStopped(Activity activity) {
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
    }

    @Override
    public void onActivityDestroyed(Activity activity) {
    }

    public interface Listener {

        public void onBecameForeground();

        public void onBecameBackground();

    }
}
