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

/**
 * @Package: com.rstar.rstarcore.client
 * @ClassName: IAppStatusChange
 * @Description: While top app change will call the interface to notify.
 * @Author: 庆涛
 * @Email: zqt_olive@sina.com
 * @CreateDate: 2019/4/14 11:40
 * @UpdateUser:
 * @UpdateDate: 2019/4/14 11:40
 * @UpdateRemark:
 * @Version: 1.0
 */
interface IAppStatusChange {
    /**
     * While the app gain the focus, onResume will be called.
     * @param stoppedApp
     */
    void onResume(String stoppedApp);

    /**
     * While the app lost the focus, onPause will be called.
     * @param resumeApp
     */
    void onPause(String resumeApp);

    /**
     * Get app's package name.
     *
     * @return App's package name.
     */
    String getAppName();
}
