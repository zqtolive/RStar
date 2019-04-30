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
package com.rstar.libappclient;

import android.os.IBinder;

/**
 * @Package: com.rstar.libappclient
 * @ClassName: ServiceDeathRecipient
 * @Description:
 * @Author: 庆涛
 * @Email: zqt_olive@sina.com
 * @CreateDate: 2019/4/30 16:05
 * @UpdateUser:
 * @UpdateDate: 2019/4/30 16:05
 * @UpdateRemark:
 * @Version: 1.0
 */
class ServiceDeathRecipient implements IBinder.DeathRecipient {
    private IConnectListener mConnectListener;

    ServiceDeathRecipient(IConnectListener connectListener) {
        mConnectListener = connectListener;
    }

    @Override
    public void binderDied() {
        mConnectListener.onDisconnected();
    }
}
