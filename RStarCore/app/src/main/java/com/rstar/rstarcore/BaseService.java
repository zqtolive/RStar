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

import com.rstar.rstarcore.debug.Dumpable;

/**
 * @Package: com.rstar.rstarcore
 * @ClassName: BaseService
 * @Description:
 * @Author: 庆涛
 * @Email: zqt_olive@sina.com
 * @CreateDate: 2019/4/10 16:25
 * @UpdateUser:
 * @UpdateDate: 2019/4/10 16:25
 * @UpdateRemark:
 * @Version: 1.0
 */
public abstract class BaseService implements Dumpable {
    protected IRStarService mService;
    protected Context mContext;

    public BaseService(IRStarService service, Context context) {
        mService = service;
        mContext = context;
    }

    /**
     * Execute special operation in service. Now, we don't realize the method.
     * UnsupportedOperationException will be thrown.
     *
     * @param method Specail operation.
     * @param param  Input parameters.
     * @param out    Output result.
     * @return Execute result.
     */
    public int execute(String method, Bundle param, Bundle out) {
        throw new UnsupportedOperationException("execute don't support now!");
    }

    /**
     * While RStarCore destroy, all service should destroy, then call the function
     * to destroy service.
     */
    public final void destroy() {
        onDestroy();
        mContext = null;
        mService = null;
    }

    /**
     * While service destroy, should notify the service to reset state and variable.
     */
    protected abstract void onDestroy();

    /**
     * Get the service function's description. Display it while dump system information.
     * Make developer know which message can output.
     *
     * @return
     */
    protected abstract String description();
}
