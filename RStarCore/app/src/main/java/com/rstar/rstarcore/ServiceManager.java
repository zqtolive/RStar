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
import com.rstar.libappclient.debug.Testable;
import com.rstar.rstarcore.security.AuthorityManager;
import com.rstar.rstarcore.client.ClientManager;
import com.rstar.rstarcore.remote.RemoteService;

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
    public String dumpDescription() {
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
    public void dump(PrintWriter pw, String[] args) {
        if (args.length < 2) {
            prompt(pw);
        } else {
            BaseService baseService = findServiceByName(args[1]);
            if (baseService == null) {
                prompt(pw);
            } else {
                baseService.dump(pw, args);
            }
        }
    }

    private BaseService findServiceByName(String arg) {
        BaseService service = null;
        for (BaseService baseService : mServiceMap.values()) {
            if (baseService.getClass().getSimpleName().equals(arg)) {
                service = baseService;
                break;
            }
        }
        return service;
    }

    private void prompt(PrintWriter pw) {
        pw.println(mContext.getString(R.string.prompt_debug_message));
        for (BaseService service : mServiceMap.values()) {
            pw.print("  ");
            pw.print(service.getClass().getSimpleName());
            pw.print(" : ");
            pw.println(service.dumpDescription());
        }
    }

    private void testPrompt(PrintWriter pw) {
        pw.println(mContext.getString(R.string.prompt_debug_message));
        for (BaseService service : mServiceMap.values()) {
            if (service instanceof Testable) {
                pw.print("  ");
                pw.print(service.getClass().getSimpleName());
                pw.print(" : ");
                pw.println(((Testable) service).testDescription());
            }
        }
    }

    @Override
    public void test(PrintWriter pw, String[] args) {
        if (args.length < 2) {
            testPrompt(pw);
        } else {
            BaseService baseService = findServiceByName(args[1]);
            if (baseService == null || !(baseService instanceof Testable)) {
                testPrompt(pw);
            } else {
                ((Testable) baseService).test(pw, args);
            }
        }
    }

    @Override
    public String testDescription() {
        return null;
    }
}
