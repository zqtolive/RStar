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

import com.rstar.rstarcore.IRStarService;

import java.util.HashMap;

public class ClientManager {
    private static final String TAG = ClientManager.class.getSimpleName();
    private HashMap<String, IClient> mClientMap = new HashMap<>();

    private Context mContext;
    private IRStarService mService;

    public ClientManager(IRStarService service, Context context) {
        mService = service;
        mContext = context;
    }
}
