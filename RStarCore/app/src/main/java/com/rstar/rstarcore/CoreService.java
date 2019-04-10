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
package com.rstar.rstarcore;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.rstar.rstarcore.client.ClientManager;
import com.rstar.rstarcore.remote.RemoteService;

/**
 * @Package: com.rstar.rstarcore
 * @ClassName: CoreService
 * @Description:
 * @Author: 庆涛
 * @Email: zqt_olive@sina.com
 * @CreateDate: 2019/4/10 12:56
 * @UpdateUser:
 * @UpdateDate: 2019/4/10 12:56
 * @UpdateRemark:
 * @Version: 1.0
 */
public class CoreService extends Service {
    private static final String TAG = CoreService.class.getSimpleName();

    private ServiceManager mServiceManager;

    @Override
    public void onCreate() {
        super.onCreate();
        init(getApplicationContext());
    }

    private void init(Context context) {
        mServiceManager = new ServiceManager(null, context);
        mServiceManager.createSystemService();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        IBinder binder;
        switch (intent.getAction()) {
            case RStarCoreConst.ACTION_CORE_SERVICE:
                ((RemoteService) mServiceManager.getService(RStarCoreConst
                        .SERVICE_TYPE_REMOTE_SERVICE)).oauth(intent
                                .getStringExtra(RStarCoreConst.KEY_APP_NAME)
                        , intent.getStringExtra(RStarCoreConst.KEY_APP_SIGNATURE)
                        , intent.getStringExtra(RStarCoreConst.KEY_APP_SECRETKEY));
                binder = ((ClientManager) mServiceManager.getService(RStarCoreConst
                        .SERVICE_TYPE_CLIENT_MANAGER)).registerClient(intent
                                .getStringExtra(RStarCoreConst.KEY_APP_NAME)
                        , intent.getStringExtra(RStarCoreConst.KEY_APP_SIGNATURE)
                        , intent.getStringExtra(RStarCoreConst.KEY_APP_SECRETKEY));
                break;
            default:
                binder = null;
                break;
        }
        return binder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }
}
