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
package com.rstar.rstarcore.remote.oauth;

import android.content.Context;

/**
 * @Package: com.rstar.rstarcore.remote.oauth
 * @ClassName: OAuthService
 * @Description: OAuth the client app, then get token and authority from server.
 * @Author: 庆涛
 * @Email: zqt_olive@sina.com
 * @CreateDate: 2019/4/10 17:16
 * @UpdateUser:
 * @UpdateDate: 2019/4/10 17:16
 * @UpdateRemark:
 * @Version: 1.0
 */
public class OAuthService {
    private static final String TAG = OAuthService.class.getSimpleName();

    private Context mContext;

    public OAuthService(Context context) {
        mContext = context;
    }

    /**
     * Make the client app's Authentication with cloud.
     *
     * @param clientName      The client app's name.
     * @param clientSignature The client app's signature.
     * @param clientSecretKey The client app's secret key.
     */
    public void oauth(String clientName, String clientSignature, String clientSecretKey) {

    }
}
