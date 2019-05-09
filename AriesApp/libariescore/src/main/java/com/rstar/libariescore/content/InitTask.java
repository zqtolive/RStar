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
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

import com.rstar.libariescore.AriesCoreConst;
import com.rstar.libariescore.UserServiceCreator;
import com.rstar.libariescore.task.BaseTask;

import java.util.Iterator;
import java.util.Map;

/**
 * @Package: com.rstar.libariescore.task.impl
 * @ClassName: InitTask
 * @Description:
 * @Author: 庆涛
 * @Email: zqt_olive@sina.com
 * @CreateDate: 2019/4/30 17:01
 * @UpdateUser:
 * @UpdateDate: 2019/4/30 17:01
 * @UpdateRemark:
 * @Version: 1.0
 */
class InitTask extends BaseTask {
    private static final int MSG_INIT_SYSTEM_SERVICE = 0;
    private static final int MSG_INIT_USER_SERVICE = 1;
    private AriesContext mAriesContext;
    private InitHandler mHandler;

    private class InitHandler extends Handler {
        InitHandler(Looper looper) {
            super(looper);
        }

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_INIT_SYSTEM_SERVICE:
                    ISystemService service = new CoreService(mAriesContext.getContext()
                            , new ClientController(mAriesContext));
                    mAriesContext.attachSystemService(AriesCoreConst.NAME_SERVICE_CORE, service);
                    break;
                case MSG_INIT_USER_SERVICE:
                    if (msg.obj != null) {
                        Map<String, ISystemService> serviceMap = ((UserServiceCreator) msg.obj)
                                .createUserService(mAriesContext);
                        if (serviceMap != null && serviceMap.size() > 0) {
                            Iterator<Map.Entry<String, ISystemService>> iterator
                                    = serviceMap.entrySet().iterator();
                            Map.Entry<String, ISystemService> value;
                            while (iterator.hasNext()) {
                                value = iterator.next();
                                mAriesContext.attachSystemService(value.getKey(), value.getValue());
                            }
                        }
                    }
                    break;
            }
        }
    }

    InitTask(AriesContext ariesContext) {
        mAriesContext = ariesContext;
    }

    void start(UserServiceCreator creator) {
        HandlerThread runThread = new HandlerThread(AriesCoreConst.NAME_TASK_RUN_LOOPER);
        runThread.start();
        mAriesContext.attachLooper(AriesCoreConst.NAME_TASK_RUN_LOOPER, runThread.getLooper());
        mHandler = new InitHandler(runThread.getLooper());
        mHandler.sendEmptyMessage(MSG_INIT_SYSTEM_SERVICE);
        mHandler.sendMessage(mHandler.obtainMessage(MSG_INIT_USER_SERVICE, creator));
    }

    @Override
    protected Object getTaskService() {
        return null;
    }

    @Override
    public boolean onNewCommand(String action, String commandText, int commandCode, Bundle param) {
        return false;
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public Context getContext() {
        return getAriesContext().getContext();
    }
}
