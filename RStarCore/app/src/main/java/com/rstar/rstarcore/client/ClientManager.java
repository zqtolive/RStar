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

import com.rstar.rstarcore.BaseService;
import com.rstar.rstarcore.IRStarService;
import com.rstar.rstarcore.R;

import java.io.PrintWriter;
import java.util.HashMap;

/**
 * @Package: com.rstar.rstarcore.client
 * @ClassName: ClientManager
 * @Description: Manage the clients which has connected with the server.
 * @Author: 庆涛
 * @Email: zqt_olive@sina.com
 * @CreateDate: 2019/4/10 12:50
 * @UpdateUser:
 * @UpdateDate: 2019/4/10 12:50
 * @UpdateRemark:
 * @Version: 1.0
 */
public class ClientManager extends BaseService {
    private static final String TAG = ClientManager.class.getSimpleName();
    private HashMap<String, ClientService> mClientMap = new HashMap<>();
    private ActivityMonitor mMonitor;

    public ClientManager(IRStarService service, Context context) {
        super(service, context);
        mMonitor = new ActivityMonitor();
    }

    @Override
    protected void onDestroy() {
        for (ClientService client : mClientMap.values()) {
            client.onDestroy();
        }
        mClientMap.clear();
        mClientMap = null;
    }

    @Override
    public String dumpDescription() {
        return mContext.getString(R.string.description_client_manager);
    }

    private void prompt(PrintWriter pw) {
        pw.println(mContext.getString(R.string.prompt_debug_message));
        pw.println(mContext.getString(R.string.prompt_client_manager_all));
        for (ClientService client : mClientMap.values()) {
            pw.println(client.getInfo().getAppName());
        }
    }

    private ClientService findClientByName(String name) {
        ClientService clientService = null;
        for (ClientService client : mClientMap.values()) {
            if (client.getInfo().getAppName().equals(name)) {
                clientService = client;
                break;
            }
        }
        return clientService;
    }

    @Override
    public void dump(PrintWriter pw, String[] args) {
        if (args.length < 3) {
            prompt(pw);
        } else if (args[2].equals(ClientConst.CMD_DUMP_ALL)) {
            pw.println("Client's count" + mClientMap.size() + ",All clients info:");
            for (ClientService client : mClientMap.values()) {
                client.getInfo().dump(pw);
            }
        } else {
            ClientService clientService = findClientByName(args[2]);
            if (clientService == null) {
                prompt(pw);
            } else {
                clientService.getInfo().dump(pw, args);
            }
        }
    }

    private String genClientKey(String clientName, String clientSignature) {
        StringBuilder stringBuilder = new StringBuilder(clientName);
        stringBuilder.append(ClientConst.DIV_CLIENT_KEY).append(clientSignature);
        return stringBuilder.toString();
    }

    /**
     * While client connect to the server, need register to ClientManager and obtain a handle of
     * IRStarClientApi.Stub to communicate with server.
     *
     * @param clientName      The package name of client
     * @param clientSignature The client's signature
     * @param secretKey       The client's secret key
     * @return The handle of IRStarClientApi.Stub
     */
    public ClientService registerClient(String clientName, String clientSignature, String secretKey) {
        ClientService clientService;
        String key = genClientKey(clientName, clientSignature);
        clientService = mClientMap.get(key);
        if (clientService == null) {
            ClientInfo client = new ClientInfo(clientName, clientSignature, secretKey, mContext);
            clientService = new ClientService(client);
            mClientMap.put(key, clientService);
        } else {
            clientService.onRebind();
        }
        return clientService;
    }

    /**
     * While client app unbind with the CoreService, the client should notify ClientManager.
     *
     * @param clientName      Unbind client's name.
     * @param clientSignature Unbind client's signature.
     */
    public void clientUnbind(String clientName, String clientSignature) {
        ClientService clientService;
        String key = genClientKey(clientName, clientSignature);
        clientService = mClientMap.get(key);
        if (clientService != null) {
            clientService.onUnbind();
        }
    }
}
