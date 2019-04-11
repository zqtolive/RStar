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

import android.app.ActivityManager;
import android.content.Context;
import android.os.RemoteException;

import com.rstar.rstarcore.IRStarClientApi;
import com.rstar.rstarcore.IRStarClientController;

/**
 * @Package: com.rstar.rstarcore.client
 * @ClassName: ClientService
 * @Description: It provides service for client app.
 * @Author: 庆涛
 * @Email: zqt_olive@sina.com
 * @CreateDate: 2019/4/10 16:09
 * @UpdateUser:
 * @UpdateDate: 2019/4/10 16:09
 * @UpdateRemark:
 * @Version: 1.0
 */
public class ClientService extends IRStarClientApi.Stub {
    private ClientInfo mInfo;

    ClientService(ClientInfo clientInfo) {
        mInfo = clientInfo;
    }

    ClientInfo getInfo() {
        return mInfo;
    }

    /**
     * While CoreService destroy will call it to destroy ClientService.
     */
    void onDestroy() {
        mInfo.onDestroy();
        mInfo = null;
    }

    /**
     * While client unbind with CoreService, it will be called.
     */
    void onUnbind() {
        mInfo.onUnbind();
    }

    /**
     * While the client app rebind to CoreService, it will be called.
     */
    void onRebind() {
        mInfo.onRebind();
    }

    @Override
    public void registerAppController(IRStarClientController controller) throws RemoteException {
        mInfo.setClientController(controller);
    }
}
