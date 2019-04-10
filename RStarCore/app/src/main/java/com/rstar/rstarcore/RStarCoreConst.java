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

/**
 * @Package: com.rstar.rstarcore
 * @ClassName: RStarCoreConst
 * @Description: Define the RStarCore's const.
 * @Author: 庆涛
 * @Email: zqt_olive@sina.com
 * @CreateDate: 2019/4/10 12:57
 * @UpdateUser:
 * @UpdateDate: 2019/4/10 12:57
 * @UpdateRemark:
 * @Version: 1.0
 */
public interface RStarCoreConst {
    /**
     * Define the key of app package name in bundle.
     */
    String KEY_APP_NAME = "key_app_name";
    /**
     * Define the key of app signature in bundle.
     */
    String KEY_APP_SIGNATURE = "key_app_signature";
    /**
     * Define the app secret key in bundle.
     */
    String KEY_APP_SECRETKEY = "key_app_secretkey";
    /**
     * It's the action connect with RStarCore service.
     */
    String ACTION_CORE_SERVICE = "com.rstar.rstarcore.coreservice";

    /**
     * Define the client manager's type string.
     */
    String SERVICE_TYPE_CLIENT_MANAGER = "service_type_client_manager";
    /**
     * Define the remote service's type string.
     */
    String SERVICE_TYPE_REMOTE_SERVICE = "servicee_type_remote_service";
    /**
     * Define the client's authority manager's type string.
     */
    String SERVICE_TYPE_AUTHORITY_MANAGER = "servicee_type_authority_manager";

    /**
     * Client's authority.
     */
    enum AppAuthority {
        normal, system, root
    }
}
