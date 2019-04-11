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

import android.content.Context;
import android.os.Bundle;

import com.rstar.rstarcore.debug.DebugServer;
import com.rstar.rstarcore.security.AuthorityManager;
import com.rstar.rstarcore.client.ClientManager;
import com.rstar.rstarcore.remote.RemoteService;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * @Package: com.rstar.rstarcore
 * @ClassName: ServiceManager
 * @Description: Manage all system service.
 * @Author: 庆涛
 * @Email: zqt_olive@sina.com
 * @CreateDate: 2019/4/10 16:38
 * @UpdateUser:
 * @UpdateDate: 2019/4/10 16:38
 * @UpdateRemark:
 * @Version: 1.0
 */
public class ServiceManager extends BaseService implements IRStarService {
    private static final String TAG = ServiceManager.class.getSimpleName();

    private HashMap<String, BaseService> mServiceMap = new HashMap<>();
    private DebugServer mDebugServer;

    ServiceManager(IRStarService service, Context context) {
        super(service, context);
    }

    @Override
    protected void onDestroy() {
        mDebugServer.destroy();
        for (BaseService service : mServiceMap.values()) {
            service.destroy();
        }
        mDebugServer = null;
        mServiceMap.clear();
        mServiceMap = null;
    }

    @Override
    protected String description() {
        return null;
    }

    /**
     * Create system service.
     */
    void createSystemService() {
        mDebugServer = new DebugServer(this, mContext);
        BaseService baseService = new ClientManager(this, mContext);
        mServiceMap.put(RStarCoreConst.SERVICE_TYPE_CLIENT_MANAGER, baseService);
        baseService = new RemoteService(this, mContext);
        mServiceMap.put(RStarCoreConst.SERVICE_TYPE_REMOTE_SERVICE, baseService);
        baseService = new AuthorityManager(this, mContext);
        mServiceMap.put(RStarCoreConst.SERVICE_TYPE_AUTHORITY_MANAGER, baseService);

        mDebugServer.startServer();
    }

    @Override
    public BaseService getService(String serviceType) {
        return mServiceMap.get(serviceType);
    }

    @Override
    public int execute(String serviceType, String method, Bundle param, Bundle out) {
        BaseService baseService = mServiceMap.get(serviceType);
        int result = 0;
        if (baseService != null) {
            result = baseService.execute(method, param, out);
        }
        return result;
    }

    @Override
    public void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        if (args == null || args.length < 1) {
            prompt(pw);
        } else {
            BaseService baseService = findServiceByName(args[0]);
            if (baseService == null) {
                prompt(pw);
            } else {

            }
        }
    }

    private BaseService findServiceByName(String arg) {
        BaseService service = null;
        return service;
    }

    private void prompt(PrintWriter pw) {
        pw.println(mContext.getString(R.string.prompt_debug_message));
        for (BaseService service : mServiceMap.values()) {
            pw.print("  ");
            pw.print(service.getClass().getSimpleName());
            pw.print(" : ");
            pw.println(service.description());
        }
    }
}
