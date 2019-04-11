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
import android.os.RemoteException;
import android.support.annotation.NonNull;

import com.rstar.rstarcore.IRStarClientApi;
import com.rstar.rstarcore.IRStarClientController;

/**
 * @Package: com.rstar.rstarcore.appclient
 * @ClassName: RStarApi
 * @Description: Connect to the service and provide api for client app.
 * @Author: 庆涛
 * @Email: zqt_olive@sina.com
 * @CreateDate: 2019/4/10 12:37
 * @UpdateUser:
 * @UpdateDate: 2019/4/10 12:37
 * @UpdateRemark:
 * @Version: 1.0
 */
public class RStarApi {
    private static final String TAG = RStarApi.class.getSimpleName();

    private Context mContext;
    private IRStarClientApi mApi;
    private IRStarAppInfo mAppInfo;
    private IRStarClientController mController;
    private ServiceConnection mConnection;

    public RStarApi(@NonNull Context context, @NonNull IRStarAppInfo appInfo
            , @NonNull IRStarClientController controller) {
        mContext = context.getApplicationContext();
        mAppInfo = appInfo;
        mController = controller;
        mConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                mApi = IRStarClientApi.Stub.asInterface(service);
                try {
                    mApi.registerAppController(mController);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                mApi = null;
            }
        };
    }

    /**
     * Connect to RStar core service.
     */
    public final void connect() {
        Intent intent = new Intent(AppClientConst.ACTION_CORE_SERVICE);
        intent.putExtra(AppClientConst.KEY_APP_NAME, mContext.getPackageName());
        intent.putExtra(AppClientConst.KEY_APP_SIGNATURE, AppSignatureHelper
                .getAppSignature(mContext, AppClientConst.SignatureType.SHA1));
        intent.putExtra(AppClientConst.KEY_APP_SECRETKEY, mAppInfo.getAppSecretKey());
        mContext.bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
    }

    public final void disconnect() {
        mContext.unbindService(mConnection);
    }
}
