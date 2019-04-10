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

import android.content.Context;

import com.rstar.rstarcore.BaseService;
import com.rstar.rstarcore.IRStarService;

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

    public ClientManager(IRStarService service, Context context) {
        super(service, context);
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
        ClientService clientService = null;
        StringBuilder stringBuilder = new StringBuilder(clientName);
        stringBuilder.append(ClientConst.DIV_CLIENT_KEY).append(clientSignature);
        String key = stringBuilder.toString();
        clientService = mClientMap.get(key);
        if (clientService == null) {
            ClientInfo client = new ClientInfo(clientName, clientSignature, secretKey);
            clientService = new ClientService(client);
            mClientMap.put(key, clientService);
        }
        return clientService;
    }
}
