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
package com.rstar.rstarcore.remote;

import android.content.Context;

import com.rstar.rstarcore.BaseService;
import com.rstar.rstarcore.IRStarService;
import com.rstar.rstarcore.remote.oauth.OAuthService;

/**
 * @Package: com.rstar.rstarcore.remote
 * @ClassName: RemoteService
 * @Description: Deal the job which communicate with cloud.
 * @Author: 庆涛
 * @Email: zqt_olive@sina.com
 * @CreateDate: 2019/4/10 16:23
 * @UpdateUser:
 * @UpdateDate: 2019/4/10 16:23
 * @UpdateRemark:
 * @Version: 1.0
 */
public class RemoteService extends BaseService {
    private static final String TAG = RemoteService.class.getSimpleName();

    private OAuthService mOAuthService;

    public RemoteService(IRStarService service, Context context) {
        super(service, context);
        mOAuthService = new OAuthService(context);
    }

    /**
     * {@link com.rstar.rstarcore.remote.oauth.OAuthService#oauth(String, String, String)}
     */
    public void oauth(String clientName, String clientSignature, String clientSecretKey) {
        mOAuthService.oauth(clientName, clientSignature, clientSecretKey);
    }
}
