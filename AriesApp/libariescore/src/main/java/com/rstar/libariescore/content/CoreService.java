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
package com.rstar.libariescore.content;

import android.content.Context;

import com.rstar.libappclient.IConnectListener;
import com.rstar.libappclient.IRStarAppInfo;
import com.rstar.libappclient.IRStarClientController;
import com.rstar.libappclient.RStarApi;

import java.io.PrintWriter;

/**
 * @Package: com.rstar.libariescore.content
 * @ClassName: CoreService
 * @Description: The service use to communicate with RStarCore.
 * @Author: 庆涛
 * @Email: zqt_olive@sina.com
 * @CreateDate: 2019/5/9 16:24
 * @UpdateUser:
 * @UpdateDate: 2019/5/9 16:24
 * @UpdateRemark:
 * @Version: 1.0
 */
public class CoreService implements ISystemService, IRStarAppInfo, IConnectListener {
    private RStarApi mService;

    CoreService(Context context, IRStarClientController controller) {
        mService = new RStarApi(context, this, controller, this);
        mService.connect();
    }

    @Override
    public void onConnected() {

    }

    @Override
    public void onDisconnected() {

    }

    @Override
    public String getAppSecretKey() {
        return null;
    }

    @Override
    public void dump(PrintWriter printWriter, String[] strings) {
        
    }

    @Override
    public String dumpDescription() {
        return null;
    }

    @Override
    public void test(PrintWriter printWriter, String[] strings) {

    }

    @Override
    public String testDescription() {
        return null;
    }
}
