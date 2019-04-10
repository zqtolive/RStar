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

import com.rstar.rstarcore.RStarCoreConst;

import java.util.ArrayList;

/**
 * @Package: com.rstar.rstarcore.client
 * @ClassName: ClientInfo
 * @Description: The client's details.
 * @Author: 庆涛
 * @Email: zqt_olive@sina.com
 * @CreateDate: 2019/4/10 12:48
 * @UpdateUser:
 * @UpdateDate: 2019/4/10 12:48
 * @UpdateRemark:
 * @Version: 1.0
 */
class ClientInfo {
    private String mClientName;
    private String mSignature;
    private String mSecretKey;
    private RStarCoreConst.AppAuthority mAuthority;
    private ArrayList<ClientHistory> mHistory = new ArrayList<>();

    ClientInfo(String clientName, String clientSignature, String secretKey) {
        mClientName = clientName;
        mSignature = clientSignature;
        mSecretKey = secretKey;
        mHistory.add(new ClientHistory(System.currentTimeMillis()));
    }

    String dump() {
        return null;
    }
}
