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
package com.rstar.rstarcore.appclient;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.annotation.NonNull;

import com.rstar.rstarcore.aidl.IRStarClientApi;

public class RStarApi {
    private static final String TAG = RStarApi.class.getSimpleName();
    private static final String ACTION_CORE_SERVICE = "com.rstar.rstarcore.coreservice";

    private Context mContext;
    private IRStarClientApi mApi;

    public RStarApi(@NonNull Context context) {
        mContext = context.getApplicationContext();
    }

    public final void connect() {
        Intent intent = new Intent(ACTION_CORE_SERVICE);
        intent.putExtra(AppClientConst.KEY_APP_NAME, mContext.getPackageName());
        boolean success = false;
        try {
            success = mContext.bindService(intent, new ServiceConnection() {
                @Override
                public void onServiceConnected(ComponentName name, IBinder service) {
                    mApi = IRStarClientApi.Stub.asInterface(service);
                }

                @Override
                public void onServiceDisconnected(ComponentName name) {
                    mApi = null;
                }

                @Override
                public void onBindingDied(ComponentName name) {

                }
            }, Context.BIND_AUTO_CREATE);
        } catch (SecurityException e) {

        }
    }
}
