/*
 * Copyright (c) 2019. The RStar Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.rstar.rstarcore.client;

import android.app.IActivityController;
import android.content.Intent;
import android.os.RemoteException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Package: com.rstar.rstarcore.client
 * @ClassName: ActivityMonitor
 * @Description: Monitor the top activity change.
 * @Author: 庆涛
 * @Email: zqt_olive@sina.com
 * @CreateDate: 2019/4/14 11:16
 * @UpdateUser:
 * @UpdateDate: 2019/4/14 11:16
 * @UpdateRemark:
 * @Version: 1.0
 */
class ActivityMonitor extends IActivityController.Stub {
    private ConcurrentHashMap<String, IAppStatusChange> mListeners = new ConcurrentHashMap<>();
    private IAppStatusChange mFocus;

    ActivityMonitor() {
        setActivityController();
    }

    void registerListener(IAppStatusChange listener) {
        mListeners.put(listener.getAppName(), listener);
    }

    private void setActivityController() {
        try {
            Class<?> cActivityManagerNative = Class
                    .forName("android.app.ActivityManagerNative");
            Method mGetDefault = cActivityManagerNative.getMethod("getDefault");
            Object oActivityManagerNative = mGetDefault.invoke(null);
            Class<?> i = Class.forName("android.app.IActivityController$Stub");

            Method mSetActivityController = cActivityManagerNative.getMethod(
                    "setActivityController",
                    Class.forName("android.app.IActivityController"));
            mSetActivityController.invoke(oActivityManagerNative,
                    this);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean activityStarting(Intent intent, String pkg) throws RemoteException {
        return true;
    }

    @Override
    public boolean activityResuming(String pkg) throws RemoteException {
        if (mFocus != null && !pkg.equals(mFocus.getAppName())) {
            mFocus.onPause(pkg);
        }
        mFocus = mListeners.get(pkg);
        if (mFocus != null) {
            mFocus.onResume(pkg);
        }
        return true;
    }

    @Override
    public boolean appCrashed(String processName, int pid, String shortMsg, String longMsg, long timeMillis, String stackTrace) throws RemoteException {
        return true;
    }

    @Override
    public int appEarlyNotResponding(String processName, int pid, String annotation) throws RemoteException {
        return 0;
    }

    @Override
    public int appNotResponding(String processName, int pid, String processStats) throws RemoteException {
        return -1;
    }
}
